package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Generates a triangle of @'s.                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_24 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainNumberOfRows(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (userInput < 0) {
                    throw new IllegalArgumentException(
                            String.format("Invalid input (%d). Must be > 0", userInput));
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();           // clear input stream.

            } catch (Exception mainExc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", mainExc.getMessage());
            }
        }
        return userInput;
    }

    private static void printRowsOfChar(int numOfRows, char mainChar) {
        for (int i = 0, sp = numOfRows -1, st = 1; i < numOfRows; i++, sp--, st++) {
            // prints spaces
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }

            // print special character 'st' times.
            for (int j = 0; j < st; j++) {
                System.out.printf("%c", mainChar);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int userInput = obtainNumberOfRows("Enter number of rows: ");
        printRowsOfChar(userInput, '@');
    }

}
