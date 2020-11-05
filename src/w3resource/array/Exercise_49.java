package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Arranges the elements of a given array of integers where all        #
// #                     positive integers appear before all the negative integers.          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 5, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_49 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 15;
    private static final int ARRAY_SIZE = 10;

    private static int[] rearrangeArray(int[] dataSource) {
        int[] dataSourceCopy = IntStream.of(dataSource).toArray();

        for (int i = 0; i < dataSource.length; i++) {
            if (dataSource[i] < 0) {
                for (int j = i+1; j < dataSource.length; j++) {
                    if (dataSource[j] >= 0) {
                        int tmp = dataSource[i];
                        dataSource[i] = dataSource[j];
                        dataSource[j] = tmp;
                    }
                }
            }
        }
        return dataSourceCopy;
    }

    public static void main(String[] args) {

        int[] randomData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randomData));

        int[] dataSourceCopy = rearrangeArray(randomData);
        System.out.printf("After rearrange: %s%n",  Arrays.toString(dataSourceCopy));

        System.out.printf("Original data: %s%n", Arrays.toString(randomData));

    }
}
