package books.JavaHowToProgram10Ed.Chapter_20.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 20.4 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : February 02, 2020                                          #
// #                                                                                  #
// ####################################################################################

import java.util.Arrays;
import java.security.SecureRandom;

public class Exercise_20_4 {

    private static SecureRandom generator = new SecureRandom();

    private static Integer[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size '%d'." +
                    " For new array", size));
        }
        Integer[] newData = new Integer[size];
        for (int i = 0; i < newData.length; i++) {
            newData[i] = low + generator.nextInt(high);
        }
        return newData;
    }

    private static Float[] randomFloatArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size '%d'." +
                    " For new array", size));
        }
        Float[] newData = new Float[size];
        for (int i = 0; i < newData.length; i++) {
            newData[i] = (float) low + generator.nextInt(high);
        }
        return newData;
    }

    private static <T extends Comparable<T>> void selectionSort(T[] someData) {
        for (int i = 0; i < someData.length; i++) {
            for (int j = i+1; j < someData.length; j++) {
                if (someData[i].compareTo(someData[j]) > 0) {
                    T temp = someData[i];
                    someData[i] = someData[j];
                    someData[j] = temp;
                }
            }
        }
    }

    private static void printLine(char someChar, int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(String.format("Invalid size '%d'. Must be > 0"
                    , maxSize));
        }
        Arrays.stream(new int[maxSize]).forEach(
                val -> System.out.printf("%c", someChar)
        );
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] newIntegerArray = randomIntegerArray(0, 50, 15);

        System.out.printf("Generated Array: %s\n", Arrays.toString(newIntegerArray));
        selectionSort(newIntegerArray);
        System.out.printf("   Sorted Array: %s\n", Arrays.toString(newIntegerArray));

        printLine('-', 75);

        Float[] newFloatArray = randomFloatArray(0, 50, 15);
        System.out.printf("Generated Array: %s\n", Arrays.toString(newFloatArray));
        selectionSort(newFloatArray);
        System.out.printf("  Sorted Array: %s\n", Arrays.toString(newFloatArray));
    }

}
