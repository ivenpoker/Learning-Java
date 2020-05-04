// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.17 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_17;

import java.util.Scanner;

public class Exercise_6_17 {

    private static boolean isEven(int val) {
        return val % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter an integer [0 to quit]: ");
        int userInt = input.nextInt();

        while (userInt != 0) {
            System.out.printf("Number %d is %s\n", userInt,
                    isEven(userInt) ? "EVEN" : "ODD");
            System.out.printf("Enter an integer [0 to quit]: ");
            userInt = input.nextInt();
        }
    }
}
