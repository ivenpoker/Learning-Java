package books.JavaHowToProgram10Ed.Chapter_19.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 19.5 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : February 02, 2020                                          #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_19_5 {

    private static SecureRandom generator = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size '%d'. Must be > 0", size));
        }
        return Arrays.stream(new int[size]).map((val) ->
                low + generator.nextInt(high)).toArray();
    }

    private static void printArray(String message, final int [] sourceData) {
        System.out.print(message);
        Arrays.stream(sourceData).forEach(val -> System.out.printf(" %02d", val));
        System.out.println();
    }


    private static void bubbleSort(int [] sourceData) {
        for (int i = 0; i < sourceData.length; i++) {
            for (int j = 0; j < sourceData.length-1-i; j++) {
                if (sourceData[j] > sourceData[j+1]) {
                    int temp = sourceData[j];
                    sourceData[j] = sourceData[j+1];
                    sourceData[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] main_array = randomIntegerArray(0, 100, 20);
        printArray("Generated Array:", main_array);

        // sort the data
        bubbleSort(main_array);

        printArray("  After sorting:", main_array);

    }
}
