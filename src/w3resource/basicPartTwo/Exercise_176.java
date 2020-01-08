package w3resource.basicPartTwo;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Partitions a given array of integers into even number first and odd #
// #                     numbers second.                                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : January 08, 2019                                                    #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_176 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid specified size. Must be > 0");
        }
        int[] newIntData = new int[size];
        newIntData = IntStream.of(newIntData).map(val -> low + random.nextInt(high)).toArray();
        return newIntData;
    }

    // Rearrange the elements in array so that even numbers appear
    // first, then odd numbers.

    private static void doRearrangements(int[] mainData) {
        for (int i = 1; i < mainData.length; i++) {
            if (mainData[i] % 2 == 0) {
                for (int j = 0; j < i; j++) {
                    if (mainData[j] % 2 == 1) {
                        int temp = mainData[j];
                        mainData[j] = mainData[i];
                        mainData[i] = temp;
                        break;
                    }
                }
            }
        }
    }

    private static void printLine(char someChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.printf("%c", someChar);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] newArrayData = randomIntArray(0, 20, 15);
        System.out.printf("Generated data: %s\n", Arrays.toString(newArrayData));

        // do the arrangements
        doRearrangements(newArrayData);
        System.out.printf("After processing: %s\n", Arrays.toString(newArrayData));

        printLine('-', 70);

        // Another test case
        int[] newTestData = {7, 2, 4, 1, 3, 5, 6, 8, 2, 10};
        System.out.printf("New test case: %s\n", Arrays.toString(newTestData));

        doRearrangements(newTestData);
        System.out.printf("After processing: %s\n", Arrays.toString(newTestData));
    }
}
