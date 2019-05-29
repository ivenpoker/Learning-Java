// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.33 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

public class Exercise_4_33 {

    // This will run indefinitely (infinitely).
    // On my pc, caused system to freeze, till i managed to stop execution.
    // Also, displayed some zeros (a lot of them).

    public static void main(String[] args) {
        int cnt = 2;
        while (true) {
            System.out.printf("%d\n", cnt);
            cnt *= 2;
        }
    }
}
