// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.16 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_16 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int fstInt = input.nextInt();

        System.out.print("Enter second integer: ");
        int sndInt = input.nextInt();

        if (fstInt < sndInt)
            System.out.printf("%d is greater than %d%n", sndInt, fstInt);

        if (fstInt > sndInt)
            System.out.printf("%d is greater than %d%n", fstInt, sndInt);

        if (fstInt == sndInt)
            System.out.println("These numbers are equal");
    }
}

