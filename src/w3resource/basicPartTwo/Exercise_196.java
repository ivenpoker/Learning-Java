package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Creates a spiral array of N * N sizes from a given integer N.         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 4, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_196 {

    private static Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String mess) {
        boolean isValid = false;
        int userInt = 0;

        while (!isValid) {
            try {
                System.out.print(mess);
                userInt = input.nextInt();
                isValid = true;
            } catch (InputMismatchException iMe) {
                System.out.printf("[INPUT_ERROR]: %s%n", iMe.getMessage());
            }
        }
        return userInt;
    }

    public static int[][] spiralArray(int n) {
        int[][] temp = new int[n][n];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x, y, d;
        int i, j, nx, ny;
        for (i = 0; i < n; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                temp[i][j] = -1;
            }
        }
        x = 0;
        y = 0;
        d = 0;
        for (i = 1; i <= n * n; ++i)
        {
            temp[x][y] = i;
            nx = x + dx[d];
            ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || temp[nx][ny] != -1) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx;
            y = ny;
        }
        return temp;
    }

    private static void displaySpiralArray(String mess, int[][] spiralArray) {
        System.out.print(mess);
        for (int[] arrayRow : spiralArray) {
            for (int i = 0; i < arrayRow.length; i++) {
                if (i == arrayRow.length-1) {
                    System.out.printf("%3d%n", arrayRow[i]);
                } else {
                    System.out.printf("%3d ", arrayRow[i]);
                }
            }
        }
    }

    public static void main(String[] args) {

        // Obtain user value for 'N'
        int userN = obtainUserInput("Enter array size (integer): ");

        // Compute spiral array of specified size
        int[][] results = spiralArray(userN);

        // Display the spiral array results
        displaySpiralArray("Generated spiral array:\n\n", results);


    }

}
