package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_5;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.5 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 1, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;

public class Exercise_14_5 {

    private static final int MAX_RANDOM_SENTENCES = 20;
    private static final SecureRandom random = new SecureRandom();
    private static final int MAX_RAND_FROM_PARTS = 4;

    public static void main(String[] args) {
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = {"to", "from", "over", "under", "on"};

        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < MAX_RANDOM_SENTENCES; i++) {
            if (sentence.length() != 0)             // if there was a previous 'sentence', remove it
                sentence = new StringBuilder();
            sentence.append(article[random.nextInt(MAX_RAND_FROM_PARTS)]).append(" ");
            sentence.append(noun[random.nextInt(MAX_RAND_FROM_PARTS)]).append(" ");
            sentence.append(verb[random.nextInt(MAX_RAND_FROM_PARTS)]).append(" ");
            sentence.append(preposition[random.nextInt(MAX_RAND_FROM_PARTS)]).append(".");

            sentence.replace(0, 1, Character.toString(sentence.charAt(0)).toUpperCase());
            System.out.printf("Sentence #%02d: %s\n", (i+1), sentence);
        }
    }


}
