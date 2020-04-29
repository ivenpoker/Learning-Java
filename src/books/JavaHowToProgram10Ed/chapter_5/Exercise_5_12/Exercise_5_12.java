// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_12;

public class Exercise_5_12 {

    public static void main(String[] args) {
        int ans = 1;
        for (int i = 1; i <= 15; i += 2)
            ans *= i;
        System.out.printf("Product is: %d\n", ans);
    }
}
