// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.36 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_36;

public class TriangleValidator {

    public static boolean isRightAngle(int sideA, int sideB, int sideC) {
        if (sideA == Math.sqrt(Math.pow(sideB, 2) + Math.pow(sideC, 2))) return true;
        if (sideB == Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideC, 2))) return true;

        return sideC == Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideC, 2));
    }
}
