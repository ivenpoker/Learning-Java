package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the majority element from a given array of integers containing #
// #                     duplicates. Majority element is an element that appears more than   #
// #                     n/2 times where n is the size of the array.                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import w3resource.utils.ArrayUtils;

public class Exercise_38 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 3;
    private static final int ARRAY_SIZE = 20;

    private static String findMajorityElementFromArray(int[] dataSource) {
        Map<Integer, Integer> intOccurrenceCnt = new HashMap<>();
        for (int datum : dataSource) {
            if (intOccurrenceCnt.containsKey(datum)) {
                int oldVal = intOccurrenceCnt.get(datum);
                intOccurrenceCnt.put(datum, oldVal + 1);
            } else {
                intOccurrenceCnt.put(datum, 1);
            }
        }
        int majorityElem = Integer.MIN_VALUE;
        int maxValOccurrence = 0;
        for (int key : intOccurrenceCnt.keySet()) {
            int keyVal = intOccurrenceCnt.get(key);
            if (keyVal > maxValOccurrence) {
                majorityElem = key;
                maxValOccurrence = keyVal;
            }
        }
        return maxValOccurrence > dataSource.length/2 ? "" + majorityElem : "";
    }

    public static void main(String[] args) {

        int[] dataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Array size: %s%n", Arrays.toString(dataSource));

        String majorityElem = findMajorityElementFromArray(dataSource);
        System.out.printf("Majority element: %s%n", (majorityElem.isEmpty() ? "[NONE]" : majorityElem));
    }

}
