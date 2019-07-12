// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.29 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

import java.util.Scanner;

public class Exercise_4_29 {

    public static void main(String[] args) {
        int cnt = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter max square side: ");
        int squareSide = input.nextInt();

        while (squareSide != cnt) {
            if (cnt == 0 || squareSide-1 == cnt) {
                int tmp = squareSide;
                while (tmp-- > 0)
                    System.out.print("*");
                System.out.println();
            } else {
                int tmp = squareSide-2;
                System.out.print("*");
                while (tmp-- > 0)
                    System.out.print(" ");
                System.out.println("*");
            }
            cnt++;
        }

    }
}
