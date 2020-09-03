package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Checks if an array of integers contains two specified elements.     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 3, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;
import w3resource.utils.ArrayUtils;

public class Exercise_32 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 15;

    private static boolean arrayContainsElements(int[] dataSource, int fstVal, int sndVal) {
        return IntStream.of(dataSource).anyMatch((val) -> val == fstVal) &&
                IntStream.of(dataSource).anyMatch((val) -> val == sndVal);
    }

    public static void main(String[] args) {

        int[] randomData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randomData));

        int keyA = 66;
        int keyB = 77;
        System.out.printf("[Test A] Does generated data contains '%d' and '%d': %s%n", keyA, keyB,
                arrayContainsElements(randomData, keyA, keyB) ? "YES" : "NO");

        int[] anotherTest = {11, 21, 15, 8, 65, 8, 2, 1, 18, 77};
        System.out.printf("[Test B] Does data contains '%d' and '%d': %s%n", keyA, keyB,
                arrayContainsElements(anotherTest, keyA, keyB) ? "YES" : "NO");

    }
}
