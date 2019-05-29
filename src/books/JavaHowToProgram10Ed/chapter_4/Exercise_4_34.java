// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.34 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

public class Exercise_4_34 {

    public static void main(String[] args) {
        // The problem is that, ++(x + y) statement is trying to increment the result
        // the results of ++(x + y), but the problem is that, (x + y) isn't a memory
        // location but a RESULT. which can't be increment. The computation looks like
        // this
        //
        //              (x + y) = (x + y) + 1;
        //    While does make sense, since the right hand side (x+y) isn't a memory
        // location.

        // FIX: Create a new variable and assign the results of (x+y) to it then,
        //      increment the variable.
        //
        //       int val = x + y;
        //      System.out.println(++val);
    }
}
