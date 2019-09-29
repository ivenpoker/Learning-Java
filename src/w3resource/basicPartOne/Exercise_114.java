package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Obtains a string and an offset, rotate string by offset (rotate from left to    #
// #                     right).                                                                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 29, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_114 {

    private static Scanner scanner = new Scanner(System.in);

    private static String getUserString(String mess) {
        boolean isValid = false;
        String userData = "";

        while (!isValid) {
            try {
                System.out.print(mess);
                userData = scanner.nextLine().trim();
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[WARNING]: Scanner closed prematurely. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
        return userData;
    }

    private static int getStartingIndex(String mess) {
        boolean isValid = false;
        int startInd = 0;

        while (!isValid) {
            try {
                System.out.print(mess);
                startInd = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Invalid input. Please try again");

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[WARNING]: Scanner closed prematurely. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
        return startInd;
    }

    private static String rotateFromLeftToRightSubstring(String data, int startInd) {
        if (data.length() == 0)
            return "";
        if (startInd < 0 || startInd >= data.length())
            throw new IllegalArgumentException(String.format("Invalid index to be used for '%s'.", data));
        String tempSub = data.substring(startInd);
        return tempSub.substring(1) + tempSub.charAt(0);
    }

    public static void main(String[] args) {

        String mainData = getUserString("Enter main string to use: ");
        int startInd = getStartingIndex("Enter the starting index: ");
        String rotatedString = rotateFromLeftToRightSubstring(mainData, startInd);

        System.out.printf("Rotated string is: %s\n", rotatedString);

    }

}
