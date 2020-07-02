package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Match any single character (use ?) or any sequence of characters use  #
// #                     *) including the empty string. The matching should cover the entire   #
// #                     input string.                                                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 02, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_210 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserInputString(String inputMess) {
        boolean inputValid = false;
        String userInput = "";

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.length() > 0) {
                    inputValid = true;
                }
            } catch (IllegalStateException iSe) {
                System.err.print("[SCANNER__INIT] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();                 // clear any remaining input stream data.

            } catch (InputMismatchException iMe) {
                System.err.println("[INVALID_INPUT]");
                scanner.nextLine();                 // clear any remaining input stream data.

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s%n", exc.getMessage());
                scanner.nextLine();                 // clear any remaining input stream data.
            }
        }
        return userInput;
    }

    private static boolean patternMatch(String string, String pattern) {
        // i measures the length of the string
        int i = 0;
        // j measures the length of the pattern
        int j = 0;
        int star_index = -1;
        int i_index = -1;

        while (i < string.length()) {

            //If ? matches the ith character of the string or if the jth character of the
            //pattern matches the ith character of the string. e.g.(a & ?),(ab & ab)

            if (j < pattern.length() && (pattern.charAt(j) == '?' || pattern.charAt(j) == string.charAt(i))) {
                ++i;
                ++j;
            }

            // Counts * characters of the pattern when the count of the string is not
            // completed yet. e.g.(a & ***),(abb & ab****)

            else if (j < pattern.length() && pattern.charAt(j) == '*') {
                star_index = j;
                i_index = i;
                j++;
            }

            // Counts the characters of the string which are left out once a * of the pattern
            // gets counted e.g.(xayb & *a*b),(a & ***),(abcd & ab*),(aa & ?**)

            else if (star_index != -1) {
                j = star_index + 1;
                i = i_index+1;
                i_index++;
            }

            // If the characters of the string and pattern don't match
            // e.g.(xy & ab),(abxy & ab)

            else {
                return false;
            }
        }

        // Counts the * characters of the pattern when the characters before the * characters
        // of the pattern completely match the string and both are of the same length
        // (apart from the star characters of the pattern)
        // e.g.(ab and ab**),(aa and ??**)

        while (j < pattern.length() && pattern.charAt(j) == '*') {
            ++j;
        }

        return j == pattern.length();
    }

    public static void main(String[] args) {

        String mainStr = obtainUserInputString("Enter main string: ");
        String pattern = obtainUserInputString("Enter pattern: ");

        System.out.printf("Does string matches pattern: %s%n",
                (patternMatch(mainStr, pattern) ? "YES" : "NO"));

    }

}
