package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Sorts a given binary array in linear times.                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 5, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_56 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 2;
    private static final int ARRAY_SIZE = 15;

    private static int[] performLinearBinarySort(int[] dataSource) {
        int[] dataCopy = IntStream.of(dataSource).toArray();

        int k = 0;
        for (int i = 0; i < dataCopy.length; i++) {
            if (dataSource[i] == 0) {
                dataCopy[k++] = 0;
            }
        }
        for (int i = k; i < dataCopy.length; i++) {
            dataCopy[k++] = 1;
        }
        return dataCopy;
    }

    public static void main(String[] args) {

        int[] randomBinaryData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randomBinaryData));

        int[] processedData = performLinearBinarySort(randomBinaryData);

        System.out.printf("Processed Array: %s%n", Arrays.toString(processedData));

    }
}
