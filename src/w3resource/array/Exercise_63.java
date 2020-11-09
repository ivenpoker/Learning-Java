package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Replaces each element of the array with product of every other      #
// #                     element in a given array of integers.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 9, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_63 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 5;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LEN = 70;

    private static int findProdExceptIndex(int[] dataSource, int index) {
        int prod = 1;
        for (int i = 0; i < dataSource.length; i++) {
            if (i != index) {
                prod *= dataSource[i];
            }
        }
        return prod;
    }

    private static void performReplacements(int[] dataSource) {
        int[] dataSourceCopy = IntStream.of(dataSource).toArray();

        for (int i = 0; i < dataSource.length; i++) {
            dataSourceCopy[i] = findProdExceptIndex(dataSource, i);
        }

        // Update original data source
        System.arraycopy(dataSourceCopy, 0, dataSource, 0, dataSource.length);
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        BasicUtils.printLineInfo("[ FIRST TEST CASE ]", '=', MAX_LINE_LEN);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randomArray));

        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_LINE_LEN);

        performReplacements(randomArray);
        System.out.printf("After replacements: %s%n", Arrays.toString(randomArray));

        BasicUtils.printLineInfo("[ SECOND TEST CASE ]", '=', MAX_LINE_LEN);
        int[] testData1 = { 1, 2, 3, 4, 5, 6, 7};

        System.out.printf("Generated Array: %s%n", Arrays.toString(testData1));

        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_LINE_LEN);

        performReplacements(testData1);
        System.out.printf("After replacements: %s%n", Arrays.toString(testData1));

    }

}
