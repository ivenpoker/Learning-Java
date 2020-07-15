package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_4;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.4 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 1, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_14_4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter main string: ");
        String mainStr = input.nextLine().trim();

        System.out.printf("Enter substring to compare in main string: ");
        String substr = input.next().trim();

        System.out.printf("Enter starting index in main string: ");
        int mainStartInd = input.nextInt();

        System.out.printf("Enter starting index in substring: ");
        int substrStartInd = input.nextInt();

        System.out.printf("Enter number of characters to compare: ");
        int charLen = input.nextInt();

        if (mainStr.regionMatches(false, mainStartInd, substr, substrStartInd, charLen)) {
            System.out.println("Test PASSED!");
        } else {
            System.out.println("Test FAILED!");
        }
    }
}
