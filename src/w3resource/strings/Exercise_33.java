package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds all interleavings of a given string.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.HashSet;
import java.util.Set;

public class Exercise_33 {

    public static void findAllInterleavings(String res, String P, String Q, Set<String> out) {
        if (P.length() == 0 && Q.length() == 0) {
            out.add(res);
            return;
        }
        if (P.length() > 0) {
            findAllInterleavings(res + P.charAt(0), P.substring(1), Q, out);
        }
        if (Q.length() > 0) {
            findAllInterleavings(res + Q.charAt(0), P, Q.substring(1), out);
        }
    }

    public static void main(String[] args) {
        String strA = BasicUtils.readUserInputString("Enter 1st string [A]: ", true);
        String strB = BasicUtils.readUserInputString("Enter 2nd string [B]: ", true);

        Set<String> interLeavings = new HashSet<>();
        findAllInterleavings("", strA, strB, interLeavings);

        System.out.printf("%nThe interleavings strings are: ");
        interLeavings.stream().forEach(System.out::println);
    }
}
