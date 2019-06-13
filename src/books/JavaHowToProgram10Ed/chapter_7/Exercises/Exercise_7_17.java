// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.17 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 11/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercises;

import java.util.Random;

public class Exercise_7_17 {

    private static final Random random = new Random();
    private static final int MAX_ARRAY_SIZE = 6;

    private static int randomVal(int lower, int upper) {
        return lower + random.nextInt(upper);
    }

    public static void main(String[] args) {
        int[] mainSum = new int[MAX_ARRAY_SIZE * 2 + 1];

        for (int i = 0; i < 36_000_000; i++) {
            int valA = randomVal(1, 6);
            int valB = randomVal(1, 6);
            mainSum[valA + valB]++;
        }

        System.out.printf("%s%20s\n", "Sum", "Occurrences");
        for (int i = 2; i < mainSum.length; i++) {
            System.out.printf("%2d%20d\n", i, mainSum[i]);
        }

    }
}
