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
* NeuralStyleTransfer.java  
* MultiDigitNumberRecognition.java  


#### Natural Language Processing

##### Text Classification
With pretrained word2vec:  
ImdbReviewClassificationCNN.java  
ImdbReviewClassificationRNN.java  

With a word2vec model trained on the custom corpus:  
PrepareWordVector.java  
TrainNews.java  


#### Generating embeddings:  
GloVeExample.java  
paragraphvectors.java  
SequenceVectorsTextExample.java  
word2vec.java  


##### Char Modelling
GenerateTxtModel.java & GenerateTxtCharCompGraphModel.java  

#### Other Sequence Modeling Examples
SequenceAnomalyDetection.java  

TrainLotteryModelSeqPrediction.java  


#### Specific Models and Special Architectures
AlphaGoZeroTrainer
DenseNetMain
AdditionModelWithSeq2Seq
MixtureDensityNetwork

#### Features

##### Customizing DL4J
CustomActivationUsageEx.java  
CustomLayerUsageEx.java  
CustomLossUsageEx.java  

##### Performance
ParallelInferenceExample.java  

##### Debugging
CSVExampleEvaluationMetaData.java  
MultiLayerNetworkExternalErrors.java  

##### TransferLearning
EditLastLayerOthersFrozen.java  
FeaturizedPreSave.java & FitFromFeaturized.java  
EditAtBottleneckOthersFrozen.java  
FineTuneFromBlockFour.java  
EditAtBottleneckOthersFrozen.java  
