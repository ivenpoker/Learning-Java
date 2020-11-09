package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the longest Bitonic Subarray in a given array.                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 9, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_64 {

    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 20;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LENGTH = 70;

    private static List<ArrayList<Integer>> findBitonicSubarrays(int[] dataSource) {
        List<ArrayList<Integer>> bitonicArrayList = new ArrayList<>();

        for (int i = 0; i < dataSource.length; i++) {
            ArrayList<Integer> currList = new ArrayList<>();
            currList.add(dataSource[i]);

            boolean increasing = true;

            for (int j = i+1; j < dataSource.length; j++) {
                int last = currList.get(currList.size()-1);
                if (last < dataSource[j] && increasing) {
                    currList.add(dataSource[j]);
                } else if (last < dataSource[j] && !increasing) {
                    break;
                } else if (last > dataSource[j] && increasing) {
                    increasing = false;
                    currList.add(dataSource[j]);
                } else if (last > dataSource[j] && !increasing) {
                    currList.add(dataSource[j]);
                }
            }

            if (currList.size() > 2) {
                bitonicArrayList.add(currList);
            }
        }
        return bitonicArrayList;
    }

    public static void main(String[] args) {
        int[] randomData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        BasicUtils.printLineInfo("[ FIRST TEST CASE ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randomData));

        // find all bitonic sub-arrays
        List<ArrayList<Integer>> bitonicSubArrays = findBitonicSubarrays(randomData);

        BasicUtils.printLineInfo("[ FOUND BITONIC ARRAYS ]", '=', MAX_LINE_LENGTH);
        for (int i = 0, size = bitonicSubArrays.size(); i < size; i++) {
            System.out.printf("Bitonic array #%02d: %s%n", i+1,
                    Arrays.toString(bitonicSubArrays.get(i).toArray(new Integer[0])));
        }

        BasicUtils.printLineInfo("[ SECOND TEST CASE ]", '=', MAX_LINE_LENGTH);
        int[] testData = { 4, 5, 9, 5, 6, 10, 11, 9, 6, 4, 5};

        System.out.printf("Test Data Array: %s%n", Arrays.toString(testData));

        bitonicSubArrays = findBitonicSubarrays(testData);

        BasicUtils.printLineInfo("[ FOUND BITONIC ARRAYS ]", '=', MAX_LINE_LENGTH);
        for (int i = 0, size = bitonicSubArrays.size(); i < size; i++) {
            System.out.printf("Bitonic array #%02d: %s%n", i+1,
                    Arrays.toString(bitonicSubArrays.get(i).toArray(new Integer[0])));
        }

        BasicUtils.printLineInfo("[ LONGEST BITONIC ARRAY (2nd test) ]", '=', MAX_LINE_LENGTH);
        ArrayList<Integer> longestBitonic = new ArrayList<>();

        for (ArrayList<Integer> subArrayList : bitonicSubArrays) {
            if (subArrayList.size() > longestBitonic.size()) {
                longestBitonic = subArrayList;
            }
        }

        System.out.printf("Longest Bitonic SubArray: %s | (size: %d)%n",
                Arrays.toString(longestBitonic.toArray(new Integer[0])), longestBitonic.size());
    }
}
