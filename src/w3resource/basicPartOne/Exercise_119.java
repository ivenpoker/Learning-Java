package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Finds the first occurrence of a data value in an array.                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 29, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.Arrays;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Exercise_119 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid array size. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }

    private static int findFirstOccurrence(int[] dataSource, int val) {
        if (dataSource.length == 0)
            return -1;
        for (int i = 0; i < dataSource.length; i++)
            if (dataSource[i] == val)
                return i;
        return -1;
    }

    public static void main(String[] args) {

        int[] newData = randomIntegerArray(0, 20, 15) ;
        System.out.printf("Array data: %s\n", Arrays.toString(newData));
        int key = random.nextInt(20);
        System.out.printf("Searching for first occurrence of '%d' in data...", key);
        int result = findFirstOccurrence(newData, key);
        if (result >= 0) {
            System.out.printf("[FOUND: at index '%d']\n", result);
        } else {
            System.out.print("[NOT FOUND]\n");
        }
    }
}
