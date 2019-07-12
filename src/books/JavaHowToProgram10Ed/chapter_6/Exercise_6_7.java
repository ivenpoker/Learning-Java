// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.7 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

public class Exercise_6_7 {

    public static void main(String[] args) {
        System.out.printf("x = Math.abs(7.5)    : %.1f\n", Math.abs(7.5));
        System.out.printf("x = Math.floor(7.5)  : %.1f\n", Math.floor(7.5));
        System.out.printf("x = Math.abs(0.0)    : %.1f\n", Math.abs(0.0));
        System.out.printf("x = Math.ceil(0.0))  : %.1f\n", Math.ceil(0.0));
        System.out.printf("x = Math.abs(-6.4)   : %.1f\n", Math.abs(-6.4));
        System.out.printf("x = Math.ceil(-Math.abs(-8 + Math.floor(-5.5))): %.1f\n",
                Math.ceil(-Math.abs(-8 + Math.floor(-5.5))));
    }
}
