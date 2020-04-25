The DL4J supports models created in other frameworks - like Tensorflow and Keras. Currently, there is some limited support for models created in other frameworks with ONNX. This feature is in alpha and therefore not documented here.  

Models in Tensorflow have to be converted to "frozen" pbs (protobuf). More information on freezing Tensorflow models can be found here. <TODO: link to how to freeze>. Keras models have to be saved in h5 format. More information can be found here <TODO: link>. Importing both Keras 1 and Keras 2 models are supported. Of note - tf.keras and keras are **NOT** compatible. More information about this can be found here <TODO: link>.

The examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.


## Keras  

### Quickstart  
* SimpleSequentialMlpImport.java  
Basic example for importing a Keras Sequential model into DL4J for training or inference.
* SimpleFunctionalMlpImport.java  
Basic example for importing a Keras functional Model into DL4J for training or inference.

### Advanced  
* ImportDeepMoji.java  
Import of DeepMoji application. Demonstrates implementing a custom layer for import.


## Tensorflow  

### Quickstart  
* MNISTMLP.java  
Basic example imports a frozen TF model trained on mnist. Python scripts used available.
* BostonHousingPricesModel.java  
Another basic example with the boston housing prices dataset
* ModifyMNISTMLP.java  
Import a frozen TF model. Demonstrate static execution, modify the graph and then execute it dynamically.

### Advanced  
* ImportMobileNetExample.java  
Import MobileNet and run inference on it to give the same metrics as those obtained in Tensorflow.
* TFGraphRunnerExample.java  
Runs a tensorflow graph from java using the tensorflow graph runner.
* MobileNetTransferLearningExample.java  
Transfer learning on an imported TF mobile net model for CIFAR10
* BertInferenceExample.java  
Run inference on a BERT model trained in Tensorflow to give the same metrics as those obtained in Tensorflow.

