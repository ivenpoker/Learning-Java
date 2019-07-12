// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.13 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.security.SecureRandom;

public class Exercise_6_13 {

    private static SecureRandom random = new SecureRandom();

    private static void printRandomDataWithinRange(int shiftValue, int diff,
                                                   int scaleFactor, int numTimes) {
        for (int i = 0; i < numTimes; i++)
            System.out.printf("%d%s", (shiftValue + diff * random.nextInt(scaleFactor)), (i == numTimes-1) ? "\n" : " ");
    }

    public static void main(String[] args) {
        System.out.print("[a] --> ");
        printRandomDataWithinRange(2, 2, 5, 5);

        System.out.print("[b] --> ");
        printRandomDataWithinRange(3, 2, 5, 5);

        System.out.print("[b] --> ");
        printRandomDataWithinRange(6, 4, 5, 5);
    }
}
