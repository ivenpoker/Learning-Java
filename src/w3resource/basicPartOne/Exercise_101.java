package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Checks if the number of 10s is greater than the number of 20s in an array.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 24, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_101 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int size) {
        int[] tempData = {10, 20};
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = tempData[random.nextInt(2)];
        return newData;
    }

    private static boolean checkIfFirstOccursMoreThanNext(int[] someData, int valA, int valB) {
        int valACnt = 0;
        int valBCnt = 0;
        for (int someDatum : someData) {
            if (someDatum == valA) {
                valACnt++;
            } else if (someDatum == valB) {
                valBCnt++;
            }
        }
        return valACnt > valBCnt;
    }

    public static void main(String[] args) {

        int[] mainData = randomIntegerArray(20);
        System.out.printf("New array data: %s\n", Arrays.toString(mainData));
        System.out.printf("Does 10s count exceeds 20s count ?: %s\n",
                checkIfFirstOccursMoreThanNext(mainData, 10, 20) ? "YES" : "NO");

    }

}
