package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Compares two strings lexicographically. Two strings are lexigraph-  #
// #                     ically equal if they are the same length and contain the same       #
// #                     characters in the same positions.                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 21, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_5 {

    private static final Scanner scanner = new Scanner(System.in);

    private static String readUserInputString(String inputMess) {
        boolean inputValid = false;
        String userStr = "";

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userStr = scanner.nextLine().trim();

                if (userStr.isEmpty()) {
                    throw new InputMismatchException("Please provide input");
                }
                inputValid = true;
            } catch (InputMismatchException iMe){
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_ERROR]: %s%n", exc.getCause().getMessage());
            }
        }
        return userStr;
    }

    private static boolean manualLexicographicalStringCheck(String firstStr, String secondStr) {
        if (firstStr.length() != secondStr.length()) {
            return false;
        }
        for (int i = 0, size = firstStr.length(); i < size; i++) {
            if (firstStr.charAt(i) != secondStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String fstStr = readUserInputString(" Enter first string: ");
        String sndStr = readUserInputString("Enter second string: ");

        System.out.printf("[1] Are both strings lexicographically equal: %s%n",
                fstStr.equals(sndStr) ? "YES" : "NO");
        System.out.printf("[2] Are both strings lexicographically equal: %s%n",
                manualLexicographicalStringCheck(fstStr, sndStr) ? "YES" : "NO");

    }
}
