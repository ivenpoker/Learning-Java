// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise 5.27 in Book                   #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 5/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_27 {

    public static void main(String[] args) {

        // Prints a square of size 3, made of '*'s to the console,
        // the prints a two new lines. This is repeated 5 times.

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 4; k++)
                    System.out.print('*');
                System.out.println();
            }
            System.out.println();
        }

    }
}
