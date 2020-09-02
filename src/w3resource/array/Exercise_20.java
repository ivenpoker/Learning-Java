package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Converts an array to ArrayList.                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise_20 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 15;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified bounds. Lower bound (%d) must be <= Upper bound (%d).",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Size must be >= 0.", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static List<Integer> convertArrayToList(int[] arrayData) {
        List<Integer> intList = new ArrayList<>();
        for (int val : arrayData) {
            intList.add(val);
        }
        return intList;
    }

    public static void main(String[] args) {

        int[] randomData = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated array data: %s%n", Arrays.toString(randomData));

        List<Integer> intList = convertArrayToList(randomData);
        System.out.printf("Array as list: %s%n", intList);
    }
}
