package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Check if the value of 20 appears three times and no 20's are next to each other #
// #                     in a given array of integers.                                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 23, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;

public class Exercise_98 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Size must be > 0");

        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static boolean numberOfOccurrences(int[] data, int keyVal, int nTimes) {
        if (data.length < nTimes)
            throw new IllegalArgumentException(String.format("Invalid size of array. " +
                    "Size of array must be >= %d", nTimes));
        int cnt = 0;
        for (int datum : data)
            if (datum == keyVal)
                cnt++;
        return nTimes == cnt;
    }

    private static boolean checkContinuousOccurrences(int[] data, int key) {
        for (int i = 0; i < data.length; i++)
            if ((i != data.length-1) && (data[i] == key && data[i+1] == key))
                return true;
        return false;
    }

    private static void printArrayData(String mess, int[] data) {
        System.out.print(mess);
        for (int i = 0; i < data.length; i++)
            System.out.printf("%d%s", data[i], i == data.length-1 ? "" : " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 10);
        printArrayData("Generated array data: ", newData);

        // Check if 20 appears 3 times in array
        System.out.printf("Does 20 appears 3 times in array: %s\n",
                numberOfOccurrences(newData, 20, 3) ? "YES" : "NO");

        // Check if any 20's are next to each other in array
        System.out.printf("Does any 20s appear next to each other: %s\n",
                checkContinuousOccurrences(newData, 20) ? "YES" : "NO");
    }
}
