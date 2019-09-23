package w3resource.basicPartOne;

// ######################################################################################################
// #                                                                                                    #
// #    Program Purpose: Checks if there is a 10 in a given array of integers with a 20 somewhere later #
// #                     in the array.
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                          #
// #    Creation Date  : September 23, 2019                                                             #
// #                                                                                                    #
// ######################################################################################################

import java.security.SecureRandom;

public class Exercise_96 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid array size. Must be > 0");
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

    private static boolean checkPresence(int[] data, int fstVal, int sndVal) {
        boolean foundFirstVal = false;
        boolean foundSecondVal = false;

        for (int datum : data) {
            if (datum == fstVal)
                foundFirstVal = true;
            if (foundFirstVal && datum == sndVal) {
                foundSecondVal = true;
                break;
            }
        }
        return foundFirstVal && foundSecondVal;
    }

    public static void main(String[] args) {
        int[] dataA = randomIntegerArray(0 , 10, 10);
        int[] dataB = {1, 10, 2, 4, 5, 20, 5, 18, 4};
        printArrayData("Data A: ", dataA);
        printArrayData("Data B: ", dataB);
        System.out.printf("Does data A passes condition: %s\n", checkPresence(dataA, 10, 20) ? "YES" : "NO");
        System.out.printf("Does data B passes condition: %s\n", checkPresence(dataB, 10, 20) ? "YES" : "NO");

    }
}
