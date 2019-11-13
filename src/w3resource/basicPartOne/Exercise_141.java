package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Check if a given string has all unique characters.                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : November 13, 2019                                                               #
// #                                                                                                     #
// #######################################################################################################

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.Scanner;
import java.util.HashSet;

public class Exercise_141 {

    private static Scanner input = new Scanner(System.in);

    private static String obtainUserString(String inputMess) {
        boolean isValid = false;
        String userStr = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userStr = input.next();
                if (userStr.length() == 0)
                    throw new IllegalArgumentException("Oops, input needed!");
                isValid = true;
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return userStr;
    }

    private static boolean hasAllUniqueCharacters(String someStr) {
        List<Character> tempList = new LinkedList<>();
        for (Character ch : someStr.toCharArray())
            tempList.add(ch);

        Set<Character> newCharSet = new HashSet<>(tempList);
        return someStr.length() == newCharSet.size();
    }

    public static void main(String[] args) {

        String mainStr = obtainUserString("Enter some a string to check: ");
        System.out.printf("String has all unique characters: %s\n",
                hasAllUniqueCharacters(mainStr) ? "YES" : "NO");
    }
}
