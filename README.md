# < WIP > deeplearning4j-examples-refactor

Separate repos for:
If checked all examples have been migrated
- [X] Introduction to DL4J
- [X] Introduction to samediff
- [X] ND4J array manipulation examples
- [X] Data preprocessing/Datavec examples {migrated everything but hdfs ex}
- [X] Model import
- [ ] jumpy {errors now - checking with Fariz}
- [ ] pydatavec {errors now}
- [ ] Cuda specific examples {everything migrated}
- [X] Distributed training
- [X] Arbiter examples
- [ ] java fx examples??

Outstanding decisions to be made on:
- [X] Review and polish structure of the repo, i.e how to break up the examples
	{not sure about dl4j-spark-cluster,lsm/hdfs examples}
- [X] Maybe the utilities should go into the main repo? Esp. word2vec download to avoid code duplication across projects
- [X] Have a "introduction to .." with all the introductory examples
- [X] Should UI examples be a separate dir?
	{yes, in quickstart under dl4j-examples}
- [X] lstm/hdfs examples??
- [ ] RL4J examples to a separate repo?
	{Rob is working on this}
- [X] legacy spark examples??
	{remove}
- [ ] attempt auto formatting??

To dos: 
- [ ] Everything runs or issues filed
- [ ] Tune poorly tuned examples
- [ ] Add readme to each project with ??
- [ ] Clean up printing with unnecessary json etc
- [ ] Clean up comments
- [X] Add code to download w2vec model if it's not already present
- [ ] Check all poms for unnecessary version properties etc
- [ ] Fix logging levels (missing xml in some projects)
- [ ] What's with the vulnerability warning on github?

With a GPU/a real dev box run and verify long running examples which are:
- [ ] cuda specific project, all
- [ ] spark examples, all

Notes to not forget:
- Maybe include runtimes with examples to give users an idea
- Quick start examples should include running the UI
- Quick start examples should be ordered
- Add follow to an example like after CSVExample run CSVExampleEvaluationMetaData
