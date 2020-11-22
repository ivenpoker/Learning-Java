package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Computes the length of a string.                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_22 {

    private static final Scanner scanner = new Scanner(System.in);

    private static String obtainUserString(String inputMess) {
        boolean isInputValid = false;
        String userInput = "";

        while (!isInputValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.isEmpty()) {
                    throw new InputMismatchException("Input needed");
                }
                isInputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getCause().getMessage());
            }
        }
        return userInput;
    }

    public static void main(String[] args) {
        String userStr = obtainUserString("Enter some string: ");
        System.out.printf("Length of string is: %d%n", userStr.length());
    }

}
