/*******************************************************************************
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

package org.deeplearning4j.examples.quickstart.features.tsne;

import org.deeplearning4j.models.embeddings.inmemory.InMemoryLookupTable;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.wordstore.VocabCache;
import org.deeplearning4j.plot.BarnesHutTsne;
import org.deeplearning4j.examples.utils.DownloaderUtility;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.common.primitives.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agibsonccc on 9/20/14.
 * <p>
 * Dimensionality reduction for high-dimension datasets
 */
public class TSNEStandardExample {
    private static Logger log = LoggerFactory.getLogger(TSNEStandardExample.class);
    public static String dataLocalPath;

    public static void main(String[] args) throws Exception {
        dataLocalPath = DownloaderUtility.NLPDATA.Download();
        //STEP 1: Initialization
        int iterations = 100;
        //create an n-dimensional array of doubles
        Nd4j.setDefaultDataTypes(DataType.DOUBLE, DataType.DOUBLE);
        List<String> cacheList = new ArrayList<>(); //cacheList is a dynamic array of strings used to hold all words

        //STEP 2: Turn text input into a list of words
        log.info("Load & Vectorize data....");
        File wordFile = new File(dataLocalPath,"words.txt");   //Open the file
        //Get the data of all unique word vectors
        Pair<InMemoryLookupTable, VocabCache> vectors = WordVectorSerializer.loadTxt(wordFile);
        VocabCache cache = vectors.getSecond();
        INDArray weights = vectors.getFirst().getSyn0();    //seperate weights of unique words into their own list

        for (int i = 0; i < cache.numWords(); i++)   //seperate strings of words into their own list
            cacheList.add(cache.wordAtIndex(i));

        //STEP 3: build a dual-tree tsne to use later
        log.info("Build model....");
        BarnesHutTsne tsne = new BarnesHutTsne.Builder()
            .setMaxIter(iterations).theta(0.5)
            .normalize(false)
            .learningRate(500)
            .useAdaGrad(false)
//                .usePca(false)
            .build();

        //STEP 4: establish the tsne values and save them to a file
        log.info("Store TSNE Coordinates for Plotting....");
        String outputFile = "target/archive-tmp/tsne-standard-coords.csv";
        (new File(outputFile)).getParentFile().mkdirs();

        tsne.fit(weights);
        tsne.saveAsFile(cacheList, outputFile);
        //This tsne will use the weights of the vectors as its matrix, have two dimensions, use the words strings as
        //labels, and be written to the outputFile created on the previous line
        // Plot Data with gnuplot
        //    set datafile separator ","
        //    plot 'tsne-standard-coords.csv' using 1:2:3 with labels font "Times,8"
        //!!! Possible error: plot was recently deprecated. Might need to re-do the last line
        //
        // If you use nDims=3 in the call to tsne.plot above, you can use the following gnuplot commands to
        // generate a 3d visualization of the word vectors:
        //    set datafile separator ","
        //    splot 'tsne-standard-coords.csv' using 1:2:3:4 with labels font "Times,8"
    }


}
