package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Program that finds whether a region in the current string matches a #
// #                     region in another string.                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_23 {

    public static void main(String[] args) {
        String str1 = "Shanghai Houston Colorado Alexandra";
        String str2 = "Alexandria Colorado Houston Shanghai";

        boolean match1 = str1.regionMatches(0, str2, 28, 8);
        boolean match2 = str1.regionMatches(9, str2, 9, 8);

        // Display the results of the region matches method calls.
        System.out.printf("str1[0 - 7] == str2[28 - 35] ?: %s%n", match1 ? "YES" : "NO");
        System.out.printf("str1[9 - 15] == str2[9 - 15] ?: %s%n", match2 ? "YES" : "NO");
    }

}
