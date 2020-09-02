package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Determines if two arrays are equal.                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_23 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 15;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] randomIntArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid array bounds. Lower bound (%d) must be < Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid array size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((val) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static boolean arraysEqualA(int[] dataA, int[] dataB) {
        if (dataA.length != dataB.length) {
            return false;
        }
        return Arrays.equals(dataA, dataB);
    }

    private static boolean arraysEqualB(int[] dataA, int[] dataB) {
        if (dataA.length != dataB.length) {
            return false;
        }
        for (int valA : dataA) {
            for (int valB : dataB) {
                if (valA != valB) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] dataA = randomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        int[] dataB = randomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);

        System.out.printf("Generated random data A: %s%n", Arrays.toString(dataA));
        System.out.printf("Generated random data B: %s%n", Arrays.toString(dataB));

        System.out.printf("Is data A equals to data B: %s%n", arraysEqualA(dataA, dataB));
        System.out.printf("Is data A equals to data B: %s%n", arraysEqualB(dataA, dataB));

    }
}




































