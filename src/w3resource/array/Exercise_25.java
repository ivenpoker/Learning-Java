package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds common elements from three sorted (in non-decreasing order)   #
// #                     arrays.                                                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 3, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_25 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;
    private static final int SIZE = 10;
    private static final SecureRandom secureRandom = new SecureRandom();

    private static Integer[] generateRandomIntArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be < Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return Arrays.stream(new Integer[size]).map((i) -> lower + secureRandom.nextInt(upper))
                            .toArray(Integer[]::new);
    }

    private static List<Integer> findCommonInArrays(Integer[] dataA, Integer[] dataB, Integer[] dataC) {
        List<Integer> listA = Arrays.stream(dataA).collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(dataB).collect(Collectors.toList());
        List<Integer> listC = Arrays.stream(dataC).collect(Collectors.toList());

        List<Integer> commonInts = new ArrayList<>();
        for (Integer valA : listA) {
            if (listB.contains(valA) && listC.contains(valA) && !commonInts.contains(valA)) {
                commonInts.add(valA);
            }
        }
        for (Integer valB : listB) {
            if (listA.contains(valB) && listC.contains(valB) && !commonInts.contains(valB)) {
                commonInts.add(valB);
            }
        }
        for (Integer valC : listC) {
            if (listB.contains(valC) && listC.contains(valC) && !commonInts.contains(valC)) {
                commonInts.add(valC);
            }
        }
        return commonInts;
    }

    public static void main(String[] args) {

        Integer[] dataA = generateRandomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        Integer[] dataB = generateRandomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        Integer[] dataC = generateRandomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);


        System.out.printf("Generated data A: %s%n", Arrays.toString(dataA));
        System.out.printf("Generated data B: %s%n", Arrays.toString(dataB));
        System.out.printf("Generated data C: %s%n", Arrays.toString(dataC));

        List<Integer> commonInts = findCommonInArrays(dataA, dataB, dataC);
        System.out.printf("\nCommon in all data sets: %s%n", commonInts);

    }
}













