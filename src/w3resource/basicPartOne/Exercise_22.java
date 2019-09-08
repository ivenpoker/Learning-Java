package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts binary number to decimal.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_22 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        long binaryNumber = 0;
        long decimalNumber = 0;
        long j = 1;
        long remainder;

        boolean valid = false;

        do {
            try {
                System.out.print("Enter binary number: ");
                binaryNumber = input.nextLong();
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input. Please, try again.");
            }
        } while (!valid);

        while (binaryNumber != 0) {
            remainder = binaryNumber % 10;
            decimalNumber += remainder * j;
            j *= 2;
            binaryNumber /= 10;
        }
        System.out.printf("Decimal equivalent: %d\n", decimalNumber);

    }
}
