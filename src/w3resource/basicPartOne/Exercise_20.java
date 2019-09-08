package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts decimal number to hexadecimal.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_20 {

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
                System.err.println("Invalid input. Try again.");
            }
        } while (!valid);

        String hexString = Integer.toHexString(userNum);
        try {
            long hexLong = Long.parseLong(hexString);
            System.out.printf("Hexadecimal equivalent of %d is: %d\n", userNum, hexLong);

        } catch (NumberFormatException nFormatException) {
            System.out.printf("Hexadecimal equivalent of %d is: %s\n", userNum, hexString);
        }
    }
}
