// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.26 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

public class Exercise_4_26 {

    public static void main(String[] args) {
        int row = 10;

        // Prints '>' (x 10) for all odd rows.
        // Prints '<' (x 10) for all even rows.

        while (row >= 1) {
            int column = 1;
            while (column <= 10) {
                System.out.print(row % 2 == 1 ? "<" : ">");
                ++column;
            }
            --row;
            System.out.println();
        }
    }
}
