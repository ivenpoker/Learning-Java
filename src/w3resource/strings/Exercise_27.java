package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets a substring of a given string between two specified positions. #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_27 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);
        int idxA = BasicUtils.getUserIntInput("Enter first index: ");
        int idxB = BasicUtils.getUserIntInput("Enter second index: ");

        System.out.printf("Substring between %d and %d: %s%n",
                idxA, idxB, mainStr.substring(idxA, idxB));

    }
}
