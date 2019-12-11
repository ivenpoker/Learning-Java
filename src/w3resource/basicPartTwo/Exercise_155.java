package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Prints an array after changing the rows and columns of a     #
// #                     given 2D array.                                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Exercise_155 {

    private static SecureRandom random = new SecureRandom();

    private static int[][] random2DArray(int row, int col, int low, int high) {
        if (row < 0) {
            throw new IllegalArgumentException("Invalid specified number of rows.");
        }
        if (col < 0) {
            throw new IllegalArgumentException("Invalid specified number of columns.");
        }
        int[][] new2DData = new int[row][col];
        for (int i = 0; i < new2DData.length; i++) {
            new2DData[i] = IntStream.of(new2DData[i]).map((val) -> val = low + random.nextInt(high)).toArray();
        }

        return new2DData;
    }

    private static void transpose(int[][] mainData) {

        int[][] new2DData = new int[mainData[0].length][mainData.length];
        for (int i = 0; i < new2DData.length; i++) {
            for (int j = 0; j < new2DData[0].length; j++) {
                new2DData[j][i] = mainData[i][j];
            }
        }
        printArray(new2DData);
    }

    private static void printArray(int[][] main2DArray) {
        for (int i = 0; i < main2DArray.length; i++) {
            for (int j = 0; j < main2DArray[0].length; j++) {
                System.out.print(main2DArray[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] mainData = random2DArray(10, 10, 0, 10);

        System.out.print("Original Array: \n");
        printArray(mainData);

        System.out.println();

        System.out.print("After changing the rows and columns of the said array:\n\n");
        transpose(mainData);


    }
}
