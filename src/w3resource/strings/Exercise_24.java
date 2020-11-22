package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Replaces a character in a string with another character.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_24 {

    public static void main(String[] args) {

        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);
        char searchChar = BasicUtils.readUserChar("Enter search char: ");
        char replaceChar = BasicUtils.readUserChar("Enter character to replace with: ");

        String modifiedStr = mainStr.replace(searchChar, replaceChar);
        System.out.printf("[UPDATED]: %s%n", modifiedStr);

    }

}
