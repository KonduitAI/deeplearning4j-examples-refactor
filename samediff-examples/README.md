This project contains a set of examples that demonstrate the use of the SameDiff API. SameDiff is an automatic differentiation computation graph engine which is part of the Eclipse ND4J library. It supports static (`a la Tensorflow) and dynamic (`a la Tensorflow Eager/PyTorch) style graph execution. It also supports importing Tensorflow .pb (protobuf) models, as well as some support for ONNX models. Examples of importing TF models can be found [here](../tensorflow-keras-import-examples)

It is to be noted that neural networks can also be build using the higher level MultiLayerNetwork and ComputationalGraph DL4J APIs as noted [here](../dl4j-examples)

The examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.
#### Basics
* [Ex1_SameDiff_Basics.java](./src/main/java/org/nd4j/examples/samediff/quickstart/basics/Ex1_SameDiff_Basics.java)  
SameDiff class, variables, functions and forward pass
* [Ex2_LinearRegression.java](./src/main/java/org/nd4j/examples/samediff/quickstart/basics/Ex2_LinearRegression.java)  
Placeholders, forward pass and gradient calculations on a simple linear regression graph  
* [Ex3_Variables.java](./src/main/java/org/nd4j/examples/samediff/quickstart/basics/Ex3_Variables.java)  
Alternate ways to create variables

#### Modelling
* [MNISTFeedforward.java](./src/main/java/org/nd4j/examples/samediff/quickstart/modeling/MNISTFeedforward.java)  
Create, train, evaluate, save and load a basic feedforward network using SameDiff.  
* [MNISTCNN.java](./src/main/java/org/nd4j/examples/samediff/quickstart/modeling/MNISTCNN.java)  
The same as the above but with a CNN network
* [CustomListenerExample.java](./src/main/java/org/nd4j/examples/samediff/quickstart/modeling/CustomListenerExample.java)  
Implementing a basic custom listener that records the values of 2 variables, for comparison or printing later.  

#### Custom DL4J Layers and Vertices
DL4J has supported custom layers for a long time. However, using SameDiff layers has some advantages described [here](src/main/java/org/nd4j/examples/samediff/customizingdl4j/README.md).

* [Ex1BasicSameDiffLayerExample.java](./src/main/java/org/nd4j/examples/samediff/customizingdl4j/Ex1BasicSameDiffLayerExample.java)   
Implement a custom DL4J layer using SameDiff.
* [Ex2LambdaLayer.java](./src/main/java/org/nd4j/examples/samediff/customizingdl4j/Ex2LambdaLayer.java)  
Implement a simple custom DL4J lambda layer using SameDiff.
* [Ex3LambdaVertex.java](./src/main/java/org/nd4j/examples/samediff/customizingdl4j/Ex3LambdaVertex.java)  
Implement a simple custom DL4J lambda vertex using SameDiff.

