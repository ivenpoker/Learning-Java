package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Merge two given sorted array of integers and create a new sorted array.         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 29, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_113 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid new array size. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }

    private static int[] mergeData(int[] dataSourceA, int[] dataSourceB) {
        int[] newData = new int[dataSourceA.length + dataSourceB.length];
        final int[] i = {0};
        IntStream.of(dataSourceA).forEach(value -> newData[i[0]++] = value);
        IntStream.of(dataSourceB).forEach(value -> newData[i[0]++] = value);
        return newData;
    }

    public static void main(String[] args) {

        int[] dataA = randomIntegerArray(5, 15, 10);
        int[] dataB = randomIntegerArray(5, 15, 10);

        System.out.printf("Generated array data A: %s\n", Arrays.toString(dataA));
        System.out.printf("Generated array data B: %s\n", Arrays.toString(dataB));

        Arrays.sort(dataA);
        Arrays.sort(dataB);

        int[] sumData = mergeData(dataA, dataB);
        System.out.printf("Sorted merged data: %s\n", Arrays.toString(sumData));
    }
}
