package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Searches for a key value in matrix of integers.                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 29, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_120 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high)).toArray();
        return newData;
    }

    private static int findFirstOccurrence(int[] dataSource, int val) {
        if (dataSource.length == 0)
            return -1;
        for (int i = 0; i < dataSource.length; i++)
            if (dataSource[i] == val)
                return i;
        return -1;
    }
    private static int searchMatrix(int[][] matrixData, int keyVal) {
        for (int[] matrixDatum : matrixData) {
            int tempVal = findFirstOccurrence(matrixDatum, keyVal);
            if (tempVal != -1)
                return tempVal;
        }
        return -1;
    }

    private static int[][] createMatrix(int row, int col, int low, int high) {
        if (row <= 0) throw new IllegalArgumentException("Invalid number of rows for array.");
        if (col <= 0) throw new IllegalArgumentException("Invalid size of array.");
        int[][] newMatrix = new int[row][col];
        for (int i = 0; i < newMatrix.length; i++)
            newMatrix[i] = randomIntegerArray(low, high, col);
        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] ints : matrix)
            System.out.printf("\t%s\n", Arrays.toString(ints));
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.print("Generating matrix data....");
        int[][] matrixData = createMatrix(10, 10, 0, 10);
        System.out.println("[DONE]");
        System.out.println("Matrix data ...");
        printMatrix(matrixData);

        int randKey = random.nextInt(10);

        System.out.printf("Searching for '%d' in matrix ... ", randKey);
        int result = searchMatrix(matrixData, randKey);

        if (result != -1) {
            System.out.println("[FOUND]");
        } else {
            System.out.println("[NOT FOUND]");
        }


    }
}
