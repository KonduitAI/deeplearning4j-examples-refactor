Switching from a CPU only backend to a GPU backend is as simple as changing one line in the pom file. Instead of specifying the nd4j-native-platform module specify the nd4j-cuda-X-platform where X indicated the version of CUDA. It is recommended to install cuDNN for better GPU performance. Runs will log warnings if cuDNN is not found. For more information, please refer TODO: https://deeplearning4j.org/docs/latest/deeplearning4j-config-cudnn

Users with acces to multi-gpu systems can use DL4J to further speed up the training process by training the models in parallel on them. Ideally these GPUs have the same speed and networking capabilities. This project contains a set of examples that demonstrate how to leverage performance from a multi-gpu setup. More documentation can be found here FIXME: https://deeplearning4j.konduit.ai/getting-started/tutorials/using-multiple-gpus

The list of examples in this project and what they demonstrate are briefly described below. This is also the recommended order to explore them in.

## QUICKSTART
[MultiGPULeNetMNIST.java](MultiGPULeNetMNIST.java)  
Introduction to ParallelWrapper by modifying the original LenetMnistExample (TODO:link)
[GradientsSharingLeNetMNIST.java](GradientsSharingLeNetMNIST.java)  
Uses gradient sharing instead of the default averaging every n iterations. More information on the gradient sharing algorithm can be found here. TODO:link
[GradientSharingVGG16TinyImageNet.java](GradientSharingVGG16TinyImageNet.java)  
Gradient sharing with VGG16 on TinyImageNet

## ADVANCED
[ImdbReviewClassificationRNN.java](ImdbReviewClassificationRNN.java)  
A multi-gpu version of the example of the same name in the dl4j-examples repo. (TODO:link) This example also includes how to presave the dataset to save time when training on multiple epochs.
[GenerateTxtModel.java](GenerateTxtModel.java)  
CharModelling: A multi-gpu version of the example of the same name in the dl4j-examples repo. (TODO:link)
[FeaturizedPreSave.java](FeaturizedPreSave.java) & FitFromFeaturized.java  
Transferlearning: A multi-gpu version of the example of the same name in the dl4j-examples repo. (TODO:link)

