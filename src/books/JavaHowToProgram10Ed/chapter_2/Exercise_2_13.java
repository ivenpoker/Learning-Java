// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.13 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

public class Exercise_2_13 {

    public static void main(String[] args) {

        // Order of evaluation for (a)....
        //
        // 1. 3 * 6 -> ans
        // 2. ans / 2 -> ans
        // 3. 7 + ans -> ans
        // 4. ans - 1 = ans = x1 = 15

        int x1 = 7 + 3 * 6 / 2 - 1;
        System.out.printf("Value of x1: %d%n", x1);

        // Order of evaluation for (b)....
        //
        // 1. 2 % 2 -> ans1
        // 2. 2 * 2 -> ans2
        // 3. 2 / 2 -> ans3
        // 4. ans1 + ans2 -> ansX
        // 5. ansX - ans3 = ansY
        // 6. x2 = ansY = 4

        int x2 = 2 % 2 + 2 * 2 - 2 / 2;
        System.out.printf("Value of x2: %d%n", x2);

        // Order of evaluation for (c).....
        //
        // 1. 9 * 3 = ans1
        // 2. ans1 / 3 = ans2
        // 3. ans2 + 3 = ans4
        // 4. ans4 * 9 = ans5
        // 5. ans5 * 3 = ans6

        int x3 = (3 * 9 * (3 + (9 * 3 / (3))));
        System.out.printf("Value of x3: %d%n", x3);

    }
}
