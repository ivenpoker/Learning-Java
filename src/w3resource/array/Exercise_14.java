package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the common elements between two arrays of Strings.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 30, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise_14 {

    private static final int ARRAY_SIZE = 20;
    private static final String alphabet = "abcdefghijklmnopqrst";
    private static final SecureRandom randomNumber = new SecureRandom();

    private static String[] createRandomStringData(String fromStr, int size) {
        String[] strChars = fromStr.split("");
        String[] randomData = new String[size];

        // Just fill 'randomData' with randomly chosen data from 'strChars' array.
        for (int i = 0; i < size; i++) {

            // Random index from given string
            int idx = randomNumber.nextInt(strChars.length);
            String idxVal = strChars[idx];

            int randIdx = randomNumber.nextInt(randomData.length);
            randomData[randIdx] = idxVal;
        }

        // Converts random array data to list.
        List<String> listData = Arrays.asList(randomData);

        // Shuffle the data to make if really look random
        Collections.shuffle(listData);

        // Remove possible null values.
        listData = listData.stream().filter((val) -> !Objects.isNull(val)).collect(Collectors.toList());

        // Return a String array version of the non-null list data.
        return listData.toArray(new String[0]);
    }

    private static String[] findCommonValuesInArrays(String[] dataA, String[] dataB) {
        List<String> commonStrList = new ArrayList<>();
        Arrays.stream(dataA).forEach((valA) -> {
            if (!commonStrList.contains(valA) &&
                    Stream.of(dataB).filter((valB) -> valA.equals(valB)).count() > 1) {
                commonStrList.add(valA);
            }
        });
        return commonStrList.toArray(new String[0]);
    }

    public static void main(String[] args) {

        String[] randomDataA = createRandomStringData(alphabet, ARRAY_SIZE);
        String[] randomDataB = createRandomStringData(alphabet, ARRAY_SIZE);

        System.out.printf("Random data A: %s%n", Arrays.toString(randomDataA));
        System.out.printf("Random data B: %s%n", Arrays.toString(randomDataB));

        String[] commonStrs = findCommonValuesInArrays(randomDataA, randomDataB);
        System.out.printf("Common values: %s%n", Arrays.toString(commonStrs));

    }
}
