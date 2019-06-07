// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise 5.26 in Book                   #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 5/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_26 {

    public static void main(String[] args) {

        // HOW TO REMOVE A LOOP FROM PROGRAM.
        //
        // To remove a loop from program, if we reach the point where we would
        // normally use the 'break' statement, we just INTENTIONALLY set the
        // loop iteration condition to state that would DEFINITELY fail on next
        // iteration.

        // Code from figure 5.13

        int count;
        int tmp = 0;

        for (count = 1; count <= 10; count++) {
            if (count == 5) {
                tmp = count;    // to keep track of current count, since we're about to modify it.
                count = 23;     // we use a dummy value 23 (could have used any >= 10) to break out of loop
            } else {
                System.out.printf("%d ", count);
            }
        }
        System.out.printf("%nBroke out of loop at count = %d%n", tmp);
    }
}
