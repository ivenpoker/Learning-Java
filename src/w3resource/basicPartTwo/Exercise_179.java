package w3resource.basicPartTwo;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Sums up two array of integers (single digits).                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : January 08, 2020                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Exercise_179 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid specified size. Must be > 0");
        }
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map((val) -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static int[] sumArrays(int[] dataA, int[] dataB) {
        int[] dataC = new int[Math.max(dataA.length, dataB.length)];

        if (dataA.length > dataB.length) {
            // 'dataA' lengths is > 'dataB' length, we make sure 'dataB' is same length as 'dataA'
            int[] newDataB = new int[dataA.length];
            System.arraycopy(dataB, 0, newDataB, dataA.length-dataB.length, dataB.length);
            dataB = newDataB;

        } else if (dataB.length > dataA.length) {
            // 'dataB' lengths is > 'dataA' length, we make sure 'dataA' is same length as 'dataB'
            int[] newDataA = new int[dataB.length];
            System.arraycopy(dataA, 0, newDataA, dataB.length-dataA.length, dataA.length);
            dataC = newDataA;
        }

        // Performing sum on both arrays (now of same size, so algorithm works fine.)
        int carry = 0;
        for (int i = dataA.length-1; i >= 0; i--) {
            int tempSum = dataA[i] + dataB[i] + carry;
            if (tempSum >= 10) {
                carry = tempSum / 10;
                tempSum %= 10;
            }
            dataC[i] = tempSum;
        }
        if (carry > 0) {
            int[] finalResults = new int[dataC.length + 1];
            finalResults[0] = carry;
            System.arraycopy(dataC, 0, finalResults, 1, finalResults.length-1);
            return finalResults;
        }
        return dataC;
    }

    private static void printLine(char someChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.printf("%c", someChar);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] dataA = randomIntegerArray(0, 20, 5);
        int[] dataB = randomIntegerArray(0, 20, 5);

        System.out.printf("Generated array data A: %s\n", Arrays.toString(dataA));
        System.out.printf("Generated array data B: %s\n", Arrays.toString(dataB));
        System.out.printf("    After summing data: %s\n", Arrays.toString(sumArrays(dataA, dataB)));

        printLine('-', 60);
        dataA = new int[] {9, 9, 9, 9};
        dataB = new int[] {1};

        System.out.printf("   New test data A: %s\n", Arrays.toString(dataA));
        System.out.printf("   New test data B: %s\n", Arrays.toString(dataB));
        System.out.printf("After summing data: %s\n", Arrays.toString(sumArrays(dataA, dataB)));
    }
}
