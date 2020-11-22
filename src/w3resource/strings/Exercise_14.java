package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Compares a given string to another string, ignoring case considera- #
// #                     tions.                                                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_14 {

    public static void main(String[] args) {
        String str1 = BasicUtils.readUserInputString("[A] Enter first string: ", true);
        String str2 = BasicUtils.readUserInputString("[B] Enter second string: ", true);

        System.out.printf("Is [A] equals to [B] Ignoring case: %s%n",
                str1.equalsIgnoreCase(str2) ? "YES" : "NO");
    }

}
