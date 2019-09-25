package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Creates a new array from a given array of integers, new array will contain the  #
// #                     elements from the given array after the last element value 10                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.Arrays;
import java.security.SecureRandom;

public class Exercise_103 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static int[] getDataAfter(int[] someData, int keyVal) {
        boolean found = false;
        int[] newData = null;
        for (int i = 0; i < someData.length && !found; i++) {
            if (someData[i] == keyVal && i != someData.length-1) {
                newData = new int[someData.length-i];
                for (int j = 0, k = i+1; k < someData.length; j++, k++)
                    newData[j] = someData[k];
                found = true;
            } else if (someData[i] == keyVal && i == someData.length-1) {
                newData = new int[0];
                found = true;
            }
        }
        return newData;
    }

    public static void main(String[] args) {

        int[] dataA = randomIntegerArray(5, 15, 15);
        int[] dataB = {11, 10, 13, 10, 45, 20, 33, 53};

        System.out.printf("Data A is: %s\n", Arrays.toString(dataA));
        System.out.printf("Data B is: %s\n", Arrays.toString(dataB));

        int[] newDataA = getDataAfter(dataA, 10);
        int[] newDataB = getDataAfter(dataB, 10);

        System.out.printf("Data After 10 in A: %s\n", Arrays.toString(newDataA));
        System.out.printf("Data after 10 in B: %s\n", Arrays.toString(newDataB));


    }
}
