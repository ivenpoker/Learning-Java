package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Compares a given string to the specified character sequence.        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_9 {

    public static void main(String[] args) {
        String str1 = "example.com";
        String str2 = "Example.com";

        CharSequence mainCharSeq = "example.com";

        System.out.printf("Comparing [A] and [B]: %s%n", str1.contentEquals(mainCharSeq));
        System.out.printf("Comparing [B] and [A]: %s%n", str2.contentEquals(mainCharSeq));
    }

}
