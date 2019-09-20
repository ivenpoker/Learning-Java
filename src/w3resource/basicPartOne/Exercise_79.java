package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Rotate and array of integers to the left direction.                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 20, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_79 {

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

    private static void reverseArrayElements(int[] data) {
        for (int i = 0, j = data.length-1; i < j; i++, j--) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 10);
        printArrayData("Generated array: ", newData);
        reverseArrayElements(newData);
        printArrayData("Reversed array : ", newData);
    }

}
