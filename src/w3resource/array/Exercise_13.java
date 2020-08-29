package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds duplicate values of an array of String values.                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 30, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Exercise_13 {

    private static final int ARRAY_SIZE = 10;
    private static final SecureRandom randomNumber = new SecureRandom();
    private static final String alphabet = "abcdefghijklmnopq";

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

    private static String[] findDuplicateValuesInStringArray(String[] data) {
        List<String> dupList = new ArrayList<>();

        // For each data in the passed array, we find the number of times
        // the array item occurs in the array and check the duplicates from it's count.
        // i.e elements with counts > 1 are added to list of duplicates if and only if
        // they aren't already there.

        Arrays.stream(data).forEach((val) -> {
            if (Arrays.stream(data).filter((x) -> x.equals(val)).count() > 1) {

                if (!dupList.contains(val)) {
                    dupList.add(val);
                }
            }
        });
        return dupList.toArray(new String[0]);
    }

    public static void main(String[] args) {

        String[] randomStrData = createRandomStringData(alphabet, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randomStrData));

        // Find duplicates in generated and print them.
        String[] dups = findDuplicateValuesInStringArray(randomStrData);
        System.out.printf("Duplicates: %s%n", Arrays.toString(dups));
    }

}
