package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Checks if two given strings are anagrams.                                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : November 13, 2019                                                               #
// #                                                                                                     #
// #######################################################################################################

import java.util.Objects;
import java.util.Scanner;

public class Exercise_142 {

    private static Scanner input = new Scanner(System.in);

    private static String obtainUserStringData(String inputMessage) {
        String userData = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = input.next();
                if (userData.length() == 0)
                    throw new IllegalArgumentException("Oops, data needed!");
                isValid = true;

            } catch (IllegalArgumentException illegalEx) {
                System.err.println(illegalEx.getMessage());

            } catch (Exception otherEx) {
                System.err.println(otherEx);
            }
        }
        return userData;
    }

    public static boolean anagramTest(String str1, String str2) {
        if (Objects.isNull(str1) || Objects.isNull(str2)) {
            return false;
        } else if (str1.length() != str2.length()) {
            return false;
        } else if (str1.length() == 0 && str2.length() == 0) {
            return true;
        }
        int[] count = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String strA = obtainUserStringData(" Enter first string: ");
        String strB = obtainUserStringData("Enter second string: ");

        System.out.printf("Are strings anagrams: %s\n",
                anagramTest(strA, strB) ? "YES" : "NO");
    }
}
