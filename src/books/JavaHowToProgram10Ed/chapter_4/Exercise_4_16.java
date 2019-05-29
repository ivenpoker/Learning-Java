// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.16 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

public class Exercise_4_16 {


    // ANS:
    //
    // RESP: Prints the square of x as it's incremented, then finally prints the sum
    //       of all the squares <= 10.

    public static void main(String[] args) {
        int x = 1;
        int total = 0;

        while (x <= 10) {
            int y = x * x;
            System.out.println(y);
            total += y;
            ++x;
        }
        System.out.printf("Total is: %d\n", total);
    }
}
