package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Checks if an array of integers is without 0 or -1.                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 3, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;
import w3resource.utils.ArrayUtils;

public class Exercise_30 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 30;
    private static final int SIZE = 15;

    private static boolean arrayContains(int[] dataSource, int[] targets) {
        for (int key : targets) {
            if (IntStream.of(dataSource).anyMatch((val) -> val == key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] data = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated array data: %s%n", Arrays.toString(data));

        int[] target = {0, -1};
        System.out.printf("Is there any 0 or -1 in the array: %s%n",
                arrayContains(data, target) ? "YES" : "NO");

    }
}
