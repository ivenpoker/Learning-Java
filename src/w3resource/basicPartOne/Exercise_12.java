package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Find the average of three numbers.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 4, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_12 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double numA = 0.0;      // first number
        double numB = 0.0;      // second number
        double numC = 0.0;      // third number
        boolean cont = true;

        do {
            try {
                System.out.print("Enter first number: ");
                numA = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();       // clear data from input stream (not needed)
                System.err.println("Invalid input. Try again.");

            } catch (Exception exc) {
                System.err.println("Terminating...");
                exc.printStackTrace();
            }
        } while (cont);

        cont = true;        // reset the value of 'cont'

        do {
            try {
                System.out.print("Enter second number: ");
                numB = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();       // clear data from input stream (not needed)
                System.err.println("Invalid input. Try again.");

            } catch (Exception exc) {
                System.err.println("Terminating...");
                exc.printStackTrace();
            }
        } while (cont);

        cont = true;

        do {
            try {
                System.out.print("Enter third number: ");
                numC = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();       // clear data from input stream (not needed)
                System.err.println("Invalid input. Try again.");

            } catch (Exception exc) {
                System.err.println("Terminating...");
                exc.printStackTrace();
            }
        } while (cont);

        // Print the average of the three numbers

        System.out.printf("Average of %.1f, %.1f and %.1f = %.1f", numA, numB, numC,
                (numA + numB + numC) / 3);
    }
}
