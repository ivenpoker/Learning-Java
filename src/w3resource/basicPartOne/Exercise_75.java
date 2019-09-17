package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Test if the first and the last element of an array of integers are same.  #
// #                     The length of the array must be >= 2.                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 17, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_75 {

    private static SecureRandom random = new SecureRandom();

    private static int[] generateIntegerArray(int low, int high, int size) {
        if (size < 2)
            throw new IllegalArgumentException("Invalid size of array. Must be >= 2.");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static void printData(String outputMessage, int[] data) {
        System.out.print(outputMessage);
        for (int i = 0; i < data.length; i++)
            System.out.printf("%d%s", data[i], i == data.length-1 ? "" : " ");
        System.out.println();
    }

    private static boolean startsAndEndWithSameDigit(int[] data) {
        if (data.length < 2)
            throw new IllegalArgumentException("Invalid size of array. Must be >= 2");
        return data[0] == data[data.length-1];
    }

    public static void main(String[] args) {

        int[] someData = {2, 5, 4, 3, 6, 7, 2, 4, 5, 2};
        int[] newData = generateIntegerArray(0, 10, 10);
        printData("Data A: ", someData);
        printData("Data B: ", newData);

        System.out.printf("Does Data A passes condition: %s\n", startsAndEndWithSameDigit(someData) ? "YES" : "NO");
        System.out.printf("Does Data B passes condition: %s\n", startsAndEndWithSameDigit(newData) ? "YES" : "NO");

    }
}
