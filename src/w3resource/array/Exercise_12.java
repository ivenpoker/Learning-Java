package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds duplicate values of an array of integer values.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 30, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;

public class Exercise_12 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_SIZE = 15;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified bounds. Lower bound (%d) must be < Upper bound (%d)%n",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((val) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static Integer[] findDuplicates(int[] mainData) {
        List<Integer> dupList = new ArrayList<>();

        for (int curr : mainData) {
            if (IntStream.of(mainData).filter(val -> val == curr).count() > 1 &&
                    !dupList.contains(curr)) {
                dupList.add(curr);
            }
        }
        return dupList.toArray(new Integer[0]);
    }

    public static void main(String[] args) {

        int[] randomData = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randomData));

        Integer[] dups = findDuplicates(randomData);
        System.out.printf("Duplicates in array: %s%n", Arrays.toString(dups));
    }
}
