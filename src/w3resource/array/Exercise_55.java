package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Prints all sub-arrays with 0 sum present in a given array of        #
// #                     integers.                                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 5, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Exercise_55 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 20;
    private static final int ARRAY_SIZE = 15;
    private static final int LINE_WIDTH = 75;

    private static List<List<Integer>> findAll_X_SubArraySums(int[] dataSource, int xVal ) {
        List<List<Integer>> masterList = new LinkedList<>();

        for (int i = 0; i < dataSource.length; i++) {
            int tmpSum = dataSource[i];
            boolean foundSum = false;
            List<Integer> tmpList = new LinkedList<>();
            tmpList.add(tmpSum);

            for (int j = i+1; j < dataSource.length; j++) {
                int innerSum = tmpSum + dataSource[j];
                if (innerSum == xVal ) {
                    tmpList.add(dataSource[j]);
                    foundSum = true;
                    break;
                }
                tmpList.add(dataSource[j]);
                tmpSum += dataSource[j];
            }
            if (foundSum) {
                masterList.add(tmpList);
            }
        }
        return masterList;
    }

    private static void printSubarrays(List<List<Integer>> masterLists, int targetSum) {
        if (!masterLists.isEmpty()){
            System.out.printf("Found %d sub arrays that sum to %d:%n", masterLists.size(), targetSum);
            BasicUtils.printLine('-', LINE_WIDTH);

            for (int i = 0, size = masterLists.size(); i < size; i++) {
                System.out.printf("Array #%02d: %s%n",
                        i+1, Arrays.toString(masterLists.get(i).toArray(new Integer[0])));
            }
        } else {
            System.out.printf("[NO SUB ARRAY SUMS TO '%d']%n", targetSum);
        }
    }

    public static void main(String[] args) {
        int[] randomData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randomData));

        int targetSum = 0;
        List<List<Integer>> listOfAll_0_Sums = findAll_X_SubArraySums(randomData, targetSum);

        BasicUtils.printLine('-', LINE_WIDTH);

        printSubarrays(listOfAll_0_Sums, targetSum);

        // Test #1
        System.out.println("\n");
        BasicUtils.printLine('-', LINE_WIDTH);

        int[] testData1 = {1, 3, -7, 3, 2, 3, 1, -3, -2, -2};
        System.out.printf("TEST #1: [Data: %s]%n", Arrays.toString(testData1));
        BasicUtils.printLine('-', LINE_WIDTH);

        List<List<Integer>>  listOfAll_0_Sums_1 = findAll_X_SubArraySums(testData1, targetSum);
        printSubarrays(listOfAll_0_Sums_1, targetSum);

        // Test #2
        System.out.println("\n");
        BasicUtils.printLine('-', LINE_WIDTH);

        int[] testData2 = {1, 2, -3, 4, 5, 6};
        System.out.printf("TEST #2: [Data: %s]%n", Arrays.toString(testData2));
        BasicUtils.printLine('-', LINE_WIDTH);

        List<List<Integer>> listOfAll_0_Sums_2 = findAll_X_SubArraySums(testData2, targetSum);
        printSubarrays(listOfAll_0_Sums_2, targetSum);

        // Test #2
        System.out.println("\n");
        BasicUtils.printLine('-', LINE_WIDTH);

        int[] testData3 = {1, 2, -2, 3, 4, 5, 6};
        System.out.printf("TEST #3: [Data: %s]%n", Arrays.toString(testData3));
        BasicUtils.printLine('-', LINE_WIDTH);

        List<List<Integer>> listOfAll_0_Sums_3 = findAll_X_SubArraySums(testData3, targetSum);
        printSubarrays(listOfAll_0_Sums_3, targetSum);




    }
}
