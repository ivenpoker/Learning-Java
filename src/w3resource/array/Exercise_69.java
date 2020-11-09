package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the minimum subarray sum of specified size in a given array   #
// #                     of integers.                                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 9, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.Arrays;

public class Exercise_69 {

    private static final int MAX_LINE_LENGTH = 75;

    private static int findMinimumSubarraySum(int[] dataSource, int size) {
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < dataSource.length; i++) {
            if (i + size < dataSource.length) {
                int tmpSum = 0;
                for (int j = i; j < dataSource.length; j++) {
                    tmpSum += dataSource[i];
                }
                if (tmpSum < minVal) {
                    minVal = tmpSum;
                }
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        int[] mainTestCase = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BasicUtils.printLineInfo("[ MAIN TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Main Test case: %s%n", Arrays.toString(mainTestCase));

        int testSize = 4;
        System.out.printf("Sub-array size: %d%n", testSize);
        System.out.printf("Sub-array from %d to %d and sum is: %d%n", 0, testSize-1,
                findMinimumSubarraySum(mainTestCase, testSize));

    }
}
