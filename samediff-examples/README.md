This project contains a set of examples that demonstrate use of the SameDiff API to build a variety of neural networks. Neural Networks can also be build using the MultiLayerNetwork and ComputationalGraph APIs as noted here <TODO: link to dl4j-examples>. SameDiff (part of the ND4J library) is a more fine grained API that allows users more flexibility with auto differentiation.  

The pom file in this project can be used as a template for a user's own project. The examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.


## Basics
Ex1_SameDiff_Basics.java  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SameDiff class, variables, functions and forward pass
Ex2_LinearRegression.java  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Placeholders, forward pass and gradient calculations on a simple linear regression graph  
Ex3_Variables.java  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Expounding on few of the multiple ways to create variables

## Modelling
MNISTFeedforward.java  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Create, train, evaluate, save and load a basic feedforward network using SameDiff.  
MNISTCNN.java  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The same as the above but with a CNN network
CustomListenerExample.java  

Note that you could create these exact neural networks with the higher level DL4J API as well.

## Custom DL4J layers
Ex1BasicSameDiffLayerExample.java  
Ex2LambdaLayer.java  
Ex3LambdaVertex.java   

