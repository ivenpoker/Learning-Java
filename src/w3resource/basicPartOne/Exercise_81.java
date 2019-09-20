package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Swap the first and last item in an array.                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 20, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_81 {

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
            System.out.printf("%d%s", data[i], i == data.length-1 ? "" : " ");
        System.out.println();
    }

    private static int[] getFirstAndLast(int[] data) {
        if (data.length == 0)
            throw new IllegalArgumentException("Empty array not acceptable");
        int[] newData = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                newData[i] = data[data.length - 1];
                continue;
            }
            if (i == data.length-1) {
                newData[i] = data[0];
                continue;
            }
            newData[i] = data[i];
        }
        return newData;
    }


    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 10);
        printArrayData("Generated array: ", newData);
        printArrayData(" New array data: ", getFirstAndLast(newData));
    }
}
