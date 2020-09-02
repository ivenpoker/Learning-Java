package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Adds two matrices of the same size.                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_19 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 5;
    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[][] createMatrixOfValues(int lower, int upper, int numRows, int numCols) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be < Upper bound (%d)",
                            lower, upper));
        }
        int[][] matrix = new int[numRows][numCols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = IntStream.of(new int[numCols]).map((val) -> lower + secureRandom.nextInt(upper)).toArray();
        }
        return matrix;
    }

    private static int[][] matrixSum(int[][] matrixA ,int[][] matrixB) {
        if ((matrixA.length != matrixB.length) || (matrixA[0].length != matrixB[0].length)) {
            throw new IllegalArgumentException("Invalid matrices size. Both must be of the same size");
        }
        int[][] matricesSum = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matricesSum[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matricesSum;
    }

    private static void displayMatrix(String message, int[][] someMatrix) {
        System.out.print(message);
        for (int[] row : someMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        int[][] randomMatrix_A = createMatrixOfValues(LOWER_BOUND, UPPER_BOUND, NUM_ROWS, NUM_COLS);
        displayMatrix("Generated matrix A:\n", randomMatrix_A);

        int[][] randomMatrix_B = createMatrixOfValues(LOWER_BOUND, UPPER_BOUND, NUM_ROWS, NUM_COLS);
        displayMatrix("\nGenerated matrix B:\n", randomMatrix_B);

        int[][] matricesSum = matrixSum(randomMatrix_A, randomMatrix_B);
        displayMatrix("\nMatrices Sum:\n", matricesSum);


    }
}
