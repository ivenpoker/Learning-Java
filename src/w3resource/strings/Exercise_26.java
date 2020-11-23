package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Checks whether a given string starts with the contents of another   #
// #                     string.                                                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_26 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);
        String checkStr = BasicUtils.readUserInputString("Enter check 'start' string: ", true);

        System.out.printf("Does main string starts with 'start' string: %s%n",
                mainStr.startsWith(checkStr) ? "YES" : "NO");
    }

}
