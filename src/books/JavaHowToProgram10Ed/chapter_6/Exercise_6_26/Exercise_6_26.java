// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.26 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_26;

import java.util.Scanner;

public class Exercise_6_26 {

    private static int reverseDigits(int val) {
        String str = "";
        while (val > 0) {
            int tmp = val % 10;
            str += tmp;
            val /= 10;
        }
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to reverse it's digit: ");
        int userVal = input.nextInt();

        System.out.printf("Reversed digit: %d\n", reverseDigits(userVal));

    }
}
