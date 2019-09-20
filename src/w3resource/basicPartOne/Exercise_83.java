package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Multiply two arrays of the same length.                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 20, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_83 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static void printArrayData(String mess, int[] data) {
        System.out.print(mess);
        for (int i = 0; i < data.length; i++)
            System.out.printf("%2d%s", data[i], i == data.length-1 ? "" : " ");
        System.out.println();
    }

    private static int[] multiplyIntegerArrays(int[] dataA, int[] dataB) {
        if (dataA.length != dataB.length)
            throw new IllegalArgumentException("Array sizes must be the same");

        int[] newData = new int[dataA.length];

        for (int i = 0; i < dataA.length; i++)
            newData[i] = dataA[i] * dataB[i];
        return newData;
    }

    public static void main(String[] args) {
        int[] newDataA = randomIntegerArray(0, 10, 20);
        int[] newDataB = randomIntegerArray(0, 10, 20);
        printArrayData("      Generated data A: ", newDataA);
        printArrayData("      Generated data B: ", newDataB);
        printArrayData("After multiplying both: ", multiplyIntegerArrays(newDataA, newDataB));
    }
}
