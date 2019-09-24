package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Counts the two elements that differ by 1 or less of two given arrays of integer #
// #                     with same length.                                                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 24, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;

public class Exercise_100 {

    private static final SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Size must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static void printArrayData(String mess, int[] data) {
        System.out.print(mess);
        for (int i = 0; i < data.length; i++)
            System.out.printf("%d%s", data[i], i == data.length-1 ? "": " ");
        System.out.println();
    }

    private static int[] findAbsoluteDifference(int[] dataA, int[] dataB) {
        if (dataA.length != dataB.length)
            throw new IllegalArgumentException("Invalid arguments. Arrays must be of same size");
        int[] dataC = new int[dataA.length];            // could have been 'dataB.length'
        for (int i = 0; i < dataA.length; i++)
            dataC[i] = Math.abs(dataA[i] - dataB[i]);
        return dataC;
    }

    private static int countBelowOrEqualToKey(int[] someData, int key) {
        int cnt = 0;
        for (int i = 0; i < someData.length; i++)
            if (someData[i] <= key)
                cnt++;
        return cnt;
    }

    public static void main(String[] args) {

        int[] dataA = randomIntegerArray(0, 10, 20);
        int[] dataB = randomIntegerArray(0, 10, 20);

        printArrayData("Generated array A: ", dataA);
        printArrayData("Generated array B: ", dataB);

        int[] dataC = findAbsoluteDifference(dataA, dataB);

        printArrayData("Generated array C: ", dataC);
        System.out.printf("Number of elements: %d\n", countBelowOrEqualToKey(dataC, 1));

    }
}
