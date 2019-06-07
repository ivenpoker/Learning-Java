// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.19 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.util.Scanner;

public class Exercise_6_19 {

    private static void squareOfAsterisks(int side, char fillChar) {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++)
                System.out.printf("%c", fillChar);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter max size of square and character to fill: ");
        int side = input.nextInt();
        char fillChar  = input.next().charAt(0);

        System.out.println();
        squareOfAsterisks(side, fillChar);
    }
}
