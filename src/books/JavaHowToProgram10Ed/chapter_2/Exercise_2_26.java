// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.26 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_26 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int fstInt = input.nextInt();

        System.out.print("Enter second integer: ");
        int sndInt = input.nextInt();

        if (fstInt % sndInt == 0)
            System.out.printf("Integer %d is a multiple of %d%n", fstInt, sndInt);
        if (fstInt % sndInt != 0)
            System.out.printf("Integer %d is NOT a multiple of %d%n", fstInt, sndInt);
    }
}
