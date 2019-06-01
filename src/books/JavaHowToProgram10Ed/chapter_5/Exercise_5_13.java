// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.13 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_13 {

    public static void main(String[] args) {
        System.out.printf("%s%20s\n", "Number", "Factorial");
        for (int i = 0; i < 20; i++)
            System.out.printf("%d%20d\n", i, factorial(i));
    }

    public static long factorial(int val) {
        long ans = 1;
        for (int i = val; i >= 1; i--)
            ans *= i;
        return ans;
    }
}
