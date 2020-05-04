// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.21 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_21;

import java.util.Scanner;

public class Exercise_6_21 {

    // a)
    private static int integerPartOfQuotient(int valA, int valB) {
        return valA / valB;
    }

    // b)
    private static int remainderPartOfQuotient(int valA, int valB) {
        return valA % valB;
    }

    // c)
    private static void displayDigits(int someNum) {
        String tmp = "";
        while (someNum > 0) {
            int val = remainderPartOfQuotient(someNum, 10);
            tmp  = val +  " " + tmp;
            someNum = integerPartOfQuotient(someNum, 10);
        }
        System.out.printf("Digits: %s", tmp);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer value between 1 and 99999: ");
        int userInt = input.nextInt();

        while (userInt < 1 || userInt > 99999) {
            System.out.print("Enter an integer value between 1 and 99999: ");
            userInt = input.nextInt();
        }
        displayDigits(userInt);

    }
}
