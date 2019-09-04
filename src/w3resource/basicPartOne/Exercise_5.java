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

public class Exercise_5 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double valA = 0;    // first user input
        double valB = 0;    // second user input
        boolean cont = true;

        // Obtain first integer from user.

        do {
            try {
                System.out.print("Enter first number: ");
                valA = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();                        // discard all remaining input
                System.err.println("Invalid input");
            }
        } while (cont);

        cont = true; // reset the it's value.

        // Obtain second number from user.
        do {
            try {
                System.out.print("Enter second number: ");
                valB = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();                       // discard all remaining input
                System.err.println("Invalid input");
            }
        } while (cont);


        System.out.println(String.format("%.1f X %.1f = %.2f", valA, valB, (valA * valB)));

    }
}
