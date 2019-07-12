// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.11 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_11;

public class Exercise_8_11 {

    public static void main(String[] args) {
        ComplexNumber numb1 = new ComplexNumber(12.0, 2.0);
        ComplexNumber numb2 = new ComplexNumber();
        ComplexNumber numb3 = new ComplexNumber(2.0, 1.0);

        System.out.printf("Complex number 1: %s\n", numb1);
        System.out.printf("Complex number 2: %s\n", numb2);
        System.out.printf("Complex number 3: %s\n", numb3);

        System.out.println();

        // Addition of complex numbers
        System.out.printf("Complex number 1 + number 2: %s\n", numb1.add(numb2));
        System.out.printf("Complex number 1 + number 3: %s\n", numb1.add(numb3));

        System.out.println();

        // Subtraction of complex numbers
        System.out.printf("Complex number 1 - number 2: %s\n", numb1.sub(numb2));
        System.out.printf("Complex number 1 - number 3: %s\n", numb1.sub(numb3));
    }

}
