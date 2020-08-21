package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Determines if a number is positive, negative or zero.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_27 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();
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

    public static void main(String[] args) {

        int mainInputVal = obtainUserInput("Enter a number: ");
        if (mainInputVal > 0) {
            System.out.println("Number is positive");
        } else if (mainInputVal < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is 0");
        }

    }
}
