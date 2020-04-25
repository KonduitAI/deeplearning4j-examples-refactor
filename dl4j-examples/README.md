This project contains a set of examples that demonstrate use of the high level DL4J API to build a variety of neural networks. The DL4J ecosystem also allows users to build neural networks with SameDiff (part of the ND4J library) with a more fine grained API. More information on that can be found here <TODO:   link to SameDiff> 

The pom file in this project can be used as a template for a user's own project. The examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.


### QUICKSTART

#### Modeling Examples

##### Feedforward Neural Networks

###### Classification
* IrisClassifier.java  
Basic end to end example that introduces important concepts like RecordReaders, MultiLayerConfiguration etc
* LinearDataClassifier.java  
Basic end to end example with plots
* MNISTSingleLayer.java  
Classify MNIST
* MNISTDoubleLayer.java  
Classify MNIST with more layers
* ModelXOR.java  
Model a two input XOR function (ie. a simple non linearly separable function)
* MoonClassifier.java  
Model data that separates into a "moon" shape
* SaturnClassifier.java  
Model data that separates into a "saturn" shape

###### Regression
* CSVDataModel.java  
Basic end to end example with plots
* MathFunctionsModel.java  
Model various mathematical functions  
* SumModel.java  
Model addition on a synthetic dataset with noise
* ImageDrawer.java  
Train a model to draw an image!

###### Unsupervised
* MNISTAutoencoder.java  
A basic introduction to how to build an autoencoder


##### Convolutional Neural Networks
* LeNetMNIST.java  
The classic LeNet example
* LeNetMNISTReLu.java  
The same as above with minor modifications
* CIFARClassifier.java  
Classify the CIFAR dataset
* CenterLossLeNetMNIST.java  
Train an embedding using the center loss model, on MNIST

##### Recurrent Neural Networks
* UCISequenceClassification.java  
The classic classification example
* MemorizeSequence.java  
Train a RNN to memorize a sequence of characters
* RNNEmbedding.java  
Use an EmbeddingLayer (equivalent to using a DenseLayer with a one-hot representation for the input) as the first layer in an RNN
* VideoFrameClassifier.java  
Classify shapes that appear in a video frame. Demonstrates how to combine RNN, CNN and fully connected dense layers in a single neural network.


##### Variational Auto Encoder
* VaeMNISTAnomaly.java  
Unsupervised anomaly detection on MNIST using a variational autoencoder
* VaeMNIST2dPlots.java  
Train a variational autoencoder on MNIST and plot MNIST digit reconstructions vs. the latent space as well as the latent space values for the MNIST test set as training progresses


#### Features

* SaveLoadMultiLayerNetwork.java  
Save and load a multilayer neural network
* SaveLoadComputationGraph.java  
Save and load a computational graph
* EarlyStoppingMNIST.java  
Early stopping example on a subset of MNIST i.e conduct training and use the parameters that give the minimum test set loss
* LoadPreSavedLenetMnistExample.java  
Save time when training with multiple epochs by presaving datasets
* WeightedLossFunctionExample.java  
Out of the box loss function that can be used with imbalanced classes
* UIExample.java  
Basic UI example
* UIStorageExample.java  
Save training data to a file and reload it later to display in the UI
* RemoteUIExample.java  
If you need the UI to be hosted in a separate JVM for training.
* NearestNeighbor.java  
Basic KNN
* TSNEStandardExample.java  
Basic TSNE

### ADVANCED

#### Modeling Examples

#### Computer Vision
* TinyYoloHouseNumberDetection.java  
Transfer learning from a Tiny YOLO model pretrained on ImageNet and Pascal VOC to perform object detection with bounding boxes on The Street View House Numbers Dataset.
* NeuralStyleTransfer.java  
Neural Style Transfer Algorithm
* MultiDigitNumberRecognition.java  
Captcha recognition

#### Natural Language Processing

##### Text Classification
With pretrained word2vec:  
* ImdbReviewClassificationRNN.java  
Sentiment Classification on the IMDB dataset with a RNN model
* ImdbReviewClassificationCNN.java  
Sentiment Classification on the IMDB dataset with a CNN model

#### Generating Embeddings:  
* GloVeExample.java  
* paragraphvectors.java  
* SequenceVectorsTextExample.java  
* word2vec.java  

Modeling with a word2vec model trained on a custom corpus:  
* PrepareWordVector.java, TrainNews.java 
Sentence classification using a word2vec model training on a custom corpus


##### Char Modelling
* GenerateTxtModel.java & GenerateTxtCharCompGraphModel.java  
MultiLayerNetwork and ComputationGraph versions of a model that is trained to "write Shakespeare", inspired by Andrej Karpathy's now famous blog post. 

#### Other Sequence Modeling Examples
* SequenceAnomalyDetection.java  
Anomaly detection on sequence sensor data
* TrainLotteryModelSeqPrediction.java  
Model trained on a synthetic dataset that attempts to uncover the contrived pattern.


#### Specific Models and Special Architectures
* AlphaGoZeroTrainer
Train AlphaGo Zero model on dummy data.
* DenseNetMain
Builds dense net to classify a small set of animal images. Augments the dataset with transforms like blur etc.
* AdditionModelWithSeq2Seq
A seq2seq model that learns to add
* MixtureDensityNetwork
Example of using a mixture density network to learn the distribution of a dataset instead of trying to converge directly onto the dataset. 

#### Features

##### Customizing DL4J
* CustomActivationUsageEx.java  
Implement custom activation functions
* CustomLayerUsageEx.java  
Implement custom layers
* CustomLossUsageEx.java  
Implement custom loss functions  

NOTE: SameDiff which is part of ND4J gives users a way to customize DL4J. More information on that is found here <TODO: link>

##### Performance
* ParallelInferenceExample.java  

##### Debugging
* CSVExampleEvaluationMetaData.java  
Trace where data from each example comes from and get metadata on prediction errors
* MultiLayerNetworkExternalErrors.java  
Train a MultiLayerNetwork where the errors come from an external source, instead of using an Output layer and a labels array.

##### TransferLearning
Demonstrates use of the dl4j transfer learning API which allows users to construct a model based off an existing model by modifying the architecture, freezing certain parts selectively and then fine tuning parameters. Read the documentation for the Transfer Learning API at [https://deeplearning4j.org/transfer-learning](https://deeplearning4j.org/transfer-learning).  
* EditLastLayerOthersFrozen.java  
Modifies just the last layer in vgg16, freezes the rest and trains the network on the flower dataset.
* FeaturizedPreSave.java & FitFromFeaturized.java  
Save time on the forward pass during multiple epochs by "featurizing" the datasets. FeaturizedPreSave saves the output at the last frozen layer and FitFromFeaturize fits to the presaved data so you can iterate quicker with different learning parameters.
* EditAtBottleneckOthersFrozen.java  
A more complex example of modifying model architecure by adding/removing vertices
* FineTuneFromBlockFour.java  
Reads in a saved model (training information and all) and fine tunes it by overriding its training information with what is specified

Read the documentation for the Transfer Learning API at [https://deeplearning4j.org/transfer-learning](https://deeplearning4j.org/transfer-learning).
