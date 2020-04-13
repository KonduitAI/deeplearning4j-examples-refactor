# < WIP > deeplearning4j-examples-refactor

If checked all examples have been migrated
- [X] Introduction to DL4J
- [X] Introduction to samediff
- [X] ND4J array manipulation examples
- [X] Data preprocessing/Datavec examples 
- [X] Model import
- [X] Cuda specific examples {everything migrated}
- [X] Distributed training
- [X] Arbiter examples
- [X] lstm-hdfs examples? - removed
- [X] jumpy {errors now, python 3 support - removed
- [X] pydatavec {errors now, python 3 support?} - removed
- [X] java fx examples?? - moved
- [ ] Android
- [X] RL4J
- [X] legacy spark examples - removed

To dos: 
- [X] Everything runs or issues filed
- [ ] Add readme to each project that lists one line summary of each example and links to example md file
- [ ] Add a .md file per example per TEMPLATE
- [ ] Tune poorly tuned examples
- [ ] Clean up printing with unnecessary json etc
- [ ] Clean up comments
- [ ] Check all poms for unnecessary version properties etc
- [ ] Fix logging levels (missing xml in some projects)
- [ ] What's with the vulnerability warning on github?



The Eclipse DL4J stack is a set of projects intended to support all the needs of
a JVM based deep learning application from loading and preprocessing raw data wherever and whatever format it may be to building and tuning a wide variety of simple and complex neural networks.
<TODO: Explain difference between DL4J and SameDiff in the context of model import and other>
Here are the list of projects the stack comprises of:
- DL4J
	* Allows you to build MultiLayerNetworks and ComputationGraphs that with a variety of layers <TODO: Link to different layers>; Supports custom layers etc
	* Supports importing Keras models
- ND4J
	* General purpose linear algebra library and automatic differentiantion graph $engine called SameDiff. Supports static and dynamic graph execution.
	* Supports importing Tensorflow models
- DataVec
	* ETL for data in a wide variety of formats and files (HDFS, Spark, Images, Video, Audio etc)
- Arbiter
	* Library for hyperparameter searches
- LibND4J
	* C++ library that powers everything. For more information on how the JVM acceses native arrays and operations refer to <TODO> JavaCPP

<TODO: Link to Konduit serving explaining what it is>
