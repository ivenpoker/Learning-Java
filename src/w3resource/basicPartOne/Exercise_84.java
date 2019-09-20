package w3resource.basicPartOne;

import java.util.Scanner;

// ##################################################################################################
// #                                                                                                #
// #    Program Purpose: Takes the last three characters from a given string and creates a new      #
// #                     string, appending the last three both to the front and the back of the old #
// #                     string.                                                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                      #
// #    Creation Date  : September 20, 2019                                                         #
// #                                                                                                #
// ##################################################################################################

public class Exercise_84 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readInputString(String inputMess) {
        boolean isValid = false;
        String mainStr = "";
        do {
            try {
                System.out.print(inputMess);
                mainStr = scanner.next().trim();
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner was closed unexpectedly. Re-opening...");
                scanner = new Scanner(System.in);
                System.err.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        } while (!isValid);
        return mainStr;
    }

    private static String processString(String someStr) {
        if (someStr.length() < 3)
            throw new IllegalArgumentException("String length must be >= 3.");
        String lastThreeChars = someStr.substring(someStr.length()-3);
        return lastThreeChars + someStr + lastThreeChars;
    }

    public static void main(String[] args) {
        String userString = readInputString("Enter a string: ");
        String newStr = processString(userString);

        System.out.printf("Last three characters: %s\n", newStr);
    }

}
