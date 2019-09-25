package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Checks if a specified array of integers contains 10's or 30's.                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 24, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_102 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static boolean checkIfArrayContainsAorB(int[] someData, int valA, int valB) {
        for (int i = 0; i < someData.length; i++)
            if (someData[i] == valA || someData[i] == valB)
                return true;
        return false;
    }

    public static void main(String[] args) {
        int[] data = randomIntegerArray(0, 35, 15);
        System.out.printf("Generated array: %s\n", Arrays.toString(data));
        System.out.printf("Does array contains 10 or 30: %s\n",
                checkIfArrayContainsAorB(data, 10, 30) ? "YES" : "NO");
    }
}
