package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Program to test if 10 appears as either the first or last element of an   #
// #                     array of of integers. The length of the array must be greater than or     #
// #                     equal to 2.                                                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 17, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_74 {

    private static SecureRandom random = new SecureRandom();

    private static int[] generateIntegerArray(int low, int high, int size) {
        if (size < 2)
            throw new IllegalArgumentException("Invalid size for array. Must be >= 2");
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
        return data;
    }

    private static void printData(String outputMess, int[] data) {
        System.out.print(outputMess);
        for (int i = 0; i < data.length; i++)
            System.out.printf("%02d%s", data[i], i == data.length-1 ? "" : " ");
        System.out.println();
    }

    private static boolean startsAndEndsWith10(int[] data) {
        if (data.length < 2)
            throw new IllegalArgumentException("Invalid array size");
        return data[0] == 10 && data[data.length-1] == 10;
    }

    public static void main(String[] args) {

        int[] correctData = {10, 3, 4, 5, 6, 2, 3, 8, 7, 10};
        int[] newData = generateIntegerArray(1, 10, 10);
        printData("Data A: ", correctData);
        printData("Data B: ", newData);

        System.out.printf("Data A passes test? %s\n", startsAndEndsWith10(correctData) ? "YES" : "NO");
        System.out.printf("Data B passes test? %s\n", startsAndEndsWith10(newData) ? "YES" : "NO");

    }
}
