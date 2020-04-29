// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.6 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_6 {

    public static void main(String[] args) {
        // COMPARE:
        //
        // 1. They both execute statements within their bodies a number of times based on some
        //    condition, which is in-effect the termination condition.
        // 2. They both possess the four properties of counter-controlled repetition.
        // 3. They can both get stuck inside infinite execution.
        //
        //
        // CONTRAST:
        //
        // 1. Initialization in 'while' is done before the 'while' itself, whereas in
        //    the 'for' it's done within the loop.
        // 2. 'Increment' in 'while' isn't part of the syntax (definition) i.e, it can't be
        //    found on the same line as the 'termination condition' (if any), whereas in 'for'
        //    it is found.
        // 3. Initialization of variable(s) when done in 'for' loop, goes out of scope when loop
        //    terminates. Whereas, in while loop, since initialization is done before loop, when the
        //    while loop terminates, it's still within it's scope.
    }
}
