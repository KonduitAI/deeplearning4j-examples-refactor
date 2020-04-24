This project contains a set of examples that demonstrate how to do distributed training in DL4J. DL4J distributed training employs a "hybrid" asynchronous SGD based on Niko Strom's paper linked here<TODO>. More information on DL4J's distributed training methods and how they work can be found here<TODO: link>.  

Of note - Spark is only relied upon for three specific tasks: 1) Broadcasting the initial neural network parameters to all workers 2) Distributing the RDD datasets to the workers 3) Spark's fault tolerance system to detect and bring up a replacement workers. For all other communication between nodes like transferring quantized gradient updates Aeron is used.  

The examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.

tinyimagenet.java  
patent.java
