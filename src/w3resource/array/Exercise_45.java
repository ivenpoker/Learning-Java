package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Cyclically rotate a given array clockwise by one.                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 29, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;
import w3resource.utils.ArrayUtils;

public class Exercise_45 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 15;
    private static final int ARRAY_SIZE = 5;

    private static int[] cyclicallyRotate(int[] dataSource) {
        int[] dataCopy = IntStream.of(dataSource).toArray();
        if (dataSource.length < 2) {
            return dataCopy;
        }

        int tmpEnd = dataCopy[dataCopy.length-1];
        for (int i = dataCopy.length-2; i >= 0; i--) {
            dataCopy[i+1] = dataCopy[i];
        }
        dataCopy[0] = tmpEnd;
        return dataCopy;
    }

    public static void main(String[] args) {

        int[] arrayData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(arrayData));

        int[] rotatedData = cyclicallyRotate(arrayData);
        System.out.printf("  Rotated data: %s%n", Arrays.toString(rotatedData));

    }
}
