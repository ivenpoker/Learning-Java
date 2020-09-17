package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Prints all the LEADERS in the array. An element is leader if it is  #
// #                     greater than all elements to it's right.                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import w3resource.utils.ArrayUtils;

public class Exercise_39 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 15;

    private static List<Integer> findAllLeadersInArray(int[] dataSource) {
        List<Integer> leaders = new ArrayList<>();
        if (dataSource.length == 0 || dataSource.length == 1) {
            return leaders;
        }
        for (int i = 0; i < dataSource.length; i++) {
            boolean isLeader = true;
            for (int j = i+1; j < dataSource.length; j++) {
                if (dataSource[i] <= dataSource[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                leaders.add(dataSource[i]);
            }
        }
        return leaders;
    }

    public static void main(String[] args) {

        int[] arrayData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Array data: %s%n", Arrays.toString(arrayData));
        System.out.printf("Leaders: %s%n", findAllLeadersInArray(arrayData));

    }

}
