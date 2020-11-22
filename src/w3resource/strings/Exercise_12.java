package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Checks whether a given string ends with the contents of another     #
// #                     string.                                                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_12 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string to search: ", true);
        String searchStr = BasicUtils.readUserInputString("Enter search query: ", true);

        System.out.printf("Does main string ends with search query ?: %s%n",
                mainStr.endsWith(searchStr) ? "YES" : "NO");
    }

}
