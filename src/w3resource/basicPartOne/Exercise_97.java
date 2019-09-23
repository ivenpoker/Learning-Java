package w3resource.basicPartOne;

// ######################################################################################################
// #                                                                                                    #
// #    Program Purpose: Checks if there is a 10 in a given array of integers with a 20 somewhere later #
// #                     in the array.                                                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                          #
// #    Creation Date  : September 23, 2019                                                             #
// #                                                                                                    #
// ######################################################################################################

import java.security.SecureRandom;

public class Exercise_97 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid size of array. Size must be > 0");
        }
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
        return data;
    }

    private static void printArrayData(String mess, int[] data) {
        System.out.print(mess);
        for (int i = 0; i < data.length; i++)
            System.out.printf("%d%s", data[i], i == data.length-1 ? "" : " ");
        System.out.println();
    }

    private static boolean checkSpecifNumberNextToEachOther(int[] data, int num) {
        for (int i = 0; i < data.length; i += 2) {
            if (i == data.length-1)
                return false;
            if (data[i] == num && data[i+1] == num)
                return true;
        }
        return true;
    }

    private static boolean checkTwoSameSpecificNumbersSeperatedByAnElement(int[] data, int num) {
        for (int i = 1; i < data.length; i++) {
            if ((i != data.length-1) && (data[i-1] == data[i+1]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 10);
        printArrayData("Generate data: ", newData);

        System.out.printf("Does array passes first condition: %s\n",
                checkSpecifNumberNextToEachOther(newData, 5));
        System.out.printf("Does array passes second condition: %s\n",
                checkTwoSameSpecificNumbersSeperatedByAnElement(newData, 5));
    }
}
