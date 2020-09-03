package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Computes the average value of an array of integers except the       #
// #                     largest and smallest values.                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 3, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_29 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 30;
    private static final int SIZE = 15;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] generateRandomIntArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified bounds. Lower bound (%d) must be <= Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). Size must be > 0",
                    size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static double findAverageExceptMaxAndMin(int[] dataSource) {
        int max = IntStream.of(dataSource).max().getAsInt();
        int min = IntStream.of(dataSource).min().getAsInt();

        return IntStream.of(dataSource).filter((val) -> val != max || val != min).average().orElse(0.0f);
    }

    public static void main(String[] args) {

        int[] generateData = generateRandomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(generateData));

        System.out.printf("Average of data (excluding max and min in data): %.2f%n",
                findAverageExceptMaxAndMin(generateData));
    }

}
