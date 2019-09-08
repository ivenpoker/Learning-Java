package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts decimal number to binary.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_19 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userNum = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Enter decimal number: ");
                userNum = input.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatch) {
                input.nextLine();       // clear input stream. Discard all remaining data.
                System.err.println("Invalid input. Try again.");
            }
        } while (!valid);

        String binaryString = Integer.toBinaryString(userNum);
        try {
            long binaryLong = Long.parseLong(binaryString);
            System.out.printf("Binary equivalent of %d: %d\n", userNum, binaryLong);

        } catch (NumberFormatException numberException) {
            System.out.printf("Binary equivalent of %d: %s", userNum, binaryString);
        }

    }
}
