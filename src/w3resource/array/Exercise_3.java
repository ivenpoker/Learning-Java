package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Creates and displays a grid with specified character.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;

public class Exercise_3 {

    private static final int NUM_OF_ROWS = 10;
    private static final int NUM_OF_COLS = 10;
    private static final char FILL_IN_CHAR = '-';

    /**
     * Creates a 2D array data that represents a grid.
     * @param numOfRows Number of rows to consider during grid creation.
     * @param numOfCols Number of cols to consider during grid creation.
     * @param ch Character to fill into the grid data.
     * @return 2D array data that represents a grid.
     */
    private static char[][] createGridAndFill(int numOfRows, int numOfCols, char ch) {
        char[][] mainData = new char[numOfRows][numOfCols];
        for (char[] currCrow : mainData) {
            Arrays.fill(currCrow, ch);
        }
        return mainData;
    }

    /**
     * Prints grids to the standard input stream (STDIN), which is also the console.
     * @param grid Grid to display to STDIN.
     */
    private static void printGrid(char[][] grid) {
        for (char[] gridRow : grid) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < gridRow.length; i++) {
                if (i == grid.length-1) {
                    sb.append(gridRow[i]);
                } else {
                    sb.append(gridRow[i]).append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {

        char[][] mainGrid = createGridAndFill(NUM_OF_ROWS, NUM_OF_COLS, FILL_IN_CHAR);
        printGrid(mainGrid);

    }

}
