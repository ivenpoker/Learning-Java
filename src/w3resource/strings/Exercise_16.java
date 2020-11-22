package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the contents of a given string as a byte array.                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.Arrays;

public class Exercise_16 {

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);
        byte[] mainStrByteArr = mainStr.getBytes();

        System.out.printf("Byte array of string: %s%n", Arrays.toString(mainStrByteArr));
        System.out.printf("Back to main string --> %s%n", new String(mainStrByteArr));
    }

}
