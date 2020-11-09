package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the smallest length of a contiguous subarray of which the sum #
// #                     is greater than or equal to specified value. Return 0 instead.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 9, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_70 {

    private static final int MAX_LINE_LENGTH = 75;

    private static List<Integer> findContiguousSubArray(int[] dataSource, int targetSum) {
        List<Integer> smallContSubArray = new ArrayList<>();
        for (int i = 0; i < dataSource.length; i++) {

            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(dataSource[i]);

            for (int j = i+1; j < dataSource.length; j++) {
                tmpList.add(dataSource[j]);
            }

            if (tmpList.stream().reduce(0, Integer::sum) >= targetSum) {
                if (smallContSubArray.isEmpty() || tmpList.size() < smallContSubArray.size()) {
                    smallContSubArray = tmpList;
                }
            }
        }
        return smallContSubArray;
    }

    public static void main(String[] args) {
        int[] mainTestData = {1, 2, 3, 4, 6};

        BasicUtils.printLineInfo("[ MAIN TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Test Array Data: %s%n", Arrays.toString(mainTestData));

        BasicUtils.printLineInfo("[ TEST RESULTS ]", '=', MAX_LINE_LENGTH);

        int targetSum = 8;
        List<Integer> smallData = findContiguousSubArray(mainTestData, targetSum);

        System.out.printf("Minimum Length: %d | Array Data: %s%n", smallData.size(),
                Arrays.toString(smallData.toArray(new Integer[0])));
    }
}
