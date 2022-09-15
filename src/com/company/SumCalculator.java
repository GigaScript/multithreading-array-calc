package com.company;

import java.util.concurrent.ForkJoinPool;

public class SumCalculator {
    public static long singleTreadSumCalculator(long[] array) {
        long sum = 0;
        for (long value : array) {
            sum += value;
        }
        return sum;
    }

    public static long multiThreadSumCalculator(long[] array) {
        MultiThreadArraySum multiThreadSum = new MultiThreadArraySum(array);
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        return pool.invoke(multiThreadSum);
    }
}
