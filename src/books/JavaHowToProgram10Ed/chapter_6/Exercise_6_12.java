// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.8 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.security.SecureRandom;

public class Exercise_6_12 {

    private static SecureRandom random = new SecureRandom();

    private static void printRandomDataWithinRange(int low, int high, int numTimes) {
        for (int i = 0; i < numTimes; i++)
            System.out.printf("%d%s", (low + random.nextInt(high)), (i == numTimes-1) ? "\n" : " ");
    }

    public static void main(String[] args) {

        // Question a)
        System.out.printf("10 Random data in [1, 2]%6s: ", "");
        printRandomDataWithinRange(1, 3, 10); // we use '3' because, it will not be included, but 2 will

        // Question b)
        System.out.printf("10 Random data in [1, 100]%4s: ", "");
        printRandomDataWithinRange(1, 101, 10); // '101' for same reason above

        // Question c)
        System.out.printf("10 Random data in [0, 9]%6s: ", "");
        printRandomDataWithinRange(0, 10, 10); // '10' (as high) for the same reasons above

        // Question d)
        System.out.print("10 Random data in [1000, 1112]: ");
        printRandomDataWithinRange(1000, 113, 10); // figure this out! :)

        // Question e)
        System.out.printf("10 Random data in [-1, 1]%5s: ", "");
        printRandomDataWithinRange(-1, 2, 10); // same pattern as above.

        // Question f)
        System.out.printf("10 Random data in [-3, 11]%4s: ", "");
        printRandomDataWithinRange(-3, 12, 10); // same pattern as above.
    }
}
