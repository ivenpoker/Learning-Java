// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.37 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_37;

import java.util.Scanner;

public class Exercise_4_37 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter positive integer: ");
        int userVal = input.nextInt();

        while (userVal < 0) {
            System.out.print("Enter POSITIVE integer: ");
            userVal = input.nextInt();
        }

        System.out.printf("Factorial of %d is: %d\n", userVal, Factorial.factorial(userVal));
        System.out.print("\nEnter max terms for E: ");
        int maxTerms = input.nextInt();

        while (maxTerms < 0) {
            System.out.print("Enter max terms for E (> 0): ");
            maxTerms = input.nextInt();
        }
        System.out.printf("Value of e [max: %d] is: %.2f\n", maxTerms, Factorial.estimateE(maxTerms));
        System.out.print("Enter number of terms and value of x to compute e^x: ");
        maxTerms = input.nextInt();
        int xVal = input.nextInt();

        System.out.printf("Value of e^%d is: %.2f\n", xVal,
                Factorial.estimate_E_to_X(maxTerms, xVal));


    }
}
