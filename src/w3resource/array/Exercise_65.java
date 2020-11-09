package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the maximum difference between two elements in a given array  #
// #                     of integers such that smaller element appears before larger element #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 9, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;

public class Exercise_65 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 20;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LENGTH = 75;

    private static int findMaximumDifference(int[] dataSource) {
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j < dataSource.length; j++) {
                if (dataSource[i] < dataSource[j]) {
                    int currDiff = Math.abs(dataSource[i] - dataSource[j]);
                    if (currDiff > maxDiff) {
                        maxDiff = currDiff;
                    }
                }
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] randomIntArray = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        BasicUtils.printLineInfo("[ FIRST TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randomIntArray));

        int maxDiff = findMaximumDifference(randomIntArray);

        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Found Maximum Difference: %d%n", maxDiff);

        BasicUtils.printLineInfo("[ SECOND TEST CASE ]", '=', MAX_LINE_LENGTH);
        int[] testData = {2, 3, 1, 7, 9, 5, 11, 3, 5};

        System.out.printf("Test Array Data: %s%n", Arrays.toString(testData));

        maxDiff = findMaximumDifference(testData);

        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Found Maximum Difference: %d%n", maxDiff);
    }
}
