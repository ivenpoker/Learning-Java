package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Creates a character array containing the contents of a string.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.Arrays;

public class Exercise_28 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);

        char[] mainStrCharArr = mainStr.toCharArray();
        System.out.printf("Character array of 'main' string: %s%n",
                Arrays.toString(mainStrCharArr));
    }
}
