package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds contiguous subarray within a given array of integers which    #
// #                     has the largest sum.                                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 9, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;

public class Exercise_66 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LENGTH = 80;

    private static int findMaximumSumSubArray(int[] dataSource) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < dataSource.length; i++) {
            int tmpSum = dataSource[i];

            for (int j = i+1; j < dataSource.length; j++) {
                tmpSum += dataSource[j];
            }
            if (tmpSum > maxSum) {
                maxSum = tmpSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] mainArray = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        BasicUtils.printLineInfo("[ FIRST TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Generated Array Data: %s%n", Arrays.toString(mainArray));
        System.out.printf("Test results: %s%n", findMaximumSumSubArray(mainArray));


        BasicUtils.printLineInfo("[ SECOND TEST CASE ]", '=', MAX_LINE_LENGTH);
        int[] anotherTest = {1, 2, -3, -4, 0, 6, 7, 8, 9};
        System.out.printf("Generated Array: %s%n", Arrays.toString(anotherTest));
        System.out.printf("Test results: %s%n", findMaximumSumSubArray(anotherTest));

    }
}
