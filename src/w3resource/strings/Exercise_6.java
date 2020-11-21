package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Compares two strings lexicographically, ignoring case differences.  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 21, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_6 {

    private static final Scanner scanner = new Scanner(System.in);

    private static String readUserInputString(String inputMess) {
        boolean inputValid = false;
        String userInputStr = "";

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInputStr = scanner.nextLine().trim();

                if (userInputStr.isEmpty()) {
                    throw new IllegalArgumentException("Missing string input");
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.out.printf("[MAIN_EXCEPTION]: %s%n", exc.getCause().getMessage());
            }
        }
        return userInputStr;
    }

    public static void main(String[] args) {
        String inputA = readUserInputString(" Enter first string: ");
        String inputB = readUserInputString("Enter second string: ");

        System.out.printf("[1] Are both strings (ignoring case) lexicographically equal: %s%n" ,
                            inputA.equalsIgnoreCase(inputB) ? "YES" : "NO");
    }
}
