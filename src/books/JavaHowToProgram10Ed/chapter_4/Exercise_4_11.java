// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.11 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

public class Exercise_4_11 {

    public static void main(String[] args) {
        // ANS:
        //
        // When a Java Program tries to divide an integer by another, both integers
        // are divided and the results stored temporarily as 'double' (or float),
        // then the fractional part is discarded, but the integer part returned.
        //
        // The obtain the 'whole' data (i.e full 'double' value), we need to 'cast' the
        // first integer value to 'double' before performing the division. This in turn
        // will force java to return the results WITHOUT doing an truncation.
    }
}
