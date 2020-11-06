package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Check if a given array contains a subarray with 0 sum.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 5, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

public class Exercise_54 {

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
                } else if (innerSum < xVal) {
                    tmpList.add(dataSource[j]);
                    tmpSum += dataSource[j];
                }
            }
            if (foundSum) {
                masterList.add(tmpList);
            }
        }
        return masterList;
    }

    public static void main(String[] args) {
        int[] randomData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randomData));

        int targetSum = 0;
        List<List<Integer>> listOfAll_0_Sums = findAll_X_SubArraySums(randomData, targetSum);

        BasicUtils.printLine('-', LINE_WIDTH);

        if (!listOfAll_0_Sums.isEmpty()){
            System.out.printf("Found %d sub arrays that sum to %d:%n", listOfAll_0_Sums.size(), targetSum);
            BasicUtils.printLine('-', LINE_WIDTH);

            for (int i = 0, size = listOfAll_0_Sums.size(); i < size; i++) {
                System.out.printf("Array #%02d: %s%n",
                        i+1, Arrays.toString(listOfAll_0_Sums.get(i).toArray(new Integer[0])));
            }
        } else {
            System.out.printf("[NO SUB ARRAY SUMS TO '%d']%n", targetSum);
        }
    }
}
