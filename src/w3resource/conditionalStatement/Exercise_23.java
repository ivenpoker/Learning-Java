package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays triangle in inverted format.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_23 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (userInput <= 0) {
                    throw new IllegalArgumentException(
                            String.format("Invalid input (%d). Must be > 0", userInput));
                }
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[input_valid]: %s%n", iMe.getMessage());
                input.nextLine();                     // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static void printStructure(int numOfRows) {
        for (int i = numOfRows, sp = 0; i > 0; i--, sp += 1) {
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int userInput = obtainUserInput("Enter the number: ");
        printStructure(userInput);

    }
}
