// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.25 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_25 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter integer: ");
        int userInt = input.nextInt();

        if (userInt % 2 == 0)
            System.out.printf("Integer '%d' is EVEN.", userInt);
        if (userInt % 2 != 0)
            System.out.printf("Integer '%d' is ODD.", userInt);
    }
}
