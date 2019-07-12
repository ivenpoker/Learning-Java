// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.18 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.util.Scanner;

public class Exercise_6_18 {

    private static void squareOfAsterisks(int side) {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++)
                System.out.printf("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter max size of square asterisks: ");
        int side = input.nextInt();

        System.out.println();
        squareOfAsterisks(side);
    }
}
