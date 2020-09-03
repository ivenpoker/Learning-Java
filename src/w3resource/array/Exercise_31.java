package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Checks if the sum of all 10's in the array is exactly 30.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 3, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;
import w3resource.utils.ArrayUtils;

public class Exercise_31 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 20;
    private static final int SIZE = 20;

    private static int findSumOfAllNumInArray(int[] dataSource, int key) {
        return IntStream.of(dataSource).filter((val) -> val == key).sum();
    }

    public static void main(String[] args) {

        int[] randData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randData));

        int sumOfAll10s = findSumOfAllNumInArray(randData, 10);
        System.out.printf("Sum of all 10's: %d | Exactly 30: %s%n", sumOfAll10s,
                sumOfAll10s == 30 ? "TRUE" : "FALSE");
    }
}
