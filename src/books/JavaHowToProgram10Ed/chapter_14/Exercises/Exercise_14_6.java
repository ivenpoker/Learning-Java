package books.JavaHowToProgram10Ed.chapter_14.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.6 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 1, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;

public class Exercise_14_6 {

    private static final int MAX_RANDOM_SENTENCES = 20;
    private static final SecureRandom random = new SecureRandom();
    private static final int MAX_RAND_FROM_PARTS = 4;


    public static void main(String[] args) {
        String[] names = {"Jake", "Peter", "James", "Tatiana", "Brandon"};
        String[] verbs = {"Slept", "ran", "swam", "killed", "slapped"};
        String[] likes = {"jumping", "running", "jogging", "programming"};
        String[] places = {"Germany", "England", "Britain", "Park"};

        for (int i = 1; i <= MAX_RANDOM_SENTENCES; i++) {
            StringBuilder sentence = new StringBuilder(names[random.nextInt(MAX_RAND_FROM_PARTS)]).append(" ");
            sentence.append(verbs[random.nextInt(MAX_RAND_FROM_PARTS)]).append(" ");
            sentence.append(likes[random.nextInt(MAX_RAND_FROM_PARTS)]).append(" ");
            sentence.append(places[random.nextInt(MAX_RAND_FROM_PARTS)]).append(".");

            sentence.replace(0, 1, Character.toString(sentence.charAt(0)));

            System.out.printf("Sentence #%02d: %s\n", i, sentence);
        }
    }
}
