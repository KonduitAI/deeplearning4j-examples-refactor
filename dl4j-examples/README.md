This project contains a set of examples that demonstrate use of the high level DL4J API to build a variety of neural networks. The DL4J ecosystem also allows users to build neural networks with SameDiff (part of the ND4J library) with a more fine grained API. More information on that can be found here <TODO: link to SameDiff> 

The pom file in this project can be used as a template for a user's own project. The examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.


## QUICKSTART

### Modeling Examples

#### Feedforward Neural Networks

##### Classification
 IrisClassifier.java

 LinearDataClassifier.java

 MNISTSingleLayer.java

 MNISTDoubleLayer.java

 ModelXOR.java

 MoonClassifier.java

 SaturnClassifier.java


##### Regression
 CSVDataModel.java

 MathFunctionsModel.java

 SumModel.java

 ImageDrawer.java

 AnimalClassifier.java


##### Unsupervised
 MNISTAutoencoder.java


#### Convolutional Neural Networks
 LeNetMNIST.java

 LeNetMNISTReLu.java

 CIFARClassifier.java

 CenterLossLeNetMNIST.java


#### Recurrent Neural Networks
 UCISequenceClassification.java

 MemorizeSequence.java

 RNNEmbedding.java

 VideoFrameClassifier.java


#### Variational Auto Encoder
 VaeMNISTAnomaly.java

 VaeMNIST2dPlots.java


### Features

 SaveLoadMultiLayerNetwork.java

 SaveLoadComputationGraph.java

 EarlyStoppingMNIST.java

 LoadPreSavedLenetMnistExample.java

 WeightedLossFunctionExample.java

 UIExample.java

 UIStorageExample.java

 RemoteUIExample.java

 NearestNeighbor.java

 TSNEStandardExample.java



## ADVANCED

### Modeling Examples

### Computer Vision
 TinyYoloHouseNumberDetection.java

 NeuralStyleTransfer.java

 MultiDigitNumberRecognition.java


### Natural Language Processing

#### Text Classification
With pretrained word2vec:
 ImdbReviewClassificationCNN.java
 
 ImdbReviewClassificationRNN.java


With a word2vec model trained on the custom corpus:
 PrepareWordVector.java

 TrainNews.java


### Generating embeddings:
 GloVeExample.java

 paragraphvectors.java

 SequenceVectorsTextExample.java

 word2vec.java


#### Char Modelling
 GenerateTxtModel.java
 & GenerateTxtCharCompGraphModel.java

### Other Sequence Modeling Examples
 SequenceAnomalyDetection.java

 TrainLotteryModelSeqPrediction.java


### Specific Models and Special Architectures
 AlphaGoZeroTrainer
 DenseNetMain
 AdditionModelWithSeq2Seq
 MixtureDensityNetwork

### Features

#### Customizing DL4J
 CustomActivationUsageEx.java

 CustomLayerUsageEx.java

 CustomLossUsageEx.java


#### Performance
 ParallelInferenceExample.java


#### Debugging
 CSVExampleEvaluationMetaData.java

 MultiLayerNetworkExternalErrors.java


#### TransferLearning
 EditLastLayerOthersFrozen.java

 FeaturizedPreSave.java
 & FitFromFeaturized.java
 EditAtBottleneckOthersFrozen.java

 FineTuneFromBlockFour.java

 EditAtBottleneckOthersFrozen.java

