package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Compute the median of an given unsorted array of integers.                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 30, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;
import java.security.SecureRandom;

public class Exercise_127 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int size, int low, int high) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val -> low  + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static double computeMedian(int[] mainData) {
        if (mainData.length == 0) return -1;

        //Arrays.sort(mainData);
        int val = mainData.length / 2;

        if (mainData.length % 2 == 0) {
            return (double) (mainData[val] + mainData[val+1]) / 2;
        } else {
            return mainData[val + 1];
        }
    }

    public static void main(String[] args) {

        int[] newArray = randomIntegerArray(10, 0, 20);
        System.out.printf("Generated array data: %s\n", Arrays.toString(newArray));
        System.out.printf("Computed mean is: %.1f\n", computeMedian(newArray));

    }
}
