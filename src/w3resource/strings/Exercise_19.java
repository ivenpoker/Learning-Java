package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the index of all the characters of the alphabet.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_19 {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private static void processString(String mainStr) {
        for (char ch : alphabet.toCharArray()) {
            System.out.printf("%c: %d%n", ch, mainStr.indexOf(ch));
        }
    }

    public static void main(String[] args) {
        String mainStr = "The quick brown fox jumps over the lazy dog.";
        processString(mainStr);
    }
}
