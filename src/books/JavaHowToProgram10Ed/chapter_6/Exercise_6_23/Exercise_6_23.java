// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.23 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_23;

import java.util.Scanner;

public class Exercise_6_23 {

    private static double minimum3(double valA, double valB, double valC) {
        return Math.min(valA, Math.min(valB, valC));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter three double values: ");
        double valA = input.nextDouble();
        double valB = input.nextDouble();
        double valC = input.nextDouble();

        System.out.printf("Minimum value of three: %f\n",
                minimum3(valA, valB, valC));
    }
}
