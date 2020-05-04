// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_14;

import java.util.Scanner;

public class Exercise_6_14 {

    private static int integerPower(int base, int exponent) {
        int resp = 1;
        for (int i = 0; i < exponent; i++)
            resp *= base;
        return resp;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter base and exponent: ");
        int base = input.nextInt();
        int exp  = input.nextInt();

        System.out.printf("Number %d^%d is: %d\n", base, exp, integerPower(base, exp));
    }
}
