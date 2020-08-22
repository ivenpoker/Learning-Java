package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Creates an array of integers, displays them and compute average.    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 22, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_4 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 10;
    private static final SecureRandom randomNumGen = new SecureRandom();

    /**
     * Creates an integer array of specified size, whose contents are integer values
     * are random numbers obtained from a specified range.
     * @param lower Lower bound to consider when randomizing data.
     * @param upper Upper bound to consider when randomizing data.
     * @param size Specified size for new array data.
     * @return Array data whose contents are random integer values from specified range.
     */
    private static int[] randomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be <= Upper bound (%d)",
                            lower, upper));
        }
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d).", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + randomNumGen.nextInt(upper)).toArray();
    }

    /**
     * Computes the average of all data in integer array.
     * @param someData Integer array data to compute it's average.
     * @return Average of all data found in array.
     */
    private static double computeArrayAverageData(int[] someData) {
        return IntStream.of(someData).average().orElse(0.0d);
    }

    public static void main(String[] args) {

        int[] randomArrayData = randomIntegerArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Array Integer Data: %s%n", Arrays.toString(randomArrayData));

        System.out.printf("Average of all data: %.2f%n", computeArrayAverageData(randomArrayData));

    }
}
