package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_15;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.14 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 6, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_14_15 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter integer code for a character: ");
        int userInt = input.nextInt();

        System.out.printf("Character equivalent: %c\n", (char) userInt);

        // Display all characters from 000 to 255;

        for (int i = 0; i <= 255; i++) {
            System.out.printf("Character for %03d: %c\n", i, (char) i);
        }
    }
}
