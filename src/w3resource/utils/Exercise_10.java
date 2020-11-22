package w3resource.utils;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Compares a given string to the specified string buffer.             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_10 {

    private static final int MAX_LINE_LENGTH = 75;

    public static void main(String[] args) {
        String str1 = "example.com";
        String str2 = "Example.com";
        StringBuffer strBuff = new StringBuffer(str1);

        System.out.printf("String [A]: %s%n", str1);
        System.out.printf("String [B]: %s%n", str2);
        System.out.printf("String Buffer: %s%n", strBuff);

        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_LINE_LENGTH);

        System.out.printf("Comparing [A] and [B]: %s%n", str1.contentEquals(strBuff));
        System.out.printf("Comparing [B] and [A]: %s%n", str2.contentEquals(strBuff));
    }
}
