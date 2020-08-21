package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays the Pascal's triangle.                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_22 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserNumberOfRows(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextInt();

                if (userInput <= 0) {
                    throw new IllegalArgumentException(
                            String.format("Invalid input (%d). Must be > 0", userInput));
                }
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[input_valid]: %s%n", iMe.getMessage());
                scanner.nextLine();                     // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static void displayPascalsTriangle(int numOfRow) {
        int c =1, blk, i, j;

        for(i = 0; i < numOfRow; i++) {
            for(blk = 1; blk <= numOfRow-i; blk++) {
                System.out.print(" ");
            }
            for(j = 0; j <= i; j++) {
                if (j == 0|| i==0) {
                    c=1;
                } else {
                    c = c * (i - j + 1) / j;
                }
                System.out.print(" " + c);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {

        int userInput = obtainUserNumberOfRows("Enter number of rows: ");
        displayPascalsTriangle(userInput);

    }

}
