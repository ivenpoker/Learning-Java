package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Creates a unique identifier of a given string.                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_18 {

    public static void main(String[] args) {
        String str1 = BasicUtils.readUserInputString("Enter string A: ", true);
        String str2 = BasicUtils.readUserInputString("Enter string B: ", true);

        System.out.printf("Hash for [A]: %s%n", str1.hashCode());
        System.out.printf("Hash for [B]: %s%n", str2.hashCode());
    }
}
