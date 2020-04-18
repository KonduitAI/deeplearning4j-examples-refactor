One Line Summary:
Import a fine tuned BERT model from Tensorflow into Samediff and run inference on it to give the same metrics as those obtained in Tensorflow.

Expected RunTime:
TODO (as ratio of mnist example & raw numbers on some hardware)

Expected Memory Requirements:
TODO (peak useage, etc etc)

Modelling Statement:
A model based on BERT was finetuned on the the MRPC dataset in Tensorflow to classify document pairs as like or unlike.
The trained model was converted to a pb file and imported into samediff. Python scripts for tuning and pb generation are linked in this document.

Modeling Metrics:
Accuracy: 84 % 
F1 Score: 0.89

This example demonstrates:
1) How to import a TF frozen graph (.pb) into the DL4J ecosystem?
2) How to perform advanced operations in samediff? For eg. removing hard coded drop out ops in the TF graph for inference.
3) How to set up a SameDiff graph to generate Evaluation data?
4) How to set up an NLP pipeline for BERT going from raw text in a csv file to a BertIterator that gives feeds the model with the featurized text?
5) How to run inference on a single minibatch on a samediff graph?

Recommended Prerequisites:
1) Familiarity with the SentenceProvider class in DataVec(DL4J?) 
2) Familiarity with the DL4J iterator classes
3) Familiarity with Evaluation classes in DL4J

Current Limitations:
1) Only inference available on BERT models i.e. further training an imported BERT model in samediff is not available (TODO: link to issue)
2) Batchsizes in TF graphs are fixed and therefore also fixed in samediff (TODO: ?)
3) Bert tokenizer only available for the sentence classification task (TODO: ?)

Further Reading:
1) BERT unit tests and links to the python scripts for TF training and pb generation. (TODO: link)
2) BERTTokenizer javadoc
3) BERTIterator javadoc
