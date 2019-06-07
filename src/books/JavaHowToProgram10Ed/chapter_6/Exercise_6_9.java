// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.9 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

public class Exercise_6_9 {

    public static int roundToNearestInteger(double val) {
        return (int) Math.floor(val + 0.5);
    }

    public static void main(String[] args) {
        double valA = 12.4;
        double valB = 45.45;
        double valC = -67.4;

        System.out.printf("Rounding %.2f to int: %d\n", valA, roundToNearestInteger(valA));
        System.out.printf("Rounding %.2f to int: %d\n", valB, roundToNearestInteger(valB));
        System.out.printf("Rounding %.2f to int: %d\n", valC, roundToNearestInteger(valC));
    }
}
