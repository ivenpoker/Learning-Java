// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.31 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_31;

import java.util.Scanner;

public class Exercise_4_31 {

    public static void main(String[] args) {
        int decimal = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary digit: ");
        int binaryDigit = input.nextInt();

        while (!Digits.isBinaryNumber(binaryDigit)) {
            System.out.print("Enter a binary digit: ");
            binaryDigit = input.nextInt();
        }

        int digitLen = Digits.digitCount(binaryDigit);
        int val = 1;

        while (digitLen-- > 0) {
            int tmp = binaryDigit % 10;
            binaryDigit /= 10;
            decimal += tmp * val;
            val *= 2;
        }

        System.out.printf("Decimal equivalent: %d\n", decimal);

    }
}
