The DL4J supports models created in other frameworks - like Tensorflow and Keras. Currently, there is some limited support for models created in other frameworks with ONNX. This feature is in alpha and therefore not documented here. Models in Tensorflow have to be converted to "frozen" pbs (protobuf). More information on freezing Tensorflow models can be found here. <TODO: link to how to freeze>. Keras models have to be saved in h5 format. More information can be found here <TODO: link>. Importing both Keras 1 and Keras 2 models are supported. Of note - tf.keras and keras are **NOT** compatible. More information about this can be found here <TODO: link>.

The examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.


## Keras  

### Quickstart  
SimpleSequentialMlpImport.java  
SimpleFunctionalMlpImport.java  

### Advanced  
ImportDeepMoji.java  


## Tensorflow  

### Quickstart  
MNISTMLP.java  
BostonHousingPricesModel.java  
ModifyMNISTMLP.java  

### Advanced  
ImportMobileNetExample.java  
TFGraphRunnerExample.java  
MobileNetTransferLearningExample.java  
BertInferenceExample.java  

