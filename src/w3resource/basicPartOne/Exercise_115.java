package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Checks if an integer value is palindrome.                                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 29, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.Scanner;

public class Exercise_115 {

    private static Scanner scanner = new Scanner(System.in);

    private static int getUserInt(String mess) {
        boolean isValid = false;
        int userData = 0;

        while (!isValid) {
            try {
                System.out.print(mess);
                userData = scanner.nextInt();
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

    private static boolean isIntegerPalindrome(int mainInt) {
        String intEquiv = Integer.toString(mainInt);
        for (int i = 0, j = intEquiv.length()-1; i < j; i++, j--)
            if (intEquiv.charAt(i) != intEquiv.charAt(j))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int mainInt = getUserInt("Enter some integer to check if palindrome: ");
        System.out.printf("Is '%d' a palindrome ?: %s\n", mainInt,
                isIntegerPalindrome(mainInt) ? "YES" : "NO");
    }
}
