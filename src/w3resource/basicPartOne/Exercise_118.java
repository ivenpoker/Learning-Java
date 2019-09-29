package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Finds the first occurrence of a substring in a string.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 29, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.Scanner;

public class Exercise_118 {

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

    private static int findFirstSubStringOccurrence(String mainStr, String subStr) {
        if (mainStr.length() == 0 || (mainStr.length() < subStr.length()))
            return -1;
        for (int i = 0; i < mainStr.length(); i++) {
            int temp = i + subStr.length();
            String tempStr = mainStr.substring(i, i + subStr.length());
            if (temp < mainStr.length() && tempStr.equals(subStr))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String mainStr = getUserString("Enter main string: ");
        String subStr = getUserString("Enter substring to find first occurrence: ");
        System.out.printf("First occurrence of substring (index) in main string: %d\n",
                findFirstSubStringOccurrence(mainStr, subStr));
    }
}
