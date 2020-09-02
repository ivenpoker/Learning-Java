package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the second smallest value in an array of integer values.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Exercise_18 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 15;
    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be < Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). Must be >= 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static int findSecondSmallestInArray_A(final int[] data) {
        int[] uniqueSortedCopy = IntStream.of(data).sorted().distinct().toArray();
        return uniqueSortedCopy.length <= 1 ? Integer.MIN_VALUE : uniqueSortedCopy[1];
    }

    private static int findSecondSmallestInArray_B(final int[] data) {
        int fstLowest = Integer.MAX_VALUE;
        int sndLowest = Integer.MAX_VALUE;

        for (int datum : data) {
            if (datum < fstLowest) {
                sndLowest = fstLowest;
                fstLowest = datum;
            } else if (datum < sndLowest) {
                sndLowest = datum;
            }
        }
        return sndLowest;
    }

    public static void main(String[] args) {

        int[] randomData = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randomData));

        System.out.printf("Second smallest [using method A]: %d%n", findSecondSmallestInArray_A(randomData));
        System.out.printf("Second smallest [using method B]: %d%n", findSecondSmallestInArray_B(randomData));
    }

}
