package w3resource.basicPartOne;


// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts hexadecimal number to decimal number.                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_29 {

    private static int hexToDecimal(String hexString) {
        String digits = "0123456789ABCDEF";
        hexString = hexString.toUpperCase();

        int val = 0;
        for (int i = 0; i < hexString.length(); i++) {
            char c = hexString.charAt(i);
            int d = digits.indexOf(c);
            val = 16 * val + d;
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String hexDecNum;
        int decNum;
        boolean valid = false;

        do {
            try {
                System.out.print("Enter a hexadecimal number: ");
                hexDecNum = input.nextLine().trim();

                decNum = hexToDecimal(hexDecNum);

                System.out.printf("Equivalent decimal number is: %s\n", decNum);
                valid = true;

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("No line input provided. Please, enter a hex number.");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner has been closed. Terminating...");
                break;

            }
        } while (!valid);

    }
}
