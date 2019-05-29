// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.32 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

public class Exercise_4_32 {

    public static void main(String[] args) {
        int maxPrint = 8;
        int cnt = 0;

        while (cnt != maxPrint-1) {
            if (cnt % 2 == 0) {
                int tmp = maxPrint;
                while (tmp-- > 0)
                    System.out.print("* ");
                System.out.println();
            } else {
                int tmp = maxPrint;
                while (tmp-- > 0)
                    System.out.print(" *");
                System.out.println();
            }
            cnt++;
        }
    }
}
