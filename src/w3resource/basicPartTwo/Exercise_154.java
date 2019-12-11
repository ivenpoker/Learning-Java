package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Prints the contents of a 2D boolean array where              #
// #                     't' will represent true and 'f' will represent false.        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Exercise_154 {

    private static SecureRandom random = new SecureRandom();
    private static final int TRUE = 1;
    private static final int FALSE = 0;

    private static int[] randomArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid size of array");
        }
        int[] newData = new int[size];
        newData = IntStream.of(newData).map((val) -> {
            val = random.nextInt(2);
            return val;
        }).toArray();
        return newData;
    }

    private static int[][] create2DBoolean(int row, int col) {
        if (row < 0) {
            throw new IllegalArgumentException("Invalid number of rows");
        }
        if (col < 0) {
            throw new IllegalArgumentException("Invalid number of cols");
        }
        int[][] mainData = new int[row][col];
        for (int i = 0; i < mainData.length; i++) {
            mainData[i] = randomArray(mainData[i].length);
        }
        return mainData;
    }

    private static void print2DBooleanData(final String message, int[][] booleanData) {
        System.out.print(message);
        for (int i = 0; i < booleanData.length; i++) {
            for (int j = 0; j < booleanData[i].length; j++) {
                if (booleanData[i][j] == TRUE) {
                    System.out.printf("%c ", 't');
                } else if (booleanData[i][j] == FALSE) {
                    System.out.printf("%c ", 'f');
                } else {
                    throw new IllegalStateException("Invalid boolean 2D State data.");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] new2DBooleanArray = create2DBoolean(8, 8);
        print2DBooleanData("Generated 2D Boolean Data:\n\n", new2DBooleanArray);
    }
}
