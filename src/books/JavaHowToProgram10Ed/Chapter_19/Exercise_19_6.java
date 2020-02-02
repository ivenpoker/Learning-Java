package books.JavaHowToProgram10Ed.Chapter_19;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 19.6 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : February 02, 2020                                          #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_19_6 {

    private static SecureRandom generator = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size '%d' " +
                    "for new integer array.", size));
        }
        return Arrays.stream(new int[size]).map((val) ->
                low + generator.nextInt(high)).toArray();
    }

    private static void printArray(String message, int[] dataSource) {
        System.out.print(message);
        Arrays.stream(dataSource).forEach(val -> System.out.printf(" %d", val));
        System.out.println();
    }

    private static void improvedBubbleSort(int[] sourceData) {
        boolean sorted = true;
        for (int i = 0; i < sourceData.length-1; i++) {
            for (int j = 0; j < sourceData.length-1-i; j++) {
                if (sourceData[j] > sourceData[j+1]) {
                    int temp = sourceData[j];
                    sourceData[j] = sourceData[j+1];
                    sourceData[j+1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] dataSource = randomIntegerArray(0, 20, 15);
        printArray("Generated Data:", dataSource);

        // sort the data
        improvedBubbleSort(dataSource);

        printArray("  Sorted Data:", dataSource);
    }
}
