package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Makes such a pattern like a pyramid with a number which will repeat #
// #                     the number in the same row.                                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 15, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_19 {

    private static final Scanner input = new Scanner(System.in);

    private static int readUserInput(String inputMess) {
        boolean inputValid = false;
        int userInt = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (userInt < 0) {
                    throw new InputMismatchException("please enter positive input");
                }
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static void printPattern(int maxRowCount) {
        if (maxRowCount % 2 != 0) {
            maxRowCount += 1;
        }
        for (int i = 1, sp = maxRowCount; i < maxRowCount; i++, sp--) {
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.printf("%d ", i);
            }
            for (int j = 0; j < sp; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int userInput = readUserInput("Enter some positive integer: ");
        printPattern(userInput);

    }

}
