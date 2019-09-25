package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Checks if an array of integers contains 'n' increasing adjacent numbers.        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_107 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerData(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static boolean  checkNIncreasing(int[] mainData, int nVal) {
        for (int i = 0; i < mainData.length; i++) {
            if (i + nVal < mainData.length) {
                boolean found = true;
                for (int j = i; j < i+nVal; j++) {
                    if (Math.abs(mainData[j] - mainData[j+1]) != 1) {
                        found = false;
                        break;
                    }
                }
                return found;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] data = randomIntegerData(5, 20, 20);
        System.out.printf("Generated data: %s\n", Arrays.toString(data));
        System.out.printf("Are there any 3 numbers in increasing order: %s\n",
                checkNIncreasing(data, 3) ? "YES" : "NO");
    }
}
