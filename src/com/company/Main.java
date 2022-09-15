package com.company;

import java.util.Arrays;

public class Main {
    public static long sumSingleThread;
    public static long sumMultiThread;

    public static void main(String[] args) throws InterruptedException {
        int[] testArraySize = new int[]{20, 20000, 200000,2000000,20000000};
        for (int i = 0; i < testArraySize.length; i++) {
            runSumCalculatorTester(testArraySize[i]);
        }
    }

    private static void runSumCalculatorTester(int arraySize) {
        long[] array = arrayGenerator(arraySize);
        long singleStartTime = System.currentTimeMillis();
        sumSingleThread = SumCalculator.singleTreadSumCalculator(array);
        long singleExecuteTime = System.currentTimeMillis() - singleStartTime;
        long multiStartTime = System.currentTimeMillis();
        sumMultiThread = SumCalculator.multiThreadSumCalculator(array);
        long multiExecuteTime = System.currentTimeMillis() - multiStartTime;
        testResultPrinter(array.length, singleExecuteTime, multiExecuteTime);
    }

    private static void testResultPrinter(int arrayLength, long singleExecuteTime, long multiExecuteTime) {
        System.out.println("\n======Тест на массиве в " + arrayLength + " элементов====");
        System.out.println("Время выполнения в режиме SingleThread " + singleExecuteTime + " мс, в режиме MultiThread " + multiExecuteTime + " мс");
        System.out.println("Сумма значений массива в режиме SingleThread " + sumSingleThread + ", в режиме MultiThread " + sumMultiThread);
        String winner = "SingleThread";
        if (singleExecuteTime > multiExecuteTime) {
            winner = "Thread";
        }
        System.out.println("Сумма значений массива в режиме SingleThread " + sumSingleThread + ", в режиме MultiThread " + sumMultiThread);
        System.out.println("в тесте на массиве в " + arrayLength + " элементов, преимущество у режима " + winner);
    }

    private static long[] arrayGenerator(int arraySize) {
        long[] array = new long[arraySize];
        Arrays.fill(array, 1);
        return array;
    }

}
