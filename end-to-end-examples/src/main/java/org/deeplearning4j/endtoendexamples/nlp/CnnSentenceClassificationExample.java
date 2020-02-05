/* *****************************************************************************
 * Copyright (c) 2015-2019 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.deeplearning4j.endtoendexamples.nlp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.deeplearning4j.endtoendexamples.utils.DataUtilities;
import org.deeplearning4j.iterator.CnnSentenceDataSetIterator;
import org.deeplearning4j.iterator.CnnSentenceDataSetIterator.Format;
import org.deeplearning4j.iterator.LabeledSentenceProvider;
import org.deeplearning4j.iterator.provider.FileLabeledSentenceProvider;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;
import org.deeplearning4j.nn.api.Layer;
import org.deeplearning4j.nn.conf.ComputationGraphConfiguration;
import org.deeplearning4j.nn.conf.ConvolutionMode;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.graph.MergeVertex;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.ConvolutionLayer;
import org.deeplearning4j.nn.conf.layers.GlobalPoolingLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.conf.layers.PoolingType;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.api.InvocationType;
import org.deeplearning4j.optimize.listeners.EvaluativeListener;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.nd4j.resources.Downloader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Convolutional Neural Networks for Sentence Classification - https://arxiv.org/abs/1408.5882
 * Specifically, this is the 'static' model from there
 *
 * @author Alex Black
 */
public class CnnSentenceClassificationExample {

    //Location to save and extract the training/testing data
    public static final String DATA_PATH = FilenameUtils.concat(System.getProperty("java.io.tmpdir"), "dl4j_w2vSentiment/");
    public static final String DATA_URL = "http://ai.stanford.edu/~amaas/data/sentiment/aclImdb_v1.tar.gz";
    //Location (local file system) for the Google News vectors. Set this manually if available locally.
    private static String wordVectorsPath = "/PATH/TO/YOUR/VECTORS/GoogleNews-vectors-negative300.bin.gz";

    public static void main(String[] args) throws Exception {
        if (wordVectorsPath.startsWith("/PATH/TO/YOUR/VECTORS/")) {
            System.out.println("wordVectorsPath has not been set. Checking default location in ~/dl4j-examples-data for download...");
            checkDownloadW2VECModel();
        }
        //Download and extract data
        downloadData();

        //Basic configuration
        int batchSize = 32;
        int vectorSize = 300;               //Size of the word vectors. 300 in the Google News model
        int nEpochs = 1;                    //Number of epochs (full passes of training data) to train on
        int truncateReviewsToLength = 256;  //Truncate reviews with length (# words) greater than this

        int cnnLayerFeatureMaps = 100;      //Number of feature maps / channels / depth for each CNN layer
        PoolingType globalPoolingType = PoolingType.MAX;
        Random rng = new Random(12345); //For shuffling repeatability

        //Set up the network configuration. Note that we have multiple convolution layers, each wih filter
        //widths of 3, 4 and 5 as per Kim (2014) paper.

        Nd4j.getMemoryManager().setAutoGcWindow(5000);

        ComputationGraphConfiguration config = new NeuralNetConfiguration.Builder()
                .weightInit(WeightInit.RELU)
                .activation(Activation.LEAKYRELU)
                .updater(new Adam(0.01))
                .convolutionMode(ConvolutionMode.Same)      //This is important so we can 'stack' the results later
                .l2(0.0001)
                .graphBuilder()
                .addInputs("input")
                .addLayer("cnn3", new ConvolutionLayer.Builder()
                        .kernelSize(3, vectorSize)
                        .stride(1, vectorSize)
                        .nOut(cnnLayerFeatureMaps)
                        .build(), "input")
                .addLayer("cnn4", new ConvolutionLayer.Builder()
                        .kernelSize(4, vectorSize)
                        .stride(1, vectorSize)
                        .nOut(cnnLayerFeatureMaps)
                        .build(), "input")
                .addLayer("cnn5", new ConvolutionLayer.Builder()
                        .kernelSize(5, vectorSize)
                        .stride(1, vectorSize)
                        .nOut(cnnLayerFeatureMaps)
                        .build(), "input")
                //MergeVertex performs depth concatenation on activations: 3x[minibatch,100,length,300] to 1x[minibatch,300,length,300]
                .addVertex("merge", new MergeVertex(), "cnn3", "cnn4", "cnn5")
                //Global pooling: pool over x/y locations (dimensions 2 and 3): Activations [minibatch,300,length,300] to [minibatch, 300]
                .addLayer("globalPool", new GlobalPoolingLayer.Builder()
                        .poolingType(globalPoolingType)
                        .dropOut(0.5)
                        .build(), "merge")
                .addLayer("out", new OutputLayer.Builder()
                        .lossFunction(LossFunctions.LossFunction.MCXENT)
                        .activation(Activation.SOFTMAX)
                        .nOut(2)    //2 classes: positive or negative
                        .build(), "globalPool")
                .setOutputs("out")
                //Input has shape [minibatch, channels=1, length=1 to 256, 300]
                .setInputTypes(InputType.convolutional(truncateReviewsToLength, vectorSize, 1))
                .build();

        ComputationGraph net = new ComputationGraph(config);
        net.init();

        System.out.println("Number of parameters by layer:");
        for (Layer l : net.getLayers()) {
            System.out.println("\t" + l.conf().getLayer().getLayerName() + "\t" + l.numParams());
        }

        //Load word vectors and get the DataSetIterators for training and testing
        System.out.println("Loading word vectors and creating DataSetIterators");
        WordVectors wordVectors = WordVectorSerializer.loadStaticModel(new File(wordVectorsPath));
        DataSetIterator trainIter = getDataSetIterator(true, wordVectors, batchSize, truncateReviewsToLength, rng);
        DataSetIterator testIter = getDataSetIterator(false, wordVectors, batchSize, truncateReviewsToLength, rng);

        System.out.println("Starting training");
        net.setListeners(new ScoreIterationListener(100), new EvaluativeListener(testIter, 1, InvocationType.EPOCH_END));
        net.fit(trainIter, nEpochs);


        //After training: load a single sentence and generate a prediction
        String pathFirstNegativeFile = FilenameUtils.concat(DATA_PATH, "aclImdb/test/neg/0_2.txt");
        String contentsFirstNegative = FileUtils.readFileToString(new File(pathFirstNegativeFile), (Charset) null);
        INDArray featuresFirstNegative = ((CnnSentenceDataSetIterator) testIter).loadSingleSentence(contentsFirstNegative);

        INDArray predictionsFirstNegative = net.outputSingle(featuresFirstNegative);
        List<String> labels = testIter.getLabels();

        System.out.println("\n\nPredictions for first negative review:");
        for (int i = 0; i < labels.size(); i++) {
            System.out.println("P(" + labels.get(i) + ") = " + predictionsFirstNegative.getDouble(i));
        }
    }


    private static DataSetIterator getDataSetIterator(boolean isTraining, WordVectors wordVectors, int minibatchSize,
                                                      int maxSentenceLength, Random rng) {
        String path = FilenameUtils.concat(DATA_PATH, (isTraining ? "aclImdb/train/" : "aclImdb/test/"));
        String positiveBaseDir = FilenameUtils.concat(path, "pos");
        String negativeBaseDir = FilenameUtils.concat(path, "neg");

        File filePositive = new File(positiveBaseDir);
        File fileNegative = new File(negativeBaseDir);

        Map<String, List<File>> reviewFilesMap = new HashMap<>();
        reviewFilesMap.put("Positive", Arrays.asList(Objects.requireNonNull(filePositive.listFiles())));
        reviewFilesMap.put("Negative", Arrays.asList(Objects.requireNonNull(fileNegative.listFiles())));

        LabeledSentenceProvider sentenceProvider = new FileLabeledSentenceProvider(reviewFilesMap, rng);

        return new CnnSentenceDataSetIterator.Builder(Format.CNN2D)
                .sentenceProvider(sentenceProvider)
                .wordVectors(wordVectors)
                .minibatchSize(minibatchSize)
                .maxSentenceLength(maxSentenceLength)
                .useNormalizedWordVectors(false)
                .build();
    }

    public static void checkDownloadW2VECModel() throws IOException {
        String defaultwordVectorsPath = FilenameUtils.concat(System.getProperty("user.home"), "dl4j-examples-data/w2vec300");
        String md5w2vec = "1c892c4707a8a1a508b01a01735c0339";
        wordVectorsPath = new File(defaultwordVectorsPath, "GoogleNews-vectors-negative300.bin.gz").getAbsolutePath();
        if (new File(wordVectorsPath).exists()) {
            System.out.println("\n\tGoogleNews-vectors-negative300.bin.gz file found at path: " + defaultwordVectorsPath);
            System.out.println("\tChecking md5 of existing file..");
            if (Downloader.checkMD5OfFile(md5w2vec, new File(wordVectorsPath))) {
                System.out.println("\tExisting file hash matches.");
                return;
            } else {
                System.out.println("\tExisting file hash doesn't match. Retrying download...");
            }
        } else {
            System.out.println("\n\tNo previous download of GoogleNews-vectors-negative300.bin.gz found at path: " + defaultwordVectorsPath);
        }
        System.out.println("\tWARNING: GoogleNews-vectors-negative300.bin.gz is a 1.5GB file.");
        System.out.println("\tPress \"ENTER\" to start a download of GoogleNews-vectors-negative300.bin.gz to " + defaultwordVectorsPath);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Starting model download (1.5GB!)...");
        Downloader.download("Word2Vec", new URL("https://dl4jdata.blob.core.windows.net/resources/wordvectors/GoogleNews-vectors-negative300.bin.gz"), new File(wordVectorsPath), md5w2vec, 5);
        System.out.println("Successfully downloaded word2vec model to " + wordVectorsPath);
    }

    public static void downloadData() throws Exception {
        //Create directory if required
        File directory = new File(DATA_PATH);
        if (!directory.exists()) directory.mkdir();

        //Download file:
        String archizePath = DATA_PATH + "aclImdb_v1.tar.gz";
        File archiveFile = new File(archizePath);
        String extractedPath = DATA_PATH + "aclImdb";
        File extractedFile = new File(extractedPath);

        if (!archiveFile.exists()) {
            System.out.println("Starting data download (80MB)...");
            FileUtils.copyURLToFile(new URL(DATA_URL), archiveFile);
            System.out.println("Data (.tar.gz file) downloaded to " + archiveFile.getAbsolutePath());
            //Extract tar.gz file to output directory
            DataUtilities.extractTarGz(archizePath, DATA_PATH);
        } else {
            //Assume if archive (.tar.gz) exists, then data has already been extracted
            System.out.println("Data (.tar.gz file) already exists at " + archiveFile.getAbsolutePath());
            if (!extractedFile.exists()) {
                //Extract tar.gz file to output directory
                DataUtilities.extractTarGz(archizePath, DATA_PATH);
            } else {
                System.out.println("Data (extracted) already exists at " + extractedFile.getAbsolutePath());
            }
        }
    }
}
