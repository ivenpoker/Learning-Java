// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.15 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_15;

import java.util.Scanner;

public class Exercise_6_15 {

    private static double hypotenuse(double side1, double side2) {
        return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
    }

    public static void main(String[] args) {
        System.out.printf("Triangle 1, [side1: %.2f] [side2: %.2f] --> hypotenuse: %.2f\n", 3.0, 4.0, hypotenuse(3.0, 4.0));
        System.out.printf("Triangle 1, [side1: %.2f] [side2: %.2f] --> hypotenuse: %.2f\n", 5.0, 12.0, hypotenuse(5.0, 12.0));
        System.out.printf("Triangle 1, [side1: %.2f] [side2: %.2f] --> hypotenuse: %.2f\n", 8.0, 15.0, hypotenuse(8.0, 15.0));

        System.out.print("---------------------------------------------------------------\n");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for side 1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter value for side 2: ");
        double side2 = input.nextDouble();

        System.out.printf("Value for the hypotenuse: %.2f\n", hypotenuse(side1, side2));
    }
}
