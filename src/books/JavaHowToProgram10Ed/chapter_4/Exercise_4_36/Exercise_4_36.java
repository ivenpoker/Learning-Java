// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.36 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_36;

import java.util.Scanner;

public class Exercise_4_36 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side A: ");
        int sideA = input.nextInt();

        while (sideA <= 0) {
            System.out.print("Enter side A (> 0): ");
            sideA = input.nextInt();
        }

        System.out.print("Enter side A: ");
        int sideB = input.nextInt();

        while (sideB <= 0) {
            System.out.print("Enter side A (> 0): ");
            sideB = input.nextInt();
        }

        System.out.print("Enter side A: ");
        int sideC = input.nextInt();

        while (sideC <= 0) {
            System.out.print("Enter side A (> 0): ");
            sideC = input.nextInt();
        }

        if (TriangleValidator.isRightAngle(sideA, sideB, sideC)) {
            System.out.print("Sides represent a right angled triangle");
        } else {
            System.out.print("Sides don't represent a right angled triangle");
        }
    }
}
