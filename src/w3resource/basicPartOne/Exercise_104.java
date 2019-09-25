package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Creates a new array from a given array of integers, new array will contain the  #
// #                     elements from the given array before the first element value 10                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_104 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static int[] getDataBefore(int[] someData, int keyVal) {
        int[] beforeData = null;
        for (int i = 0; i < someData.length; i++) {
            if (someData[i] == keyVal && i != 0) {
                beforeData = new int[i];              // +1 is to account for zero indexing.
                for (int k = 0, j = i-1; k <= i && j >= 0; k++, j--)
                    beforeData[k] = someData[j];
                break;
            } else if (someData[i] == keyVal && i == 0) {
                beforeData = new int[0];
                break;
            }
        }
        return beforeData;
    }

    public static void main(String[] args) {

        int[] dataA = randomIntegerArray(5, 15, 15);
        int[] dataB = {11, 15, 13, 10, 45, 20, 33, 53};

        System.out.printf("Data A: %s\n", Arrays.toString(dataA));
        System.out.printf("Data B: %s\n", Arrays.toString(dataB));

        int[] newDataA = getDataBefore(dataA, 10);
        int[] newDataB = getDataBefore(dataB, 10);

        System.out.printf("Data before 10 in A: %s\n", Arrays.toString(newDataA));
        System.out.printf("Data before 10 in B: %s\n", Arrays.toString(newDataB));


    }
}