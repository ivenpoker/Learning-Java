package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays the number rhombus structure.                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_25 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (userInput < 0) {
                    throw new IllegalArgumentException(
                            String.format("input must be > 0 [%d]", userInput));
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();                   // clear input stream.

            } catch (Exception mainExc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", mainExc.getMessage());
            }
        }
        return userInput;
    }

    private static void printStructure(int numOfRows) {

        for (int i = 0, sp = numOfRows-1; i < numOfRows; i++, sp--) {
            // display start spaces
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }

            if (i == 0) {
                System.out.print(i+1);
            } else {
                // generate number as string and print
                StringBuilder mainStr = new StringBuilder();
                mainStr.append(1);
                for (int j = 2; j <= i+1; j++) {
                    mainStr = new StringBuilder(j + mainStr.toString() + j);
                }

                System.out.print(mainStr);
            }

            // display end spaces
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = numOfRows - 2, sp = 1; i >= 0; i--, sp++) {

            // display start spaces
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }

            if (i == 0) {
                System.out.print(i+1);
            } else {
                // generate number as string and print
                StringBuilder mainStr = new StringBuilder();
                mainStr.append(1);
                for (int j = 2; j <= i+1; j++) {
                    mainStr = new StringBuilder(j + mainStr.toString() + j);
                }

                System.out.print(mainStr);
            }

            // display end spaces
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int userInput = obtainUserInput("Enter the number: ");
        printStructure(userInput);

    }

}
