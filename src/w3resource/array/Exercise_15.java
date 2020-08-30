package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the common elements between two arrays of integers.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 30, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise_15 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_SIZE = 10;
    private static final SecureRandom randomInteger = new SecureRandom();

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Lower bound (%d) must be <= Upper bound (%d).",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d) for new array. Must be >= 0",
                            size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + randomInteger.nextInt(upper)).toArray();
    }

    private static Integer[] findCommonInArrays(int[] dataA, int[] dataB) {
        List<Integer> commonsList = new ArrayList<>();

        // Finds all values in 'dataA' that are also in 'dataB'
        Arrays.stream(dataA).forEach((valA) -> {
            if (!commonsList.contains(valA) &&
                    IntStream.of(dataB).anyMatch((valB) -> valA == valB)) {
                commonsList.add(valA);
            }
        });

//        // Finds all values in 'dataB' that are also in 'dataA'
//        Arrays.stream(dataB).forEach((valB) -> {
//            if (!commonsList.contains(valB) &&
//                    IntStream.of(dataA).anyMatch((valA) -> valB == valA)) {
//                commonsList.add(valB);
//            }
//        });

        return commonsList.toArray(new Integer[0]);
    }

    public static void main(String[] args) {

        int[] randomA = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        int[] randomB = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        System.out.printf("Random A: %s%n", Arrays.toString(randomA));
        System.out.printf("Random B: %s%n", Arrays.toString(randomB));

        Integer[] commonInBothArrays = findCommonInArrays(randomA, randomB);

        System.out.printf("Common data in both arrays: %s%n", Arrays.toString(commonInBothArrays));
    }

}
