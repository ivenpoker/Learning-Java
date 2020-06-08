package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Removes duplicate letters and arrange in lexicographical order from   #
// #                     a given string which contains only lowercase letters.                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 8, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_200 {

    private static Scanner input = new Scanner(System.in);

    public static String removeDuplicateAndArrange(String mainStr) {
        ArrayList<Character> uniqueCharsList = new ArrayList<>();
        for (Character ch : mainStr.toCharArray()) {
            if (!uniqueCharsList.contains(ch)) {
                uniqueCharsList.add(ch);
            }
        }
        Collections.sort(uniqueCharsList);

        StringBuilder sb = new StringBuilder();
        for (Character ch : uniqueCharsList) {
            sb.append(ch);
        }
        return sb.toString();

    }

    private static String obtainUserStr(String inputMess) {
        String userStr = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userStr = input.next();
                if (userStr.length() == 0) {
                    throw new IllegalArgumentException("Please enter a string");
                }
                isValid = true;
            } catch (Exception exc) {
                System.out.printf("[ERROR]: %s%n", exc.getMessage());
            }
        }
        return userStr;
    }

    public static void main(String[] args) {

        String userData = obtainUserStr("Enter a string: ");
        String noDuplicates = removeDuplicateAndArrange(userData);

        System.out.printf("After removing duplicates: %s%n", noDuplicates);
    }
}
