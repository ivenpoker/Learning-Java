package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Left shifts the content of an array.                                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.IllformedLocaleException;

public class Exercise_106 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllformedLocaleException("Invalid arrays size. Must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static void leftShiftArray(int[] mainData) {
        if (mainData.length > 1) {
            int temp = mainData[0];
            for (int i = 0; i < mainData.length; i++) {
                if (i != mainData.length-1) {
                    mainData[i] = mainData[i+1];
                } else {
                    mainData[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] dataA = randomIntegerArray(5, 20, 20);
        System.out.printf("Generated data: %s\n", Arrays.toString(dataA));

        leftShiftArray(dataA);

        System.out.printf("Data after left shifting: %s\n", Arrays.toString(dataA));

    }
}
