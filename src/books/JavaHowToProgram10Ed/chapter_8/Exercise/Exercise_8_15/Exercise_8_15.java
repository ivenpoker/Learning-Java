// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.15 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_15;

public class Exercise_8_15 {

    public static void main(String[] args) {
        Rational ratA = new Rational(2, 4);
        Rational ratB = new Rational(4, 9);

        System.out.printf("Rational A: %s\n", ratA);
        System.out.printf("Rational B: %s\n", ratB);

        // adding the two rational numbers
        System.out.printf("A + B: %s\n", Rational.add(ratA, ratB));

        // Subtracting the two rational numbers
        System.out.printf("A - B: %s\n", Rational.sub(ratA, ratB));

        // Multiplying the two rational numbers
        System.out.printf("A * B: %s\n", Rational.div(ratA, ratB));

        // Dividing the two rational numbers
        System.out.printf("A / B: %s\n", Rational.div(ratA, ratB));

        System.out.printf("Rational A (float): %s\n", ratA.toFloatString());
        System.out.printf("Rational B (float): %s\n", ratB.toFloatString());
    }
}
