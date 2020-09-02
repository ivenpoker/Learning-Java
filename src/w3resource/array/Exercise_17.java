package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the second largest value in an array of integer values.       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Exercise_17 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 15;
    private static final SecureRandom secureRandom = new SecureRandom();

    private static int findSecondLargestInArrayA(final int[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException(String.format("Array size (%d) must be > 2 to find second largest",
                    data.length));
        }
        int[] sortedData = IntStream.of(data).sorted().toArray();
        return sortedData[sortedData.length-2];
    }

    private static int findSecondLargestInArrayB(final int[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException(String.format("Array size (%d) must be > 2 to find second largest",
                    data.length));
        }
        int fstLargest = 0;
        int sndLargest = 0;
        for (int datum : data) {
            if (datum > fstLargest) {
                sndLargest = fstLargest;
                fstLargest = datum;
            } else if (datum > sndLargest) {
                sndLargest = datum;
            }
        }
        return sndLargest;
    }

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(String.format("Invalid bounds. Lower bound (%d) must " +
                    "be <= Upper bound (%d)", lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size. Size (%d) must be >= 0", size));
        }
        return IntStream.of(new int[size]).map((val) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    public static void main(String[] args) {

        int[] newRandomData = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated array: %s%n", Arrays.toString(newRandomData));

        System.out.printf("Second largest [using method A]: %d%n", findSecondLargestInArrayA(newRandomData));
        System.out.printf("Second largest [using method B]: %d%n", findSecondLargestInArrayB(newRandomData));

    }

}
