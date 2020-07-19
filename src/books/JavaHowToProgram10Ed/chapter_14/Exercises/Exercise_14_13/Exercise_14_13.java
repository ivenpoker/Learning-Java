package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_13;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.13 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 6, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_14_13 {

    /**
     * Remove trailing spaces from individual tokens and
     * return a string made of space (single) separated tokens.
     *
     * @param tokens Tokens from which to create string.
     * @return A string made from tokens.
     */
    private static String [] cleanSentence(String [] tokens) {

        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            if (token.trim().length() != 0)
                sb.append(token).append(" ");
        }
        return sb.toString().trim().split(" ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cnt = 0;

        System.out.print("Enter some sentence: ");
        String sentence = input.nextLine().trim();

        String [] sentenceTokens = cleanSentence(sentence.split(" "));

        // Now lets output just those words beginning with "b"
        for (int i = 0; i < sentenceTokens.length; i++) {
            if (Character.toLowerCase(sentenceTokens[i].charAt(0)) == 'b') {
                System.out.printf("Found [#%02d]: %s\n", ++cnt, sentenceTokens[i]);
            }
        }

    }
}
