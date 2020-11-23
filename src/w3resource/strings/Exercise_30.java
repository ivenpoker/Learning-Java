package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Converts all characters in a string to lowercase.                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_30 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);

        // Convert string to uppercase
        String uppercaseStr = mainStr.toUpperCase();

        System.out.printf("Uppercase version: %s%n", uppercaseStr);
    }

}
