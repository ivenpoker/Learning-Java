package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Checks if a number appears in each pair of adjacent element in array.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 24, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;

public class Exercise_99 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Must be >= 0");
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
        return data;
    }

    private static void printArrayData(String mess, int[] arrayData) {
        System.out.print(mess);
        for (int i = 0; i < arrayData.length; i++)
            System.out.printf("%d%s", arrayData[i], i == arrayData.length-1 ? "" : " ");
        System.out.println();
    }

    private static boolean checkAdjacentElementMatch(int[] data, int key) {
        if (data.length < 2)
            return false;
        for (int i = 1;  i < data.length; i += 2) {
            if (data[i] != key)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] dataA = randomIntegerArray(0, 10,10);
        int[] dataB = {1, 20, 30, 20, -5, 20, 30};

        printArrayData("Generated dataA: ", dataA);
        printArrayData("Generated dataB: ", dataB);

        System.out.printf("Does dataA passes test: %s\n",
                checkAdjacentElementMatch(dataA, 5) ? "YES" : "NO");
        System.out.printf("Does dataB passes test: %s\n",
                checkAdjacentElementMatch(dataB, 20) ? "YES" : "NO");
    }
}
