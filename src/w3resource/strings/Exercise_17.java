package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the contents of a given string as a character array.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.Arrays;

public class Exercise_17 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);
        char[] mainStrCharArray = mainStr.toCharArray();

        System.out.printf("Character array of string: %s%n", Arrays.toString(mainStrCharArray));
        System.out.printf("Original string from character array ===> %s%n", new String(mainStrCharArray));
    }

}
