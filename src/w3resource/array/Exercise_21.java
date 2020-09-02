package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Converts an ArrayList to an Array.                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercise_21 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;
    private static final int SIZE = 10;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static ArrayList<Integer> createListOfRandomData(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException
                    (String.format("Invalid specified bounds. Lower bound (%d) must be <= Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). Must be >= 0", size));
        }
        Integer[] randomIntData = Arrays.stream(new Integer[size]).map((val) -> lower +
                                                secureRandom.nextInt(upper)).toArray(Integer[]::new);
        return new ArrayList<>(Arrays.asList(randomIntData));
    }

    public static void main(String[] args) {

        ArrayList<Integer> randIntList = createListOfRandomData(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated list data: %s%n", randIntList);

        Integer[] intArrayOfRandList = randIntList.toArray(new Integer[0]);
        System.out.printf("Converted array data: %s%n", Arrays.toString(intArrayOfRandList));

    }
}
