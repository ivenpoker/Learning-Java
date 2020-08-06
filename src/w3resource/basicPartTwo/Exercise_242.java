package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Adds up columns and rows of given table.                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : August 06, 2020                                                       #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_242 {

    private static final Scanner input = new Scanner(System.in);

    private static int readUserInput(String inputMess) {
        boolean valid = false;
        int userInt = 0;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (userInt < 0) {
                    throw new IllegalArgumentException("please enter positive integer");
                }
                valid = true;
            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s", exc.getMessage());
            }
        }
        return userInt;
    }

    private static int[][] readRowsAndColumns(String inputMess, int rowsAndColumnsCnt) {
        int[][] rowsAndColsData = new int[rowsAndColumnsCnt][rowsAndColumnsCnt];

        System.out.print(inputMess);
        for (int i = 0; i < rowsAndColumnsCnt; i++) {
            for (int j = 0; j < rowsAndColumnsCnt; j++) {
                rowsAndColsData[i][j] = input.nextInt();
            }
        }
        return rowsAndColsData;
    }

    private static void displayMatrixData(String mess, int[][] data) {
        System.out.print(mess);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                System.out.printf("  %3d", data[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] createSpreadSheet(int[][] mainData) {
        int[][] spreadSheet = new int[mainData.length + 1][mainData.length+1];

        // Copy all data int new spread sheet data
        for (int i = 0; i < mainData.length; i++) {
            System.arraycopy(mainData[i], 0, spreadSheet[i], 0, mainData.length);
        }

        // Compute sum of columns
        for (int i = 0; i < spreadSheet.length-1; i++) {
            int colSum = 0;
            for (int j = 0; j < spreadSheet.length; j++) {
                colSum += spreadSheet[j][i];
            }
            // Update last row for col to reflect sum
            spreadSheet[spreadSheet.length-1][i] = colSum;
        }

        // Compute sum of rows
        for (int i = 0; i < spreadSheet.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < spreadSheet.length; j++) {
                rowSum += spreadSheet[i][j];
            }
            // Update last column for row
            spreadSheet[i][spreadSheet.length-1] = rowSum;
        }

        return spreadSheet;
    }

    public static void main(String[] args) {

        int mainUserInt = readUserInput("Enter number of rows/column: ");
        int[][] rowColData = readRowsAndColumns("Enter rows and columns data:\n", mainUserInt);

        displayMatrixData("\nData obtained:\n", rowColData);

        int[][] spreadSheet = createSpreadSheet(rowColData);
        displayMatrixData("\nResult:\n", spreadSheet);

    }
}




















































