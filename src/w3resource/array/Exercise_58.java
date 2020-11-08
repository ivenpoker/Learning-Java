package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Given two sorted arrays A and B of size "p" and "q", program merges #
// #                     elements of A with B by maintaining the sorted order i.e fill A     #
// #                     with first "p" elements and fill B will the remaining elements.     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 8, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise_58 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 50;
    private static final int ARRAY_SIZE_1 = 10;
    private static final int ARRAY_SIZE_2 = 15;
    private static final int PRINT_LINE_LEN = 70;

    private static void processArrays(int[] array1, int [] array2) {
        List<Integer> mainList = new ArrayList<>();

        Arrays.stream(array1).forEach(mainList::add);
        Arrays.stream(array2).forEach(mainList::add);

        Collections.sort(mainList);

        int k = 0;
        for (int i = 0; i < array1.length; i++) {
            array1[k++] = mainList.get(i);
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = mainList.get(k++);
        }
    }

    public static void main(String[] args) {
        int[] randomData1 = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE_1);
        int[] randomData2 = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE_2);

        Arrays.sort(randomData1);
        Arrays.sort(randomData2);

        System.out.printf("Generated array #1: %s%n", Arrays.toString(randomData1));
        System.out.printf("Generated array #2: %s%n", Arrays.toString(randomData2));

        processArrays(randomData1, randomData2);

        System.out.println();
        BasicUtils.printLineMessage("[ FIRST TEST ]", '=', PRINT_LINE_LEN);
        System.out.println();

        System.out.printf("Generated array #1: %s%n", Arrays.toString(randomData1));
        System.out.printf("Generated array #2: %s%n", Arrays.toString(randomData2));


        System.out.println();
        BasicUtils.printLineMessage("[ SECOND TEST ]", '=', PRINT_LINE_LEN);
        System.out.println();

        int[] arrA = {1, 5, 6, 7, 8, 10};
        int[] arrB = {2, 4, 9};

        System.out.printf("Test array #1: %s%n", Arrays.toString(arrA));
        System.out.printf("Test array #2: %s%n", Arrays.toString(arrB));

        processArrays(arrA, arrB);

        System.out.println();
        BasicUtils.printLineMessage("[TEST RESULTS]", '-', PRINT_LINE_LEN);
        System.out.println();

        System.out.printf("Test array #1: %s%n", Arrays.toString(arrA));
        System.out.printf("Test array #2: %s%n", Arrays.toString(arrB));
    }
}
