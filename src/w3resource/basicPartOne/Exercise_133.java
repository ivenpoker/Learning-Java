package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Find a path from top left to bottom right direction which minimizes the sum of  #
// #                     all numbers along its path.                                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 31, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Exercise_133 {

    private static SecureRandom random = new SecureRandom();

    private static int findMinPathSum(int[][] grid) {
        if (Objects.isNull(grid) || grid.length == 0 || Objects.isNull(grid[0])
                    || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[i][j] = grid[i][j];
                    continue;
                }
                // Compute temp
                int fromUp = (i == 0 ? Integer.MAX_VALUE : temp[i-1][j]);
                int fromLeft = (j == 0 ? Integer.MAX_VALUE: temp[i][j-1]);
                temp[i][j] = Math.min(fromUp, fromLeft);
            }
        }
        return temp[m-1][n-1];
    }

    private static int[][] range2DArray(int row, int col, int low, int high) {
        if (row < 0 || col < 0)
            throw new IllegalArgumentException("Invalid dimensions for array");
        int[][] new2Ddata = new int[row][col];

        for (int i = 0; i < new2Ddata.length; i++)
            new2Ddata[i] = IntStream.of(new2Ddata[i]).map(val -> low + random.nextInt(high)).toArray();

        return new2Ddata;
    }

    public static void main(String[] args) {
        int[][] main2DData = range2DArray(5, 5, 0, 9);
        System.out.printf("Generated 2D Data:\n\n");

        for (int[] tempRow : main2DData)
            System.out.printf("\t%s\n", Arrays.toString(tempRow));
        System.out.println();

        System.out.printf("Sum of all numbers along its path: %d\n", findMinPathSum(main2DData));
    }
}
