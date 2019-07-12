// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.28 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_28 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        int radiusVal = input.nextInt();

        System.out.printf("Diameter of circle: %d\n", (2 * radiusVal));
        System.out.printf("Circumference of circle: %f\n", (2 * Math.PI * radiusVal));
        System.out.printf("Area of of circle: %f\n", (Math.PI * radiusVal * radiusVal));
    }
}
