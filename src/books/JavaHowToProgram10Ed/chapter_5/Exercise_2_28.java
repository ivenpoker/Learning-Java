// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise 5.28 in Book                   #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 5/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_2_28 {

    public static void main(String[] args) {

        // To remove any 'continue' statement by replacing it with a structural equivalent,
        // we can provide a and 'empty' body for the condition that was used for the 'continue'
        // statement and attach the remaining code (that was to be executed if the condition failed)
        // in and 'else' block. OR we can just execute the code after the continue by putting it in
        // an if statement that verifies that the condition that causes the 'continue', is never met.

        // Code from  Fig 5.14 of book

        for (int count = 1; count <= 10; count++) {
//            if (count == 5)
//                continue;
//            System.out.printf("%d ", count);
            if (count != 5)
                System.out.printf("%d ", count);
        }
        System.out.printf("%nUsed 'structural equivalent' to skip printing 5%n");
    }
}
