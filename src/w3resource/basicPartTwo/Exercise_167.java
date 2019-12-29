package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Moves every zero to the right side of a given array of       #
// #                     integers.                                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_167 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d) " +
                    "for new array data", size));
        }
        int[] intData = new int[size];
        intData = IntStream.of(intData).map(val -> low + random.nextInt(high)).toArray();
        return intData;
    }

    private static int[] moveKeyToArrayEnd(int[] mainData, int key) {
        if (mainData.length < 2) {
            return Arrays.copyOf(mainData, mainData.length);
        }

        int[] tempData = new int[mainData.length];
        int j = 0;
        for (int val : mainData) {
            if (val != key) {
                tempData[j++] = val;
            }
        }
        for (;j < mainData.length; j++) {
            tempData[j] = key;
        }
        return tempData;
    }

    public static void main(String[] args) {
        int[] newArrayData = randomIntArray(0, 5, 15);
        System.out.printf("   New array data: %s\n", Arrays.toString(newArrayData));

        int[] dataWithMoves = moveKeyToArrayEnd(newArrayData, 0);
        System.out.printf("Array after moves: %s\n", Arrays.toString(dataWithMoves));
    }
}
