package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Counts a number of Unicode code points in the specified text range  #
// #                     of a string.                                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 21, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_4 {

    public static void main(String[] args) {

        String testMainStr = "This is a sample test main string";
        System.out.printf("[MAIN_STRING]: %s%n", testMainStr);

        System.out.printf("Number of unicode code points in the string: %d%n",
                testMainStr.codePointCount(1, 10));

    }
}
