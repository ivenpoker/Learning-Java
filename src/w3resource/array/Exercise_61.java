package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Rearranges a given array of unique elements such that every second  #
// #                     element of the array is greater than its left and right elements.   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 8, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;

public class Exercise_61 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 15;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LEN = 70;

    private static void rearrange(int[] dataSource) {
        if (dataSource.length <= 2) {
            if (dataSource.length == 2) {
                if (dataSource[0] > dataSource[1]) {
                    int tmp = dataSource[1];
                    dataSource[1] = dataSource[0];
                    dataSource[0] = tmp;
                }
            }
        } else {
            for (int i = 1; i < dataSource.length; i += 2) {
                for (int j = i+1; j < dataSource.length; j++) {
                    if (dataSource[i] > dataSource[j] && dataSource[i] > dataSource[i-1]) {
                        break;
                    }
                    if ((dataSource[j] > dataSource[i]) &&
                            (dataSource[j] > dataSource[i-1])) {
                        int tmp = dataSource[i];
                        dataSource[i] = dataSource[j];
                        dataSource[j] = tmp;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] randomIntArray = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        System.out.println();
        BasicUtils.printLineMessage("[ FIRST TEST CASE ]", '=', MAX_LINE_LEN);
        System.out.println();

        System.out.printf("Generated Array Data: %s%n", Arrays.toString(randomIntArray));

        rearrange(randomIntArray);

        System.out.println();
        BasicUtils.printLineMessage("[ AFTER PROCESSING ]", '=', MAX_LINE_LEN);
        System.out.println();

        System.out.printf("Rearranged Array Data: %s%n", Arrays.toString(randomIntArray));

        System.out.println();
        BasicUtils.printLineMessage("[ SECOND TEST CASE ]", '=', MAX_LINE_LEN);
        System.out.println();

        int[] testData = {1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14};
        System.out.printf("Test data array: %s%n", Arrays.toString(testData));

        rearrange(testData);

        System.out.println();
        BasicUtils.printLineMessage("[ AFTER PROCESSING ]", '=', MAX_LINE_LEN);
        System.out.println();

        System.out.printf("Rearranged Array Data: %s%n", Arrays.toString(testData));

    }

}
