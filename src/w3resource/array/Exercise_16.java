package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Removes duplicate elements from an array.                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 30, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise_16 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 15;
    private static final SecureRandom randomNumber = new SecureRandom();

    private static int[] randomIntegerArrayData(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be < Upper bound (%d).",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be >= 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + randomNumber.nextInt(upper)).toArray();
    }

    private static Integer[] removeDuplicatesA(int[] data) {
        List<Integer> uniqueList = new ArrayList<>();
        IntStream.of(data).forEach((val) -> {
            if (!uniqueList.contains(val)) {
                uniqueList.add(val);
            }
        });
        return uniqueList.toArray(new Integer[0]);
    }

    private static int[] removeDuplicatesB(int[] data) {
        return IntStream.of(data).distinct().toArray();
    }

    public static void main(String[] args) {

        int[] randomData = randomIntegerArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated array data: %s%n", Arrays.toString(randomData));

        Integer[] uniqueListA = removeDuplicatesA(randomData);
        int[] uniqueListB = removeDuplicatesB(randomData);

        System.out.printf("Unique list A: %s%n", Arrays.toString(uniqueListA));
        System.out.printf("Unique list B: %s%n", Arrays.toString(uniqueListB));
    }

}
