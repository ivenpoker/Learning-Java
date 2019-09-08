package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Add two binary numbers.                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_17 {

    public static void main(String[] args) {
        long binary1 = 0;
        long binary2 = 0;

        int i = 0;
        int remainder = 0;
        int[] sum = new int[20];
        boolean valid = false;
        Scanner input = new Scanner(System.in);

        do {
            try {
                System.out.print("Input first binary number: ");
                binary1 = input.nextLong();
                valid = true;
            } catch (InputMismatchException inputMismatch) {
                input.nextLine();       // clear line
                System.err.println("Invalid input. Please, try again.");
            }
        } while (!valid);

        valid = false;

        do {
            try {
                System.out.print("Input second binary number: ");
                binary1 = input.nextLong();
                valid = true;

            } catch (InputMismatchException inputMismatch) {
                input.nextLine();
                System.err.println("Invalid input. Please, try again.");
            }
        } while (!valid);

        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (int)((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int)((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 /= 10;
            binary2 /= 10;
        }
        if (remainder != 0) {
            sum[i++] = remainder;
        }
        --i;
        System.out.print("Sum of two binary numbers: ");
        while (i >= 0) {
            System.out.print(sum[i--]);
        }
        System.out.println();
    }

}
