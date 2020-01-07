package w3resource.basicPartTwo;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Gets the number of elements in a given array of integers that    #
// #                     are smaller than the integer of another given array of integers. #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : January 07, 2019                                                 #
// #                                                                                      #
// ########################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;
import java.security.SecureRandom;

public class Exercise_172 {

    private static SecureRandom random = new SecureRandom();

    // Generates a random integer array.
    private static int[] randomIntArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid specified size. Must be >= 0");
        }
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData)
                .map(val -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    // Print array data with allocated message to console
    private static void printArrayData(String message, int[] someArr) {
        System.out.printf("%s: %s\n", message, Arrays.toString(someArr));
    }

    private static int[] doComparison(int[] dataA, int[] dataB) {
        return IntStream.of(dataB)
                .map((val) -> {

                    // For each value in dataB, we search for all those values in
                    // dataA that are < this value. We the return the length of the
                    // accumulated data (length of array)

                    return IntStream.of(dataA).filter(temp -> temp < val).toArray().length;

                }).toArray(); // convert final result to array.
    }

    // Prints a line made up of specified amount of characters to console.
    private static void printLine(char someChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.printf("%c", someChar);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arrayA = randomIntArray(0, 20, 10); // array of size 10 with random data in [0, 20)
        int[] arrayB = randomIntArray(0, 10, 4);  // array of size 4 with random data in [0, 20)

        printArrayData("Generated array A: ", arrayA);
        printArrayData("Generated array B: ", arrayB);

        printLine('-', 60);
        int[] newData = doComparison(arrayA, arrayB);
        printArrayData("Resultant array data: ", newData);

        printLine('-', 60);
        arrayA = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        arrayB = new int[] {1, 4, 8};

        printArrayData("New array A: ", arrayA);
        printArrayData("New array B: ", arrayB);
        newData = doComparison(arrayA, arrayB);

        printLine('-', 60);
        printArrayData("Resultant array data: ", newData);
        printLine('-', 60);

    }

}
