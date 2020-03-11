/*******************************************************************************
 * Copyright (c) 2015-2019 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.deeplearning4j.examples.advanced.modelling.sequenceprediction;


import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.DataSetPreProcessor;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

import java.io.File;
import java.util.List;

/**
 * @author WangFeng
 */
public class LotteryDataSetIterator implements DataSetIterator {

    private BaseDataSetReader recordReader;
    private int batchSize;
    private DataSet last;
    private boolean useCurrent;

    public LotteryDataSetIterator(String filePath, int batchSize, boolean modelType) {
        this.recordReader = modelType? new LotteryCombinationDataSetReader(new File(filePath)): new LotteryCharacterSequenceDataSetReader(new File(filePath));
        this.batchSize = batchSize;
    }

    @Override
    public DataSet next(int i) {
        return recordReader.next(i);
    }

    public int totalExamples() {
        return recordReader.totalExamples();
    }

    @Override
    public int inputColumns() {
        if (last == null) {
            DataSet next = next();
            last = next;
            useCurrent = true;
            return next.numInputs();
        } else {
            return last.numInputs();
        }
    }

    @Override
    public int totalOutcomes() {
        if (last == null) {
            DataSet next = next();
            last = next;
            useCurrent = true;
            return next.numOutcomes();
        } else {
            return last.numOutcomes();
        }
    }

    @Override
    public boolean resetSupported() {
        return true;
    }

    @Override
    public boolean asyncSupported() {
        return true;
    }

    @Override
    public void reset() {
        recordReader.reset();
        last = null;
        useCurrent = false;
    }

    @Override
    public int batch() {
        return batchSize;
    }

    @Override
    public void setPreProcessor(DataSetPreProcessor dataSetPreProcessor) {

    }

    @Override
    public DataSetPreProcessor getPreProcessor() {
        throw new UnsupportedOperationException("Not support the function");
    }

    @Override
    public List<String> getLabels() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return recordReader.hasNext();
    }

    @Override
    public DataSet next() {
        if (useCurrent) {
            useCurrent = false;
            return last;
        } else {
            return next(batchSize);
        }
    }

}
