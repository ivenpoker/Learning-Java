package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Prints the Floyd's Triangle.                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 15, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_20 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserInupt(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (userInput < 0) {
                    throw new InputMismatchException("please enter positive number");
                }
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static void printAllData(int maxRows) {
        if (maxRows <= 0) {
            throw new IllegalArgumentException(String.format("Invalid input (%d). Must be > 0", maxRows));
        }
        for (int i = 1, cnt = 1; i <= maxRows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%d ", cnt++);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int userNumOfRows = obtainUserInupt("Enter number of rows: ");
        printAllData(userNumOfRows);

    }
}
