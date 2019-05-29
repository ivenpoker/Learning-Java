// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.37 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_37;

public class Factorial {

    public static int factorial(int userVal) {
        int val = 1;
        while (userVal > 0)
            val *= userVal--;
        return val;
    }

    public static double estimateE(int numTerms) {
        double val = 1;
        int cnt = 1;
        while (numTerms-- > 0)
            val += (double) 1 / Factorial.factorial(cnt++);
        return val;

    }

    public static double estimate_E_to_X(int numTerms, int x) {
        double val = 1;
        int cnt = 1;
        while (numTerms-- > 0)
            val += (double) x / Factorial.factorial(cnt++);
        return val;
    }
}
