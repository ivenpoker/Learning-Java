package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_15;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.10 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : July 24, 2019                                              #
// #                                                                                  #
// ####################################################################################


public class Exercise_11_15 {

    /**
     * ANSWER:
     *      -> Dealing with errors detected by constructors might encompass the whole
     *         possible errors that could occurs. Let's say we're doing some computation,
     *         there might an 'ArithmeticException' that might occur, which wasn't seen
     *         at design time, as a result will problematic at runtime. Using Exceptions
     *         leaves us with the possibility to hand some kinds of possible exceptions
     *         that might occurs (both seen and unseen) by using the main 'super'
     *         exception class, 'Exception'. This guarantees that whatever exception
     *         that occurs in the constructor it will be caught (as long as all the code
     *         in the constructor is wrapped with a try-catch statement.
     *
     *         Also exception handling in constructors leaves us with the possibility
     *         of recovering from errors, logging them and/or giving feedback to the
     *         caller the class.
     *
     */
}
