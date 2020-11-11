package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Sorts a given array of distinct integers where all its numbers are  #
// #                     sorted except two numbers.                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 11, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_73 {

    private static final int MAX_LINE_LENGTH = 75;

    private static int[] sortRemaining2Elements(int[] dataSource) {
        int[] dataSourceCopy = IntStream.of(dataSource).toArray();

        if (dataSource.length < 2) {
            return dataSource;
        }

        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i + 1; j < dataSource.length; j++) {
                if (dataSourceCopy[i] > dataSource[j]) {
                    int tmp = dataSourceCopy[i];
                    dataSourceCopy[i] = dataSourceCopy[j];
                    dataSourceCopy[j] = tmp;
                }
            }

        }

        return dataSourceCopy;
    }

    public static void main(String[] args) {
        int[] testDataA = {3, 5, 6, 9, 8, 7};
        int[] testDataB = {5, 0, 1, 2, 3, 4, -2};

        BasicUtils.printLineInfo("[ MAIN TEST DATA ]", '=', MAX_LINE_LENGTH);

        System.out.printf("Generated Test Data A: %s%n", Arrays.toString(testDataA));
        System.out.printf("Generated Test Data B: %s%n", Arrays.toString(testDataB));

        BasicUtils.printLineInfo("[ SORTED DATA ]", '=', MAX_LINE_LENGTH);

        System.out.printf("Sorted Data A: %s%n", Arrays.toString(sortRemaining2Elements(testDataA)));
        System.out.printf("Sorted Data B: %s%n", Arrays.toString(sortRemaining2Elements(testDataB)));
    }

}
