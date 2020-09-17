package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Segregate all 0s on left side and all 1s on right side of a given   #
// #                     array of 0s and 1s.                                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;
import w3resource.utils.ArrayUtils;

public class Exercise_42 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 2;
    private static final int ARRAY_SIZE = 10;

    private static void processOnesAndZerosA(int[] dataSource) {
        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j < dataSource.length; j++) {
                if (dataSource[j] == 0 && dataSource[i] != 0) {
                    int tmp = dataSource[i];
                    dataSource[i] = dataSource[j];
                    dataSource[j] = tmp;
                }
            }
        }
    }

    private static int[] processOnesAndZerosB(int[] dataSource) {
        return IntStream.of(dataSource).sorted().toArray();
    }


    public static void main(String[] args) {
        int[] dataSourceA = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("[A] Generated data: %s%n", Arrays.toString(dataSourceA));

        processOnesAndZerosA(dataSourceA);
        System.out.printf("[A] Processed data: %s%n", Arrays.toString(dataSourceA));

        System.out.println();

        int[] dataSourceB = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("[B] Generated data: %s%n", Arrays.toString(dataSourceB));
        System.out.printf("[B] Processed data: %s%n", Arrays.toString(processOnesAndZerosB(dataSourceB)));
    }
}
