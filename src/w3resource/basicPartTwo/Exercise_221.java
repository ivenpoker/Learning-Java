package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Accepts six numbers as input and sorts them in descending order.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 10, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Arrays;
import java.util.Scanner;
import java.security.SecureRandom;

public class Exercise_221 {

    private static final SecureRandom random = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_USER_INTS = 6;

    private static void sortDescending(int[] mainData) {
        for (int i = mainData.length-1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                if  (mainData[i] > mainData[j]) {
                    int temp = mainData[i];
                    mainData[i] = mainData[j];
                    mainData[j] = temp;
                }
            }
        }
    }

    private static int[] randomIntegerArray(int lowerBound, int upperBound, int size) {
         if (size <= 0) {
             throw new IllegalArgumentException(
                     String.format("Invalid specified size (%d). Must be > 0", size));
         }
         return Arrays.stream(new int[size]).map((i) -> lowerBound + random.nextInt(upperBound)).toArray();
    }

    private static int[] readUserInput(String inputMess, int maxInputInts) {
        if (maxInputInts <= 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified ints to read (%d). Must be > 0", maxInputInts));
        }
        int[] userInts = new int[maxInputInts];
        int read = 0;
        System.out.print(inputMess);

        while (read < userInts.length) {
            userInts[read++] = scanner.nextInt();
        }
        return userInts;
    }

    public static void main(String[] args) {
        int[] readInts = readUserInput(String.format("Enter %d integers: ", MAX_USER_INTS), MAX_USER_INTS);
        System.out.printf("Read ints: %s%n", Arrays.toString(readInts));

        // Sorts all integers in array in descending order using a descending
        // selection sort algorithm
        sortDescending(readInts);

//        // Testing our sorting algorithm.
//        int[] randomIntArray = randomIntegerArray(1, 100, 15);
//        System.out.printf("Random array: %s%n", Arrays.toString(randomIntArray));
//
//        sortDescending(randomIntArray);
//        System.out.printf("Sorted array: %s%n", Arrays.toString(randomIntArray));

        System.out.printf("Sorted ints: %s%n", Arrays.toString(readInts));
    }
}
