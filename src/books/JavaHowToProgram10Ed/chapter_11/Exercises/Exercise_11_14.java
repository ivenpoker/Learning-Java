package books.JavaHowToProgram10Ed.chapter_11.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 11.14 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : July 24, 2019                                              #
// #                                                                                  #
// ####################################################################################

public class Exercise_11_14  {

    /**
     * Exceptional cases:
     *          -> Division by zero.                   -> [ArithmeticException]
     *          -> Invalid array index.                -> [ArrayIndexOutOfBoundsException]
     *          -> Invalid character index in a string -> [StringIndexOutOfBoundsException]
     *          -> Trying to process a pointer         -> [NullPointerException]
     *          -> Invalid input from user.            -> [InputMismatchException]
     *
     *
     * HOW TO HANDLE EXCEPTIONS VARIOUS EXCEPTIONS:
     *
     * -> ArithmeticException:
     *          -> Wrap the code block that might throw this exception with a try-catch statement.
     *             In the 'catch' block, provide as parameter type 'ArithmeticException' and
     *             hence process it.
     *
     * -> ArrayIndexOutOfBoundsException:
     *          -> Wrap the code block that might throw this exception with a try-catch statement.
     *             In the 'catch' block, provide as parameter type 'ArrayIndexOutOfBoundsException'
     *             (which is a subclass of 'IndexOutOfBoundsException').
     *
     * -> StringIndexOutOfBoundsException:
     *          -> Wrap the code block that might throw this exception with a try-catch statement.
     *             In the 'catch'block, provide as parameter type 'StringIndexOutOfBoundsException'
     *             (which is a subclass of 'IndexOutOfBoundsException') and handle it properly.
     *
     * -> NullPointerException:
     *          -> Simply check if the the object variable is 'null', if it is, handle it
     *             appropriately.
     *
     * -> InputMismatchException:
     *          -> Wrap the code block that might throw this exception with a try-catch statement.
     *             In the 'catch' block, provide as parameter type 'InputMistMatchException' which
     *             is a subclass of 'NoSuchElementException'. In the 'catch' block, provide an
     *             exception handling code.
     *
     *
     */
}
