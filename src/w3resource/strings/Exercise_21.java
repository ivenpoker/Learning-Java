package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the last index of a string within a string.                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_21 {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void processString(String mainStr) {
        for (char ch : alphabet.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                System.out.printf("%c: %d%n", ch, mainStr.lastIndexOf(ch));
            }
        }
    }

    public static void main(String[] args) {
        String mainStr = "The quick brown fox jumps over the lazy dog.";
        processString(mainStr);
    }

}
