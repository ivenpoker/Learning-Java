package w3resource.basicPartTwo;

// #######################################################################################
// #                                                                                     #
// #    Program Purpose: Accepts two strings and tests if the second string contains the #
// #                     first one                                                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                           #
// #    Creation Date  : December 29, 2019                                               #
// #                                                                                     #
// #######################################################################################

import java.util.Scanner;

public class Exercise_171 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserData(String inputMessage) {
        String userData = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextLine().trim();
                isValid = true;

            } catch (Exception exc) {
                System.err.println("[ERROR]: " + exc.getMessage());
            }
        }
        return userData;
    }

    private static boolean isSecondInFirstA(String mainStr, String key) {
        if (mainStr.length() < key.length()) {
            return false;
        }
        return mainStr.contains(key);
    }

    private static boolean isSecondInFirstB(String mainStr, String key) {
        if (mainStr.length() < key.length()) {
            return false;
        }
        int mainLen = mainStr.length();
        int tmpCnt = 0;
        boolean found = false;

        for (int i = 0; i < mainLen; i++) {
            for (int j = 0, k = i; j < key.length(); j++, k++) {
                if (mainStr.charAt(k) == key.charAt(j)) {
                    tmpCnt++;
                } else {
                    break;
                }
            }
            if (tmpCnt == key.length()) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {

        String mainString = obtainUserData("Enter main string to search from: ");
        String searchStr = obtainUserData("Enter string to search from first: ");
        System.out.printf("[A] Is the second string found in the first string: %s\n",
                (isSecondInFirstA(mainString, searchStr) ? "YES" : "NO"));
        System.out.printf("[B] Is the second string found in the first string: %s\n",
                (isSecondInFirstB(mainString, searchStr) ? "YES" : "NO"));
    }
}
