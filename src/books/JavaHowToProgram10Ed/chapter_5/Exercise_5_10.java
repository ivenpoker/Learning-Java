// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.10 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_10 {

    public static void main(String[] args) {
        // Code will print 5 '@'s on 10 lines (each 5 '@'s on a single line).

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 5; j++)
                System.out.print('@');
            System.out.println();
        }
    }
}
