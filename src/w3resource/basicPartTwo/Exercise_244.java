package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Determines if a user provided string meets a certain specifications.  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : August 06, 2020                                                       #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_244 {

    private static final Scanner input = new Scanner(System.in);
    private static final String KEY_CHARS = "xyz";

    private static String readUserInputStr(String inputMess) {
        boolean valid = false;
        String userInputStr = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInputStr = input.nextLine().trim();

                if (userInputStr.isEmpty()) {
                    throw new IllegalArgumentException("please enter a string (text).");
                }
                valid = true;
            } catch (IllegalArgumentException iAe) {
                System.err.printf("[INVALID_INPUT]: %s%n", iAe.getMessage());

            } catch (Exception exc) {
                System.out.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInputStr;
    }

    private static boolean isStringValid(String mainStr) {

        // Asserting that only the three characters in 'KEY_CHARS' are present
        // in the string, and no other characters.

        for (char ch : mainStr.toCharArray()) {
            if (KEY_CHARS.indexOf(ch) < 0) {
                return false;                       // we've found an invalid character.
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String userInput = readUserInputStr("Enter some string (text): ");
        System.out.printf("Does string pass test: %s%n", isStringValid(userInput) ? "YES" : "NO");

    }

}
