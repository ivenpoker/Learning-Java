package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Sorts a numeric array and a string array.                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

public class Exercise_1 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 15;
    private static final SecureRandom randomNumber = new SecureRandom();

    private static final String testData = "afghiblrstucdejkvwxyzmnopq";

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (low > high) {
            throw new IllegalArgumentException(
                    String.format("Lower bound (%d) must be > upper bound (%d)", low, high));
        }
        if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size])
                    .map((i) -> low + randomNumber.nextInt(high))
                    .sorted()
                    .toArray();
    }

    private static String[] randomStringArray() {
        List<String> strList = Stream.of(testData.split("")).sorted().collect(Collectors.toList());
        return strList.toArray(new String[0]);
    }

    public static void main(String[] args) {

        int[] arrayData = randomIntegerArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        String[] strData = randomStringArray();

        System.out.printf("Generated array data: %s%n", Arrays.toString(arrayData));
        System.out.printf("Generated string data: %s%n", Arrays.toString(strData));

    }

}



































































