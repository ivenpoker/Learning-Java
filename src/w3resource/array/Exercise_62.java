package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the equilibrium indices from a given array of integers.       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 8, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_62 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LENGTH = 75;

    private static int findSumInRange(int[] dataSource, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException(
                    String.format("Invalid indices specified. " +
                            "Start (%d) index must be > end index (%d)", start, end));
        }
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += dataSource[i];
        }
        return sum;
    }

    private static List<Integer> findAllEquilibriumIndices(int[] dataSource) {
        List<Integer> indicesList = new ArrayList<>();
        for (int i = 0; i < dataSource.length; i++) {
            if (i > 0) {
                int leftSum = findSumInRange(dataSource, 0, i);

                if (i == dataSource.length-1) {
                    if (leftSum == 0) {
                        indicesList.add(i);
                    }
                } else {
                    int rightSum = findSumInRange(dataSource, i+1, dataSource.length);
                    if (leftSum == rightSum) {
                        indicesList.add(i);
                    }
                }
            }
        }

        return indicesList;
    }

    public static void main(String[] args) {

        int[] randomData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.println();
        BasicUtils.printLineMessage("[ FIRST TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.println();

        System.out.printf("Generated Array Data: %s%n", Arrays.toString(randomData));

        System.out.println();
        BasicUtils.printLineMessage("[ RESULTS ]", '=', MAX_LINE_LENGTH);
        System.out.println();

        List<Integer> indicesList = findAllEquilibriumIndices(randomData);

        System.out.printf("List of equilibrium indices: %s%n", Arrays.toString(indicesList.toArray(new Integer[0])));

        System.out.println();
        BasicUtils.printLineMessage("[ SECOND TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.println();

        int[] testData = {-7, 1, 5, 2, -4, 3, 0};
        System.out.printf("Test Data: %s%n", Arrays.toString(testData));

        System.out.println();
        BasicUtils.printLineMessage("[ RESULTS ]", '=', MAX_LINE_LENGTH);
        System.out.println();

        indicesList = findAllEquilibriumIndices(testData);
        System.out.printf("List of equilibrium indices: %s%n", Arrays.toString(indicesList.toArray(new Integer[0])));
    }
}
