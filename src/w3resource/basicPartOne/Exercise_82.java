package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Finds the largest element between first, last and middle values form an   #
// #                     array of integers.                                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 20, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_82 {

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

    private static int findMaxOfFirstLastAndMiddleValues(int[] mainData) {
        if (mainData.length < 3)
            throw new IllegalArgumentException("Invalid size of array. Must be 3 and above");
        return Math.max(mainData[0], Math.max(mainData[mainData.length/2], mainData[mainData.length-1]));
    }


    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 10);
        printArrayData("Generated array: ", newData);
        System.out.printf("Max of first, middle and last integer in array: %d\n",
                findMaxOfFirstLastAndMiddleValues(newData));
    }
}
