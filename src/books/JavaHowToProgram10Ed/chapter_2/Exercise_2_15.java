// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.15 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_15 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int fstInt = input.nextInt();

        System.out.print("Enter second integer: ");
        int sndInt = input.nextInt();

        System.out.printf("Sum of %d and %d: %d\n", fstInt, sndInt, (fstInt + sndInt));
        System.out.printf("Product of %d and %d: %d\n", fstInt, sndInt, (fstInt * sndInt));
        System.out.printf("Difference of %d and %d: %d\n", fstInt, sndInt, (fstInt - sndInt));
        System.out.printf("Quotient of %d and %d: %d\n", fstInt, sndInt, (fstInt / sndInt));
    }
}
