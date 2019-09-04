package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Compute the product of two numbers.                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 4, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double valA = 0;        // user first number
        double valB = 0;        // user second number
        boolean cont = true;

        do {
            try {
                System.out.print("Enter first number: ");
                valA = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();       // clear all input in stream.
                System.err.println("Invalid input");
            }
        } while (cont);

        cont = true;    // reset the value of continue for next input

        do {
            try {
                System.out.print("Enter second number: ");
                valB = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();           // clear all input in stream.
                System.err.println("Invalid input");
            }
        } while (cont);

        // Now let's print the results

        System.out.println(String.format("%.1f + %.1f = %.1f", valA, valB, (valA + valB)));
        System.out.println(String.format("%.1f - %.1f = %.1f", valA, valB, (valA - valB)));
        System.out.println(String.format("%.1f x %.1f = %.1f", valA, valB, (valA * valB)));
        System.out.println(String.format("%.1f / %.1f = %.1f", valA, valB, (valA / valB)));
        System.out.println(String.format("%.1f mod %.1f = %.1f", valA, valB, (valA % valB)));
    }
}
