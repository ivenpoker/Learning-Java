package books.JavaHowToProgram10Ed.Chapter_19;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 19.10 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : February 02, 2020                                          #
// #                                                                                  #
// ####################################################################################

import java.util.Arrays;
import java.security.SecureRandom;

public class Exercise_19_10 {

    private static SecureRandom generator = new SecureRandom();

    private static void quickSort(int[] arr, int start, int end) {
        int partition = partition(arr, start, end);
        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size '%d' for new array", size));
        }
        return Arrays.stream(new int[size]).map(val ->
                low + generator.nextInt(high)).toArray();
    }

    public static void main(String[] args) {

        int[] newArray = randomIntegerArray(0, 100, 15);
        System.out.printf("New Array: %s\n", Arrays.toString(newArray));
        quickSort(newArray, 0, newArray.length-1);
        System.out.printf("After sorting: %s\n", Arrays.toString(newArray));
    }
}
