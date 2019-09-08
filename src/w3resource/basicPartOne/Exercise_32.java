package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Compares two numbers.                                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_32 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double firstNum = 0;
        double secondNum = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Enter first number: ");
                firstNum = input.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();           // clear input stream.
                System.err.println("Invalid input. Please try again.");
            }
        } while (!valid);

        valid = false;

        do {
            try {
                System.out.print("Enter second number: ");
                secondNum = input.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();           // clear input stream.
                System.err.println("Invalid input. Please try again.");
            }
        } while (!valid);

        if (firstNum < secondNum) {
            System.out.printf("%.2f < %.2f\n", firstNum, secondNum);
        } else if (firstNum > secondNum) {
            System.out.printf("%.2f > %.2f\n", firstNum, secondNum);
        } else {
            System.out.printf("%.2f == %.2f\n", firstNum, secondNum);
        }
    }
}
