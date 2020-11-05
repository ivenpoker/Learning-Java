package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Separates even and odd numbers of a given array of integers. Put    #
// #                     all even numbers first and then odd numbers.                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 5, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_52 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 15;
    private static final int ARRAY_SIZE = 15;

    private static int[] rearrangeData(int[] dataSource) {
        int[] dataCopy = IntStream.of(dataSource).toArray();
        for (int i = 0; i < dataCopy.length; i++) {
            if (dataCopy[i] % 2 == 1) {
                for (int j = i+1; j < dataCopy.length; j++) {
                    if (dataCopy[j] % 2 == 0) {
                        int tmp = dataCopy[i];
                        dataCopy[i] = dataCopy[j];
                        dataCopy[j] = tmp;
                        break;
                    }
                }
            }
        }
        return dataCopy;
    }

    public static void main(String[] args) {

        int[] randomDAta = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randomDAta));

        int[] processedData = rearrangeData(randomDAta);
        System.out.printf("Processed data: %s%n", Arrays.toString(processedData));

    }

}
