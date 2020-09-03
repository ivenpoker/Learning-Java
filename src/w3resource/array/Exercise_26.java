package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Moves all 0's to the end of the array. Maintaining relative order   #
// #                     of the other (non-zero) array elements.                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_26 {

    private static final int LOWER_BOUND = -1;
    private static final int UPPER_BOUND = 5;
    private static final int SIZE = 15;
    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] generateRandomIntArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified bounds. Lower bound (%d) must be <= Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). Must be >= 0",
                    size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static int[] moveAllZerosToFront(int[] dataSource, int targetNum) {
        int[] dataCopy = new int[dataSource.length];
        int zerosCnt = IntStream.of(dataSource).filter((val) -> val == targetNum).toArray().length;

        for (int i = 0, idx = zerosCnt; i < dataCopy.length; i++) {
            if (dataSource[i] != targetNum) {
                dataCopy[idx++] = dataSource[i];
            }
        }
        return dataCopy;
    }

    public static void main(String[] args) {

        int[] generatedData = generateRandomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(generatedData));

        int[] newNums = moveAllZerosToFront(generatedData, 0);
        System.out.printf("After shifting 0's: %s%n", Arrays.toString(newNums));
    }

}




















