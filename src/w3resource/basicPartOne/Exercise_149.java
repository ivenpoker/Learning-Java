package w3resource.basicPartOne;

// ##############################################################################
// #                                                                            #
// #    Program Purpose: Checks if a given string is a permutation of another   #
// #                     given string.                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                  #
// #    Creation Date  : November 22, 2019                                      #
// #                                                                            #
// ##############################################################################

import java.util.Arrays;
import java.util.Scanner;

public class Exercise_149 {

    private static Scanner input = new Scanner(System.in);

    private static String getuserData(String inputMessage) {
        String userData = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = input.next().trim();

                if (userData.length() == 0)
                    throw new IllegalArgumentException("Oops, data needed");
                isValid = true;

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        return userData;
    }

    private static boolean isPermutation(String fstStr, String sndStr) {
        fstStr = fstStr.trim();
        sndStr = sndStr.trim();
        if (fstStr.length() != sndStr.length())
            return false;
        char[] dataA = fstStr.toCharArray();
        char[] dataB = sndStr.toCharArray();

        // If both strings are permutations of each other,
        // after sorting them, they should have the same data, in same order.

        Arrays.sort(dataA);
        Arrays.sort(dataB);

        for (int i = 0; i < dataA.length; i++)
            if (dataA[i] != dataB[i])
                return false;
        return true;
    }

    public static void main(String[] args) {

        String firstStr = getuserData("Enter first string data: ");
        String secondStr = getuserData("Enter second string data: ");
        System.out.printf("Are '%s' and '%s' permutations: %s\n",
                firstStr, secondStr, (isPermutation(firstStr, secondStr) ? "YES" : "NO"));

    }
}
