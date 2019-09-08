package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts binary number to hexadecimal.                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_23 {


    private static int binaryToDecimal(int binaryNumber) {
        int remainder = 0;
        int decimalNumber = 0;
        int j = 1;

        while (binaryNumber != 0) {
            remainder = binaryNumber % 10;
            decimalNumber += remainder * j;
            j *= 2;
            binaryNumber /= 10;
        }
        return decimalNumber;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int binaryNumber = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Enter binary number: ");
                binaryNumber = input.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();       // clear input stream, discard remaining data.
                System.err.println("Invalid input. Please, try again.");
            }
        } while (!valid);

        // Assuming user's input was binary....
        try {
            int decimalNumber = binaryToDecimal(binaryNumber);
            String hexEquivalent = Integer.toHexString(decimalNumber);
            System.out.printf("Hexadecimal equivalent: %s\n", hexEquivalent);

        } catch (Exception exception) {
            System.err.println("Error during conversion...\n");
            exception.printStackTrace();
        }
    }
}
