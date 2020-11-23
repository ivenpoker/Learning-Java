package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Converts all the characters in a string to lowercase.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_29 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter string to convert: ", true);

        // Convert all characters to lowercase
        String lowerCase = mainStr.toLowerCase();
        System.out.printf("Lower case version: %s%n", lowerCase);
    }
}
