package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Arranges the elements of a given array of integers where all        #
// #                     negative integers appear before all the positive integers.          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 5, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;

import w3resource.utils.ArrayUtils;

public class Exercise_48 {

    private static final int LOWER_BOUND = -3;
    private static final int UPPER_BOUND = 15;
    private static final int ARRAY_SIZE = 10;

    private static int[] rearrangeData(int[] dataSource) {
        int[] dataSourceCopy = IntStream.of(dataSource).toArray();

        for (int i = 0; i < dataSourceCopy.length; i++) {
            if (dataSourceCopy[i] >= 0) {
                for (int j = i+1; j < dataSourceCopy.length; j++) {
                    if (dataSourceCopy[j] < 0) {
                        int tmp = dataSourceCopy[i];
                        dataSourceCopy[i] = dataSourceCopy[j];
                        dataSourceCopy[j] = tmp;
                    }
                }
            }
        }
        return dataSourceCopy;
    }

    public static void main(String[] args) {

        int[] dataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(dataSource));

        int[] processedData = rearrangeData(dataSource);
        System.out.printf("Results: %s%n", Arrays.toString(processedData));

        System.out.printf("Original data: %s%n", Arrays.toString(dataSource));

    }
}
