This project contains a set of examples that demonstrate how to manipulate NDArrays. The functionality of ND4J demonstrated here can be likened to numpy. 

The examples in this project along with a short summary are listed below. This is also the recommended order to explore them in.


## Quickstart
* [Nd4jEx0_INDArrayBasics.java](Nd4jEx0_INDArrayBasics.java)
Creating, concatenating, stacking, padding NDArrays
* [Nd4jEx1_INDArrayBasics.java](Nd4jEx1_INDArrayBasics.java)
Printing, querying shape properties, modifying elements, doing operations
* [Nd4jEx2_CreatingINDArrays.java](Nd4jEx2_CreatingINDArrays.java)
Different ways to create NDArrays
* [Nd4jEx3_GettingAndSettingSubsets.java](Nd4jEx3_GettingAndSettingSubsets.java)
Querying and modifying subset of an NDArray
* [Nd4jEx4_Ops.java](Nd4jEx4_Ops.java) 
More ops on NDArrays
* [Nd4jEx5_Accumulations.java](Nd4jEx5_Accumulations.java)
Reduction Operations
* [Nd4jEx6_BooleanIndexing.java](Nd4jEx6_BooleanIndexing.java)
Simple conditional element wise operations
* [Nd4jEx7_MatrixOperation.java](Nd4jEx7_MatrixOperation.java) 
Matrix multiplication
* [Nd4jEx8_ReshapeOperation.java](Nd4jEx8_ReshapeOperation.java)
Reshaping
* [Nd4jEx9_Functions.java](Nd4jEx9_Functions.java)  
Transforming NDArrays 
* [Nd4jEx10_ElementWiseOperation.java](Nd4jEx10_ElementWiseOperation.java)
Even more operations like add row/col etc
* [NumpyCheatSheet.java](NumpyCheatSheet.java) (FIXME???)
Examples to help numpy users get acquainted with ND4J

## Advanced
* [MultiClassLogitExample.java](MultiClassLogitExample.java)
Multiclass logistic regression from scratch with ND4J
* [WorkspacesExample.java](WorkspacesExample.java)
For cyclic workloads like training a neural net the DL4J ecosystem does not rely on garbage collection. Instead a chunk of memory is resued avoiding the performance hits from expensive pauses for GC. Workspaces are used by default when calling .fit on a neural network etc. This example demonstrates the concepts behind it for advanced users if they need to go beyond what is available by default in the library in their particular use case.
* [Nd4jEx11_Axpy.java](Nd4jEx11_Axpy.java)
Use the ND4J blas wrapper to call the AXPY operation
* [Nd4jEx12_LargeMatrices.java](Nd4jEx12_LargeMatrices.java)
Operations with a 10000000 element NDarray and its transpose
* [Nd4jEx13_Serialization.java](Nd4jEx13_Serialization.java)
Examples for binary and text serialization.
* [Nd4jEx14_Normalizers.java](Nd4jEx14_Normalizers.java)
Create and fit a normalizer, and save and restore it.
* [CustomOpsExamples.java](CustomOpsExamples.java) (FIXME??)
There are some operations that are currently implemented in C++ that have not yet been mapped to Java. This example demonstrates how to access them using ND4J's DynamicCustomOp.
* [NDArrayFromCSCMatrix.java](NDArrayFromCSCMatrix.java)
Sparse features, create an NDArray from a CSC representation matrix. **in alpha preview**

