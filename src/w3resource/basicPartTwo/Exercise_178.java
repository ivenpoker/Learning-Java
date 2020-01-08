package w3resource.basicPartTwo;

// ########################################################################################################
// #                                                                                                      #
// #    Program Purpose: Find the longest increasing continuous subsequence in a given array of integers. #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                            #
// #    Creation Date  : January 08, 2020                                                                 #
// #                                                                                                      #
// ########################################################################################################

import java.util.Arrays;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Exercise_178 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid specified size for new array");
        }
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map((val) -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static int findLongestSubsequence(int[] mainData) {
        int maxCount = 0;
        for (int i = 0, tempMax = 0; i < mainData.length; i++) {
            for (int m = i, j = i+1; j < mainData.length; j++, m++) {
                if (mainData[j] - mainData[m] == 1) {
                    tempMax += 1;
                } else {
                    break;
                }
            }
            if (tempMax > maxCount) {
                maxCount = tempMax;
            }
            tempMax = 0;
        }
        return maxCount > 0 ? maxCount + 1 : maxCount;
    }

    private static void printLine(char someChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.printf("%c", someChar);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] newData = randomIntArray(0, 5, 20);
        System.out.printf("Array data: %s\n", Arrays.toString(newData));
        System.out.printf("Longest subsequence: %d\n", findLongestSubsequence(newData));

        printLine('-', 70);

        newData = new int[] {10, 11, 12, 13, 14, 7, 8, 9, 1, 2, 3};
        System.out.printf("New Test data: %s\n", Arrays.toString(newData));
        System.out.printf("Longest subsequence: %d\n", findLongestSubsequence(newData));

    }

}
