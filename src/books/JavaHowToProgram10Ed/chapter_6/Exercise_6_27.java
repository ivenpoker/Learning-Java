// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.27 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.util.Scanner;

public class Exercise_6_27 {

    private static int gcd(int uVal, int vVal) {
        int tmp;
        while (uVal > 0) {
            if (uVal < vVal) {
                tmp = uVal;
                uVal = vVal;
                vVal = tmp;
            }
            uVal = uVal - vVal;
        }
        return vVal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an two numbers to find GCD: ");
        int valA = input.nextInt();
        int valB = input.nextInt();

        System.out.printf("GCD of %d and %d: %d\n", valA, valB, gcd(valA, valB));
    }
}
