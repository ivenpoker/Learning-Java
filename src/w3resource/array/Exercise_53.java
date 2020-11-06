package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Replaces every element with the next greatest element (from right   #
// #                     side) in a given array of integers. If there is no element next to   #
// #                     the last element, therefore replace it with -1.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 6, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_53 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 20;
    private static final int ARRAY_SIZE = 20;
    private static final int MAX_LINE_CHAR = 90;

    private static int getMaxInRange(int[] dataSource, int low, int high) {
        if (low > high) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Low (%d) must <= high (%d)", low, high));
        } else if (low >= dataSource.length || high >= dataSource.length) {
            throw new IllegalArgumentException(
                    String.format("Invalid indices. Indices must be in range [%d, %d]",
                            0, dataSource.length-1));
        }
        int greatest = dataSource[low];
        for (int i = low + 1; i <= high; i++) {
            if (dataSource[i] > greatest) {
                greatest = dataSource[i];
            }
        }
        return greatest;
    }

    private static int[] performReplacement(int[] mainData) {
        int[] dataCopy = IntStream.of(mainData).toArray();
        for (int i = 0; i < mainData.length; i++) {
            if (i == mainData.length-1) {
                dataCopy[i] = -1;
            } else {
                dataCopy[i] = getMaxInRange(mainData, i+1, mainData.length - 1);
            }
        }
        return dataCopy;
    }

    public static void main(String[] args) {
        int[] randomData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randomData));

        int[] processedData = performReplacement(randomData);
        System.out.printf("Processed Array: %s%n", Arrays.toString(processedData));

        BasicUtils.printLine('-', MAX_LINE_CHAR);
        int[] testData = {45, 20, 100, 23, -5, 2, -6};

        System.out.printf("Test data: %s%n", Arrays.toString(testData));
        int[] processedTestData = performReplacement(testData);

        System.out.printf("Processed test data: %s%n", Arrays.toString(processedTestData));
    }

}
