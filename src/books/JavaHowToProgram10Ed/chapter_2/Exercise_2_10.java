// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.10 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

public class Exercise_2_10 {

    public static void main(String [] args) {
        int x = 2;
        int y = 3;

        System.out.printf("x = %d%n", x);                                   // Question a
        System.out.printf("Value of %d + %d is: %d%n", x, x, (x + x));      // Question b
        System.out.printf("x = ");                                          // Question c
        System.out.printf("%d = %d%n", (x + y), (y + x));                   // Question d
    }
}
