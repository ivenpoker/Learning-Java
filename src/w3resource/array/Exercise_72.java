package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds and print one continuous subarray (from a given array of      #
// #                     integers) that if you only sort the said subarray in ascending      #
// #                     order then the entire array will be sorted in ascending order.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 11, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise_72 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LEN = 75;

    private static boolean isArraySorted(int[] dataSource) {
        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j < dataSource.length; j++) {
                if (dataSource[i] > dataSource[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static  List<ArrayList<Integer>> findValidSubArrays(int[] dataSource) {
        List<ArrayList<Integer>> mainList = new ArrayList<>();

        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j < dataSource.length; j++) {
                int[] data = Arrays.copyOfRange(dataSource, i, j+1);
                Arrays.sort(data);
                int[] testArray = IntStream.of(dataSource).toArray();
                for (int k = i, v = 0; k <= j; k++) {
                    testArray[k] = data[v++];
                }
                // System.out.printf("Testing array: %s | -- %d%n", Arrays.toString(testArray), i);
                if (isArraySorted(testArray)) {
                    ArrayList<Integer> keySubArray = new ArrayList<>();
                    for (int val : Arrays.stream(Arrays.copyOfRange(dataSource, i, j+1)).toArray()) {
                        keySubArray.add(val);
                    }
                    mainList.add(keySubArray);
                }
            }
        }
        return mainList;
    }

    public static void main(String[] args) {

        int[] testData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        BasicUtils.printLineInfo("[ TEST DATA ]", '=', MAX_LINE_LEN);
        System.out.printf("Generated Data: %s%n", Arrays.toString(testData));

        List<ArrayList<Integer>> foundSubArrays = findValidSubArrays(testData);

        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_LINE_LEN);
        System.out.printf("Found %d matching array(s) ...%n", foundSubArrays.size());
        System.out.println();

        for (int i = 0, size = foundSubArrays.size(); i < size; i++) {
            System.out.printf("Array #%02d: %s -- | size: %d%n", i+1,
                    foundSubArrays.get(i), foundSubArrays.get(i).size());
        }

        BasicUtils.printLineInfo("[ ANOTHER TEST ]", '=', MAX_LINE_LEN);
        int[] anotherTestData = { 1, 3, 2, 7, 5, 6, 4, 8};

        System.out.printf("Test Data: %s%n", Arrays.toString(anotherTestData));

        foundSubArrays = findValidSubArrays(anotherTestData);

        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_LINE_LEN);
        System.out.printf("Found %d matching array(s) ...%n", foundSubArrays.size());
        System.out.println();

        for (int i = 0, size = foundSubArrays.size(); i < size; i++) {
            System.out.printf("Array #%02d: %s -- | size: %d%n", i+1,
                    foundSubArrays.get(i), foundSubArrays.get(i).size());
        }

    }

}
