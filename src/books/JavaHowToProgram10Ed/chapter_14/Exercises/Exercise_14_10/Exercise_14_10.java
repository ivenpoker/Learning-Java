package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_10;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.10 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 6, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_14_10 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        System.out.printf("Uppercase version: %s\n", sentence.toUpperCase());
        System.out.printf("Lowercase version: %s\n", sentence.toLowerCase());
    }
}
