// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.25 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

public class Exercise_4_25 {

    // Prints '****' for all odd values of 'count' variable and moves to newline.
    // Prints '++++++' for all even values of 'count' variable and moves to newline.

    public static void main(String[] args) {
        int count = 1;

        while (count <= 10) {
            System.out.println(count % 2 == 1 ? "****" : "++++++++");
            ++count;
        }
    }
}
