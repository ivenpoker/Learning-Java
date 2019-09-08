package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Multiply two binary numbers.                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_18 {

    public static void main(String[] args) {

        long binary1 = 0;
        long binary2 = 0;
        long multiply = 0;

        int digit = 0;
        int factor = 1;

        Scanner input = new Scanner(System.in);
        boolean valid = false;

        do {
            try {
                System.out.print("Enter the first binary number: ");
                binary1 = input.nextLong();
                valid = true;

            } catch (InputMismatchException inputMismatch) {
                input.nextLine();           // clear input stream.
                System.err.println("Invalid input. Try again.");
            }
        } while (!valid);

        valid = false;

        do {
            try {
                System.out.print("Enter the second binary number: ");
                binary2 = input.nextLong();
                valid = true;

            } catch (InputMismatchException inputMismatch) {
                input.nextLine();       // clear the input stream.
                System.err.println("Invalid input. Try again.");
            }
        } while (!valid);

        while (binary2 != 0) {
            digit = (int)(binary2 % 10);
            if (digit == 1) {
                binary1 *= factor;
                multiply = binaryProduct((int) binary1, (int) multiply);
            } else {
                binary1 *= factor;
            }
            binary2 /= 10;
            factor = 10;
        }
        System.out.print("Product of two binary numbers: " + multiply + "\n");

    }

    private static int binaryProduct(int binary1, int binary2) {
        int i = 0;
        int remainder = 0;
        int[] sum = new int[20];
        int binaryProductResult = 0;

        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (binary1 % 10 + binary2 % 10 + remainder) % 2;
            remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
            binary1 /= 10;
            binary2 /= 10;
        }

        if (remainder != 0) {
            sum[i++] = remainder;
        }
        --i;
        while (i >= 0) {
            binaryProductResult = binaryProductResult * 10 + sum[i--];
        }
        return binaryProductResult;
    }
}
