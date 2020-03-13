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
- [ ] lstm-hdfs examples??
- [ ] jumpy {errors now, python 3 support}
- [ ] pydatavec {errors now, python 3 support?}
- [ ] java fx examples??
- [ ] Android
- [ ] RL4J
- [ ] legacy spark examples - removed

To dos: 
- [X] Add code to download w2vec model if it's not already present
- [ ] Everything runs or issues filed
- [ ] Tune poorly tuned examples
- [ ] Add readme to each project with (check TEMPLATE_PLAN doc)
- [ ] Clean up printing with unnecessary json etc
- [ ] Clean up comments
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
- Attempt auto formatting??
