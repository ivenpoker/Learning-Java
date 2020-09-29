package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the rotation count in a given rotated sorted array of         #
// #                     integers.                                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 29, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import w3resource.utils.ArrayUtils;

public class Exercise_47 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 15;
    private static final int ARRAY_SIZE = 10;

    private static int countRotations(int[] dataSource, int n) {
        int minVal = dataSource[0], minIdx = -1;
        for (int i = 0; i < n; i++) {
            if (minVal > dataSource[i]) {
                minVal = dataSource[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {

        int[] mainData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(mainData));

        int rotationCnt = countRotations(mainData, mainData.length);
        System.out.printf("Rotation count: %d%n", rotationCnt);
    }
}
