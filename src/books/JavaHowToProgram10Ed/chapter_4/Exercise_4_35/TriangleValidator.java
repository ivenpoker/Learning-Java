// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.35 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_35;

public class TriangleValidator {

    public static boolean isTriangle(int sideA, int sideB, int sideC) {

        if (!(sideA > Math.abs(sideB - sideC) && sideA < (sideB + sideC))) return false; // validate sideA
        if (!(sideB > Math.abs(sideA - sideC) && sideB < (sideA + sideC))) return false; // validate sideB

        return sideC > Math.abs(sideA - sideB) && sideC < (sideA + sideB);  // finally, validate sideC
    }
}
