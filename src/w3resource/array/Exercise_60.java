package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Shuffles a given array of integers.                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 8, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_60 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 15;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LENGTH = 75;

    private static final SecureRandom random = new SecureRandom();

    private static void shuffleArray(int[] dataSource) {
        for (int i = 0; i < dataSource.length; i++) {
            int randA = random.nextInt(dataSource.length);
            int randB = random.nextInt(dataSource.length);

            // Perform swap 🤪

            int tmp = dataSource[randA];
            dataSource[randA] = dataSource[randB];
            dataSource[randB] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] randomIntArray = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        System.out.println();
        BasicUtils.printLineMessage("[ FIRST TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.println();

        System.out.printf("Generated array data: %s%n", Arrays.toString(randomIntArray));
        shuffleArray(randomIntArray);

        System.out.printf("Shuffled data: %s%n", Arrays.toString(randomIntArray));
    }
}
