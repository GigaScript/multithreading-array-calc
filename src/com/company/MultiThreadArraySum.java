package com.company;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;


public class MultiThreadArraySum extends RecursiveTask<Long> {
    private long[] array;

    public MultiThreadArraySum(long[] array) {
        this.array = array;
    }

    @Override
    protected Long compute() {
        if (array.length <= 2) {
            return Arrays.stream(array).sum();
        }
        MultiThreadArraySum firstPartArrayToCalculate = new MultiThreadArraySum(Arrays.copyOfRange(array, 0, array.length / 2));
        MultiThreadArraySum secondPartArrayToCalculate = new MultiThreadArraySum(Arrays.copyOfRange(array, array.length / 2, array.length));
        firstPartArrayToCalculate.fork();
        secondPartArrayToCalculate.fork();
        return firstPartArrayToCalculate.join() + secondPartArrayToCalculate.join();
    }
}
