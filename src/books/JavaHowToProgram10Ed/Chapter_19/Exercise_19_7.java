package books.JavaHowToProgram10Ed.Chapter_19;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 19.7 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : February 02, 2020                                          #
// #                                                                                  #
// ####################################################################################

import java.util.Arrays;
import java.security.SecureRandom;

public class Exercise_19_7 {

    private static SecureRandom generator = new SecureRandom();

    private static int[] sort(int[] nums, int maxValue) {
        int[] bucket = new int[maxValue + 1];
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                sortedNums[outPos++] = i;
            }
        }
        return sortedNums;
    }
    private static int maxValue(int[] nums) {
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue)
                maxValue = nums[i];
        }
        return maxValue;
    }

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size '%d' for new array data.",
                    size));
        }
        return Arrays.stream(new int[size]).map(val ->
                low + generator.nextInt(high)).toArray();
    }

    public static void main(String[] args) {
        int[] nums = randomIntegerArray(0, 50, 15);
        int maxValue = maxValue(nums);

        System.out.printf("Original Array: %s\n", Arrays.toString(nums));
        nums = sort(nums, maxValue);

        System.out.printf("  Sorted Array: %s\n", Arrays.toString(nums));
    }
}
