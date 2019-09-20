package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Get the larger value between the first and last element of an array.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 20, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_80 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size){
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

    private static int findLargerBetweenFirstAndLast(int[] someData) {
        if (someData.length == 0)
            throw new IllegalArgumentException("Empty array not acceptable");
        if (someData.length == 1)
            return someData[0];
        return Math.max(someData[0], someData[someData.length - 1]);
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 5);
        printArrayData("Generated array: ", newData);
        System.out.printf("Larger between first and last: %d\n", findLargerBetweenFirstAndLast(newData));
    }
}
