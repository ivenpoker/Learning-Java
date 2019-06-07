// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.20 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_6;

import java.util.Scanner;

public class Exercise_6_20 {

    private static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter radius of a circle: ");
        double radius = input.nextDouble();

        System.out.printf("Area of circle: %.2f\n", circleArea(radius));
    }
}
