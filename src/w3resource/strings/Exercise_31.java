package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Trims any leading or trailing whitespaces from a given string.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_31 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);
        String trimmedStr = mainStr.trim();

        System.out.printf("Trimmed 'main' string: %s%n", trimmedStr);
    }

}
