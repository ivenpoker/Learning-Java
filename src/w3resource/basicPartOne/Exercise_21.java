package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts decimal number to octal.                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_21 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userNum = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Enter decimal number: ");
                userNum = input.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();       // clear input stream, discarding data.
                System.err.println("Invalid input. Please, try again.");
            }
        } while (!valid);

        String octalString = Integer.toOctalString(userNum);
        try {
            long octalLong = Long.parseLong(octalString);
            System.out.printf("Octal equivalent of %d: %d", userNum, octalLong);
        } catch (NumberFormatException numberFormatException) {
            System.out.printf("Octal equivalent of %d: %s", userNum, octalString);
        }
    }
}

