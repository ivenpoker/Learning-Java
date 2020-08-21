package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays a diamond triangle of data.                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_21 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserInput(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextInt();

                if (userInput < 0) {
                    throw new InputMismatchException(
                            String.format("Invalid input (%d). Must be > 0", userInput));
                }
                inputValid = true;


            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();                 // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static void printDiamondLikeStructure(int numOfRows) {
        if (numOfRows % 2 == 0) {
            numOfRows += 1;
        }
        int size = (numOfRows * 2) - 1;
        for (int i = 0, st = 1, sp = numOfRows - st; i < numOfRows; i++, st += 2, sp--) {
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < st; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = numOfRows-1, st = size-2, sp = 1; i >= 0; i--, st -= 2, sp++) {
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < st; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int mainUserInput = obtainUserInput("Enter number of rows: ");
        printDiamondLikeStructure(mainUserInput);

    }

}
