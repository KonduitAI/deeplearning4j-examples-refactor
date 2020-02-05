# < WIP > deeplearning4j-examples-refactor

Separate repos for:
If checked all examples have been migrated to and they have been verified to 
run
- [ ] Quick start to DL4J
- [ ] Quick start to samediff
- [X] ND4J array manipulation examples
- [X] Data preprocessing/Datavec examples
- [ ] End to end examples in DL4J and samediff
- [X] Model import
- [ ] jumpy
- [ ] pydatavec
- [ ] Cuda specific examples
- [ ] Distributed training
- [ ] Android examples
- [X] Arbiter examples
- [ ] RL4J

Outstanding decisions to be made on:
- [ ] Maybe the utilities should go into the main repo? Esp. word2vec download to avoid code duplication across projects
- [ ] Have a "introduction to .." with all the introductory examples
- [ ] Should UI examples be a separate dir?
- [ ] lstm/hdfs examples??
- [ ] RL4J examples to a separate repo?
- [ ] Review and polish structure of the repo
- [ ] legacy spark examples??
- [ ] java fx examples??
- [ ] attempt auto formatting??

To dos: 
- [ ] Add readme to each project with ??
- [ ] Clean up printing with unnecessary json etc
- [ ] Clean up comments
- [ ] Add code to download w2vec model if it's not already present

With a GPU/a real dev box run and verify long running examples which are:
- [ ] cuda specific project, all
- [ ] spark examples, all
- [ ] rl4j examples, all
- [ ] Fix logging levels (missing xml in some projects)
- [ ] Check all poms for unnecessary version properties etc
- [ ] Android examples??

Notes to not forget:
- Maybe include runtimes with examples to give users an idea
- Quick start examples should include running the UI
- Quick start examples should be ordered
- Add follow to an example like after CSVExample run CSVExampleEvaluationMetaData
