package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Copies an array by iterating through the array.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 27, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_8 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_SIZE = 15;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bound. Lower bound '%d' must be > Upper bound '%d'",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static int[] makeCopyOfArray(int[] mainArrayData) {
        int[] newArrayCopy = new int[mainArrayData.length];
        for (int i = 0; i < mainArrayData.length; i++) {
            newArrayCopy[i] = mainArrayData[i];
        }
        return newArrayCopy;
    }

    public static void main(String[] args) {

        int[] randomIntegerArrayData = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated array data: %s%n", Arrays.toString(randomIntegerArrayData));

        int[] copiedData = makeCopyOfArray(randomIntegerArrayData);
        System.out.printf("Copied array data: %s%n", Arrays.toString(copiedData));

    }
}
