package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the missing number(s) in an array.                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;

public class Exercise_24 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;
    private static final int SIZE = 10;
    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] createRandomIntArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be <= Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid size (%d). Must be >= 0", size));
        }
        return IntStream.of(new int[size]).map((val) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static List<Integer> findMissingBetweenTwo(int fst, int snd) {
        List<Integer> missingInts = new ArrayList<>();
        if (snd - fst == 1) {
            return missingInts;
        } else {
            for (int i = fst+1; i < snd; i++) {
                missingInts.add(i);
            }
        }
        return missingInts;
    }

    private static List<Integer> findAllMissingNumbers(int[] data) {
        List<Integer> missingInts = new ArrayList<>();
        int[] sortedData = IntStream.of(data).distinct().sorted().toArray();

        for (int i = 0; i < sortedData.length-1; i++) {
            List<Integer> currMissInts = findMissingBetweenTwo(sortedData[i], sortedData[i+1]);
            for (int curr : currMissInts) {
                if (!missingInts.contains(curr)) {
                    missingInts.add(curr);
                }
            }
        }
        return missingInts;
    }

    public static void main(String[] args) {

        int[] randomIntArray = createRandomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generate array data: %s%n", Arrays.toString(randomIntArray));

        System.out.printf("Unique sorted data: %s%n", Arrays.toString(IntStream.of(randomIntArray).
                                                            distinct().sorted().toArray()));

        List<Integer> missingInts = findAllMissingNumbers(randomIntArray);
        System.out.printf("Missing values: %s%n", missingInts);

    }
}













































