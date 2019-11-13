package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Get the index of the first number and the last number of a subarray where the   #
// #                     sum of numbers is zero from a given array of integers.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : November 13, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Objects;

public class Exercise_139 {

    private static SecureRandom random = new SecureRandom();

    public static int[] getIndex(int[] data) {
        int[] indexValues = {-1, -1};
        for (int i = 0, sum = data[i]; i < data.length; i++, sum = 0) {
            for (int j = i+1; j < data.length; j++) {
                sum += data[j];
                if (sum == 0) {
                    indexValues[0] = i;
                    indexValues[1] = j;
                    return indexValues;
                }
            }
        }
        return null;
    }

    private static int[] obtainRandomIntegerArray(int low, int high, int size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }

    public static void main(String[] args) {

        int[] randomData = obtainRandomIntegerArray(-2, 8, 15);
        System.out.printf("Random array data: %s\n", Arrays.toString(randomData));

        int[] zeroInd = getIndex(randomData);
//        int[] mainTest = getIndex(new int[] {1, 2, 3, -6, 5, 4});

        System.out.printf("Indices found: %s\n",
                Objects.isNull(zeroInd) ? "[NONE FOUND]" : Arrays.toString(zeroInd));
    }
}
