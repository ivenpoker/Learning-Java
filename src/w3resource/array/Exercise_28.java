package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the difference between the largest and smallest values in an  #
// #                     array of integers. The length of the array must be 1 and above.     #       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 3, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_28 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 50;
    private static final int SIZE = 10;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] randomIntArrayData(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must <= Upper bound (%d)",
                            lower, upper));
        } else if (size <= 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    public static void main(String[] args) {

        int[] randomGeneratedData = randomIntArrayData(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randomGeneratedData));

        int max = IntStream.of(randomGeneratedData).max().getAsInt();
        int min = IntStream.of(randomGeneratedData).min().getAsInt();

        System.out.printf("Max is '%d' | Min is '%d' | Difference: %d%n", max, min, (max - min));

    }
}
