package books.JavaHowToProgram10Ed.chapter_14.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.3 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 1, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_14_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter first string: ");
        String stringA = input.next().trim();

        System.out.printf("Enter second string: ");
        String stringB = input.next().trim();

        int cmpInt = stringA.compareTo(stringB);
        if (cmpInt == 0) {
            System.out.println("Strings are the SAME");
        } else if (cmpInt > 0) {
            System.out.printf("String '%s' is greater than '%s'\n", stringA, stringB);
        } else {
            System.out.printf("String '%s' is less than '%s'\n", stringA, stringB);
        }
    }
}
