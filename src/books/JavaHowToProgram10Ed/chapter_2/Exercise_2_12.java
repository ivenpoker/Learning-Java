// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_2;

public class Exercise_2_12 {

    public static void main(String[] args) {
        int y = 0;
        int x = 0;
        int a = 0;

        // Main equation: 'y = ax^3 + 7'
        y = a * x * x * x + 7;     // Same as equation
        y = a * x * x * (x + 7);   // Not same as equation
        y = (a * x) * x * (x + 7); // Not same as equation
        y = a * (x * x * x) + 7;   // Same as equation.
        y = a * x * (x * x + 7);   // Not same as equation.
    }
}
