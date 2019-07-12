// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.30  rom book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_30;

import java.util.Scanner;

public class Exercise_4_30 {

    public static void main(String[] args) {
        boolean isPalindrome = false;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a five digit number: ");
        int digits = input.nextInt();

        while (!Digit.isNdigits(digits, 5)) {
            System.out.print("Enter a five digit number: ");
            digits = input.nextInt();
        }
        int realDigit = digits;

        int tmp1 = digits % 10;
        digits /= 10;
        int tmp2 = digits % 10;
        digits /= 10;
        int tmp3 = digits % 10;
        digits /= 10;
        int tmp4 = digits % 10;
        digits /= 10;
        int tmp5 = digits;

        if (tmp1 == tmp5)
            if (tmp2 == tmp4)
                isPalindrome = true;
        if (isPalindrome) {
            System.out.printf("Number '%d' IS A PALINDROME\n", realDigit);
        } else {
            System.out.printf("Number '%d' IS NOT A PALINDROME\n", realDigit);
        }
    }
}
