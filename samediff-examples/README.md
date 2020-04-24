This project contains a set of examples that demonstrate use of the SameDiff API (part of the Eclipse

Neural Networks can also be build using the MultiLayerNetwork and ComputationalGraph APIs as noted here <TODO: link to dl4j-examples>. SameDiff (part of the ND4J library) is a more fine grained API that give users more flexibility along with auto differentiation capabilities.  
The examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.
#### Basics
  * Ex1_SameDiff_Basics.java  
SameDiff class, variables, functions and forward pass
  * Ex2_LinearRegression.java  
Placeholders, forward pass and gradient calculations on a simple linear regression graph  
  * Ex3_Variables.java  
Alternate ways to create variables

#### Modelling
 * MNISTFeedforward.java  
Create, train, evaluate, save and load a basic feedforward network using SameDiff.  
 * MNISTCNN.java  
The same as the above but with a CNN network
 * CustomListenerExample.java  
Implementing a basic custom listener that records the values of 2 variables, for comparison or printing later.  

Note that you could create these exact neural networks using the higher level DL4J API as well.

#### Custom DL4J Layers and Vertices
* Ex1BasicSameDiffLayerExample.java   
Implement a custom DL4J layer using SameDiff.
* Ex2LambdaLayer.java  
Implement a simple custom DL4J lambda layer using SameDiff.
* Ex3LambdaVertex.java  
Implement a simple custom DL4J lambda vertex using SameDiff.

