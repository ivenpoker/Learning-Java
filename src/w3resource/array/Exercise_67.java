package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the subarray which has the largest sum in a given circular    #
// #                     array of integers.                                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 9, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;

public class Exercise_67 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 15;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LENGTH = 75;

    private static int findLargestSubArraySum(int[] dataSource) {
        int n = dataSource.length;
        int result = dataSource[0];
        int sum = dataSource[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + dataSource[i], dataSource[i]);
            result = Math.max(result, sum);
        }

        int[] right_Sum = new int[n];
        int[] right_Max = new int[n];
        right_Sum[n - 1] = dataSource[n - 1];
        right_Max[n - 1] = dataSource[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_Sum[i] = right_Sum[i + 1] + dataSource[i];
            right_Max[i] = Math.max(right_Sum[i], right_Max[i + 1]);
        }

        int left_Sum = 0;
        for (int i = 0; i < n - 2; i++) {
            left_Sum += dataSource[i];
            result = Math.max(result, left_Sum + right_Max[i + 2]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] testCaseA = {2, 1, -5, 4, -3, 1, -3, 4, -1};
        int[] testCaseB = {1, -2, 3, 0, 7, 8, 1, 2, -3};

        BasicUtils.printLineInfo("[ MAIN TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Test Array A: %s%n", Arrays.toString(testCaseA));
        System.out.printf("Test Array B: %s%n", Arrays.toString(testCaseB));

        BasicUtils.printLineInfo("[ TESTS RESULTS ]", '=', MAX_LINE_LENGTH);
        System.out.printf("The sum of subarray with largest sum is: %d%n", findLargestSubArraySum(testCaseA));
        System.out.printf("The sum of subarray with largest sum is: %d%n", findLargestSubArraySum(testCaseB));

        BasicUtils.printLineInfo("[ RANDOM TEST CASE ]", '=', MAX_LINE_LENGTH);

        int[] randomTestData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated random test data: %s%n", Arrays.toString(randomTestData));

        System.out.printf("The sum of subarray with largest sum is: %d%n", findLargestSubArraySum(randomTestData));

    }
}
