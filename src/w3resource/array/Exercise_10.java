package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the maximum and minimum value of an array.                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 27, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_10 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 1000;
    private static final int ARRAY_SIZE = 15;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be > Upper bound (%d)%n",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    public static void main(String[] args) {

        int[] randomIntArray = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated integer array: %s%n", Arrays.toString(randomIntArray));

        System.out.printf("Maximum in data: %d%n", IntStream.of(randomIntArray).max().orElse(0));
        System.out.printf("Minimum in data: %d%n", IntStream.of(randomIntArray).min().orElse(0));

    }

}
