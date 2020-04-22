One Line Summary:
Import a Tensorflow model, specifically mobilenet into Samediff and run inference on it to give the same metrics as those obtained in Tensorflow.

Expected RunTime:
TODO (as ratio of mnist example & raw numbers on some hardware)

Expected Memory Requirements:
TODO (peak useage, etc etc)

Modelling Statement:
N/A

Modeling Metrics:
TODO

This example demonstrates:
1) How to import a TF frozen graph (.pb) into the DL4J ecosystem?
2) How to resize an image using bilinear interpolation? (Done via a dynamic custom ops.These are ops that are currently available in libnd4j but have not been mapped to Java yet)
3) How to run inference on an imported Tensorflow model?

Recommended Prerequisites:
1) Same Diff basics (TODO: link to example)

Current Limitations:
1) resize bilinear is done via a custom dynamic op which will be available in java eventually

Further Reading:
1) A more advanced example that imports mobilenet and modifies it for CIFAR classification. TODO: link
2) A more advanced example of importing a TF model with BERT. TODO: link
3) TODO: Link to samediff custom op/dynamic op example/TODO: What ops are implemented in CPU only?
