package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Reverses an array of integer values.                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 27, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_11 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_SIZE = 15;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] generateRandomIntArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be > Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((val) -> lower + secureRandom.nextInt(upper)).toArray();
    }


    private static int[] reverseArrayData(int[] mainArray) {
        int[] dataCopy = IntStream.of(mainArray).toArray();
        for (int i = dataCopy.length-1, j = 0; i > j; i--, j++) {
            int tmp = dataCopy[i];
            dataCopy[i] = dataCopy[j];
            dataCopy[j] = tmp;
        }
        return dataCopy;
    }

    public static void main(String[] args) {

        int[] mainData = generateRandomIntArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf(" Generated array: %s%n", Arrays.toString(mainData));

        System.out.printf("Reverse of array: %s%n", Arrays.toString(reverseArrayData(mainData)));
        System.out.printf("  Original array: %s%n", Arrays.toString(mainData));

    }
}
