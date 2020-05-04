// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.10 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_10;

import java.util.Scanner;

public class Exercise_6_10 {

    private static int roundToInteger(double someVal) {
        return (int) Math.floor(someVal + 0.5);
    }

    private static double roundToTenths(double someVal) {
        return Math.floor(someVal * 10 + 0.5) / 10;
    }

    private static double roundToHundredths(double someVal) {
        return Math.floor(someVal * 100 + 0.5) / 100;
    }

    private static double roundToThousands(double someVal) {
        return Math.floor(someVal * 1000 + 0.5) / 1000;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter double value to round: ");
        double userVal = input.nextDouble();

        System.out.printf("Number %.2f to nearest integer: %d\n", userVal, roundToInteger(userVal));
        System.out.printf("Number %.2f to nearest tenths : %f\n", userVal, roundToTenths(userVal));
        System.out.printf("Number %.2f to nearest Hundredths : %f\n", userVal, roundToHundredths(userVal));
        System.out.printf("Number %.2f to nearest Thousandths: %f\n", userVal, roundToThousands(userVal));

    }
}
