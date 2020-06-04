package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds all position of a given number in a given matrix. If the number #
// #                     is not found, prints "Number not found!".                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 4, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_194 {

    private static final int MAX_MATRIX_SIZE = 25;
    private static final SecureRandom randomNumber = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);

    private static int[][] generateMatrix(int randLower, int randUpper) {

        int[][] matrix = new int[MAX_MATRIX_SIZE][MAX_MATRIX_SIZE];
        int cnt = 0;
        for (int[] matrixRow : matrix) {
            for (int i = 0; i < matrixRow.length; i++) {
                matrixRow[i] = randLower + randomNumber.nextInt(randUpper);
                cnt += 1;
                System.out.printf("\rGenerating matrix ... [%.2f%%]", ((double) cnt / (Math.pow(MAX_MATRIX_SIZE, 2))) * 100);
            }
        }
        System.out.printf("%8s%n", "[DONE]");
        return matrix;
    }

    private static void displayMatrix(String mess, int[][] matrix) {
        System.out.print(mess);
        for (int[] matrixRow : matrix) {
            for (int i = 0; i < matrixRow.length; i++) {
                if (i == matrixRow.length-1) {
                    System.out.printf("%2d", matrixRow[i]);
                } else {
                    System.out.printf("%2d ", matrixRow[i]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int obtainUserSearchKey(String mess) {
        boolean isValid = false;
        int userKey = 0;
        while (!isValid) {
            try {
                System.out.print(mess);
                userKey = input.nextInt();
                isValid = true;

            } catch (InputMismatchException exc) {
                System.out.printf("[ERROR]: %s%n", "Invalid integer");
                input.nextLine();
            }
        }
        return userKey;
    }

    private static ArrayList<Cord> getSearchKeyLocations(int[][] matrix, int searchKey) {
        ArrayList<Cord> keyLocations = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == searchKey) {
                    keyLocations.add(new Cord(i, j));
                }
                cnt += 1;
                System.out.printf("\rSearching '%d' ... [%.1f%%]", searchKey,
                        ((double) cnt / Math.pow(matrix.length, 2)) * 100);
            }
        }
        System.out.printf("%8s%n", "[DONE]");
        return keyLocations;
    }

    private static void printKeyLocations(String mess, ArrayList<Cord> keyLocations) {
        System.out.print(mess);
        for (int i = 1, size = keyLocations.size(); i <= size; i++) {
            if (i % 4 == 0) {
                System.out.printf("%10s%n", keyLocations.get(i-1));
            } else {
                System.out.printf("%10s", keyLocations.get(i-1));
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        // Generate matrix
        int[][] matrix = generateMatrix(0, 10);

        // Display generated matrix
        displayMatrix("Matrix view:\n\n", matrix);

        // Get user search key
        int userSearchKey = obtainUserSearchKey("Enter search integer: ");

        // Obtain all the locations of search key in matrix
        ArrayList<Cord> keyLocations = getSearchKeyLocations(matrix, userSearchKey);

        // Display the results
        if (keyLocations.size() == 0) {
            System.out.printf("\n[NOT_FOUND]: Number '%d' not found.\n\n", userSearchKey);
        } else {
            printKeyLocations(String.format("\nResults for '%d' ... \n\n", userSearchKey), keyLocations);
        }

    }
}

class Cord {
    public int xCord;
    public int yCord;

    public Cord(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    @Override
    public String toString() {
        return String.format("(%2d, %2d)", this.xCord, this.yCord);
    }
}
