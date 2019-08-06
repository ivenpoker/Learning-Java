package books.JavaHowToProgram10Ed.chapter_14.Exercises;


// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.12 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 6, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_14_12 {

    /**
     * Finds the number times a character (<code>ch</code>) occurs in a string
     * <code>someString</code>.
     *
     * @param someString String to search from.
     * @param ch Character to search within string.
     * @return Number of times <code>ch</code> occurs in <code>someString</code>.
     */
    private static int findCharOccurrencesInString(String someString, char ch) {
        int cnt = 0;
        someString = someString.toLowerCase();
        for (int i = 0; i < someString.length(); i++) {
            int ind = someString.indexOf(ch);
            if (ind >= 0) {
                someString = someString.substring(ind+1);
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * Remove trailing spaces from individual tokens and
     * return a string made of space (single) separated tokens.
     *
     * @param tokens Tokens from which to create string.
     * @return A string made from tokens.
     */
    private static String cleanSentence(String [] tokens) {

        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            if (token.trim().length() != 0)
                sb.append(token).append(" ");
        }
        return sb.toString().trim();
    }


    /**
     * Removes all occurrences of a character in a string
     *
     * @param someString String to search character from within.
     * @param ch Character to search and remove.
     * @param ignoreCase Case sensitive or not.
     * @return
     */
    private static String removeChars(String someString, char ch, boolean ignoreCase) {
        StringBuilder sb = new StringBuilder();

        if (ignoreCase) {
            ch = Character.toLowerCase(ch);
            someString = someString.toLowerCase();
        }

        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) != ch)
                sb.append(someString.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] dataStore = new int[26];

        System.out.print("Enter some sentence: ");
        String sentence = input.nextLine().trim();

        // let's clean the core of the sentence
        sentence = cleanSentence(sentence.split(" "));

        // Compute all occurrences of individual unique characters
        // and keep tract of them.

        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isAlphabetic(sentence.charAt(i))) {

                // Count the number of times this character occurs in string.
                int charCnt = findCharOccurrencesInString(sentence, sentence.charAt(i));

                // Store the number of occurrences of current character in 'dataStore'.
                // To obtain the correct index for current character, I subtract it from
                // 'a', to know the distance from 'a'.

                dataStore[Character.toLowerCase(sentence.charAt(i)) - 'a'] = charCnt;

                // remove the counted character

                removeChars(sentence, sentence.charAt(i), true);
            } else {
                // throw new IllegalStateException(String.format("Invalid character '%c' found!", sentence.charAt(i)));
            }
        }

        System.out.print("\nCharacter(s) info.\n\n");
        for (int i = 0; i < dataStore.length; i++) {
            System.out.printf("%c has %d count(s)\n", 'a' + i, dataStore[i]);
        }
    }
}
