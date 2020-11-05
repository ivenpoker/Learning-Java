package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Sorts an array of positive integers of a given array, in the sorted #
// #                     array the value of the first element should be maximum, second      #
// #                     value should be minimum value, third should be second maximum,      #
// #                     fourth second be second minimum and so on.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 5, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_50 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 20;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LEN = 70;

    private static boolean inRange(int lower, int val, int upper) {
        return lower <= val && val <= upper;
    }

    private static int getNthMaximum(int[] data, int nth) {
        if (!inRange(1, nth, data.length-1)) {
            throw new IllegalArgumentException(
                    String.format("Invalid nth value (%d). Must be in range [%d, %d]",
                            nth, 1, data.length-1));
        }
        return IntStream.of(data).sorted().toArray()[data.length - nth];
    }

    private static int getNthMinimum(int[] data, int nth) {
        if (!inRange(1, nth, data.length-1)) {
            throw new IllegalArgumentException(
                    String.format("Invalid nth value (%d). Must be in range [%d, %d]",
                            nth, 1, data.length-1));
        }
        return IntStream.of(data).sorted().toArray()[nth-1];
    }

    private static int[] performSort(int[] dataSource) {
        int[] dataSourceCopy = IntStream.of(dataSource).toArray();

        for (int i = 0, max = 1, min = 1; i < dataSource.length; i++) {
            if (i % 2 == 0) {
                dataSourceCopy[i] = getNthMaximum(dataSource, max++);
            } else {
                dataSourceCopy[i] = getNthMinimum(dataSource, min++);
            }
        }
        return dataSourceCopy;
    }

    public static void main(String[] args) {

        int[] randomData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated array: %s%n", Arrays.toString(randomData));

        int[] sortedData = performSort(randomData);

        System.out.printf("Sorted data: %s%n", Arrays.toString(sortedData));
        BasicUtils.printLine('-', MAX_LINE_LEN);

        int[] mainTest = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.printf("New Test Data: %s%n", Arrays.toString(mainTest));

        int[] mainTestSorted = performSort(mainTest);
        System.out.printf("Sorted Test Data: %s%n", Arrays.toString(mainTestSorted));

    }

}
