
<pre>
 .                 ########  ##       ##              ##                     .
 .                 ##     ## ##       ##    ##        ##                     .
 .                 ##     ## ##       ##    ##        ##                     .
 .        **$**    ##     ## ##       ##    ##        ##    **$**            .
 .                 ##     ## ##       ######### ##    ##                     .
 .                 ##     ## ##             ##  ##    ##                     .
 .                 ########  ########       ##   ######                      .
 .   :::: :   :    :   :     : ::::  :     ::::    :::::  :::: ::::  :::::   .
 .   :    :   :   : :  ::   :: :   : :     :       :   :  :    :   : :   :   . 
 .   :     : :   :   : : : : : :   : :     :       :   :  :    :   : :   :   . 
 .   :::    :    :   : :  :  : ::::  :     :::     :::::  :::  ::::  :   :   . 
 .   :     : :   ::::: :     : :     :     :       :  :   :    :     :   :   . 
 .   :    :   :  :   : :     : :     :     :       :   :  :    :     :   :   . 
 .   :::: :   :  :   : :     : :     ::::: ::::    :    : :::: :     :::::   .   
</pre>

The **Eclipse DL4J** ecosystem is a set of projects intended to support all the needs of a JVM based deep learning application. This means starting with the raw data, loading and preprocessing it from wherever and whatever format it is in to building and tuning a wide variety of simple and complex deep learning networks. 
<TODO: Link to Konduit serving explaining what it is?>

The DL4J stack comprises of:
- **DL4J**: High level API to build MultiLayerNetworks and ComputationGraphs with a variety of layers, including custom ones. Supports importing Keras models from h5
- **ND4J**: General purpose linear algebra library and automatic differentiantion graph engine called SameDiff. Supports static (ala Tensorflow) and dynamic (ala Tensorflow eager/PyTorch)  style graph execution. Supports importing Tensorflow .pb (protobuf) models, as well as some support for ONNX models 
- **DataVec**: ETL for data in a wide variety of formats and files (HDFS, Spark, Images, Video, Audio etc)
- **Arbiter**: Library for hyperparameter search
- **LibND4J** : C++ library that underpins everything. For more information on how the JVM acceses native arrays and operations refer to <TODO:link> JavaCPP

<TODO: Link to Konduit serving explaining what it is>

This example repo consists of several separate maven Java projects, with their own pom files. Projects are based on what functionality the included examples demonstrate to the user and not necessarily which library in the DL4J stack the functionality lives in. Examples in a project are in general separated into "quickstart" and "advanced". Each project README also lists all the examples it contains, with a recommended order to explore them in. 

- dl4j-examples  
This project contains a set of examples that demonstrate use of the high level DL4J API to build a variety of neural networks. Some these examples are end to end, in the sense they start with raw data, process it and then build and train neural networks on it. More information present in the project README here <TODO: Link to README>

- tensorflow-keras-import-examples  
This project contains a set of examples that demonstrate how to import keras h5 models and TF frozen pb models into the DL4J ecosystem. Once imported into DL4J these models can be treated like any other DL4J model - meaning you can continue to run training on them or modify them with the transfer learning API or simply run inference on them. More information present in the project README here <TODO: Link to README>

- dl4j-distributed-training-examples  
This project contains a set of examples that demonstrate how to do distributed training in DL4J. DL4J distributed training employs a "hybrid" asynchronous SGD based on Niko Strom's paper linked here<TODO: Link to paper>. More information present in the project README here <TODO: Link to README>

- cuda-specific-examples  
This project contains a set of examples that demonstrate how to leverage a multi-gpus for increased performance. More information present in the project README here <TODO: Link to README> 

- samediff-examples  
This projects contains a set of examples that demonstrate the SameDiff API. SameDiff (which is part of the ND4J library) can be used to build lower level auto-differentiating computation graphs. An analogue to the SameDiff API vs the DL4J API is the low level TF API vs the higher level of abstraction Keras API.

- data-pipeline-examples  
This project contains a set of examples that demonstrate how raw data in various formats can be loaded, split and preprocessed to build serializable (and hence reproducible) ETL pipelines. More information present in the project README here <TODO: Link to README>

- ndarray-operation-examples  
This project contains a set of examples that demonstrate how to manipulate NDArrays. The functionality of ND4J demonstrated here can be likened to numpy. More information present in the project README here <TODO: Link to README>

- arbiter-examples  
This project contains a set of examples that demonstrate useage of the Arbiter library for hyperparameter tuning. More information present in the project README here <TODO: Link to README>

While these set of examples don't cover all the functionality available in DL4J the intent is that it will cover the functionality required for most users - beginners and advanced.  File an issue (TODO:link) if you have feedback. We **love** hearing from you. We are also available via our discourse community channel (TODO:link) for questions. Cheers!
