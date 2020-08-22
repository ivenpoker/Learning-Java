package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Generates a random integer array and sum all data within.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 22, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.stream.IntStream;
import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_2 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 10;
    private static final SecureRandom randomNumberGen = new SecureRandom();

    /**
     * Generates a random integer array, with it's data (integers) randomized form
     * specified bounds.
     * @param low Lower bound to consider when randomizing data.
     * @param high Upper bound to consider when randomizing data.
     * @param size Size of the array to generate.
     * @return Integer array of random data.
     */
    private static int[] randomIntegerArray(int low, int high, int size) {
        if (low > size) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be <= Upper bound (%d)",
                            low, high));
        }
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid array size (%d)", size));
        }
        return IntStream.of(new int[size]).map((i) -> low + randomNumberGen.nextInt(high)).toArray();
    }

    /**
     * Computes the sum of all the integer data found in array.
     * @param intData Array of integer data to compute sum.
     * @return Sum of all the contents found in the array.
     */
    private static int findSumOfArray(int[] intData) {
        return IntStream.of(intData).sum();
    }

    public static void main(String[] args) {

        int[] randomData = randomIntegerArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Array Data: %s%n", Arrays.toString(randomData));

        System.out.printf("Sum of array data: %d%n", findSumOfArray(randomData));

    }

}
