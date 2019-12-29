package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Finds the length of the longest consecutive sequence of a    #
// #                     given array of integers                                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Exercise_170 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntDataArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d)" +
                    " for new array data", size));
        }
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static int findLongestConsecutiveSequence(int[] data) {
        if (data.length == 1) {
            return 1;
        }
        int maxLen = 0;

        for (int i = 0, temp = 0; i < data.length; i++) {
            if (i + 1 < data.length) {
                int diff = Math.abs(data[i] - data[i+1]);
                if (diff == 0 || diff == 1) {
                    temp += 1;
                } else {
                    if (temp > maxLen) {
                        maxLen = temp;
                    }
                    temp = 0;
                }
            }
        }
        return maxLen + 1; // +1 because we're counting difference between two digits.
    }

    private static void printLine(char someChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.printf("%c", someChar);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] testA = randomIntDataArray(0, 20, 15);
        int[] testB = {1, 1, 2, 3, 3, 4, 5, 2, 4, 5, 6, 7, 8, 9, 6, -1, -2};

        System.out.printf("Test data A: %s\n", Arrays.toString(testA));
        System.out.printf("Test data B: %s\n", Arrays.toString(testB));

        printLine('-', 70);

        System.out.printf("Longest consecutive sequence for A: %d\n",
                findLongestConsecutiveSequence(testA));

        System.out.printf("Longest consecutive sequence for B: %d\n",
                findLongestConsecutiveSequence(testB));


    }

}
