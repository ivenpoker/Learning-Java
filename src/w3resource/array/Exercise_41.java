package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the smallest and second smallest elements of a given array.   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.IntStream;
import w3resource.utils.ArrayUtils;

public class Exercise_41 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 30;
    private static final int ARRAY_SIZE = 15;

    private static List<Integer> findSmallestAndSecondSmallestA(int[] dataSource) {
        if (dataSource.length < 2) {
            throw new IllegalArgumentException("Invalid array length. Length must be > 2");
        }
        int[] sortedData = IntStream.of(dataSource).sorted().toArray();
        List<Integer> data = new ArrayList<>();
        data.add(sortedData[0]);        // smallest
        data.add(sortedData[1]);        // second smallest

        return data;
    }

    private static List<Integer> findSmallestAndSecondSmallestB(int[] dataSource) {
        if (dataSource.length < 2) {
            throw new IllegalArgumentException("Invalid array length. Length must be > 2");
        }
        List<Integer> smallList = new ArrayList<>();
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < dataSource.length; i++) {
            if (dataSource[i] < smallest) {
                secondSmallest = smallest;
                smallest = dataSource[i];
            } else {
                if (dataSource[i] < secondSmallest) {
                    secondSmallest = dataSource[i];
                }
            }
        }
        smallList.add(smallest);
        smallList.add(secondSmallest);

        return smallList;
    }

    public static void main(String[] args) {

        int[] dataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Array data: %s%n", Arrays.toString(dataSource));
        System.out.printf("[Method A] Smallest and Second smallest: %s%n", findSmallestAndSecondSmallestA(dataSource));
        System.out.printf("[Method B] Smallest and Second smallest: %s%n", findSmallestAndSecondSmallestB(dataSource));
    }
}
