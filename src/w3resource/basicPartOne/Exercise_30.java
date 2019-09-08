package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts hexadecimal number to octal number.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_30 {

    private static int hexToDecimal(String hexString) {
        String digits = "0123456789ABCDE";
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
        int decNum = 0;
        int i = 1;
        int j = 0;
        int[] octalNum = new int[100];
        boolean valid = false;

        do {
            try {
                System.out.print("Enter a hexadecimal number: ");
                String hexNum = input.nextLine().trim();

                // convert hexadecimal to decimal
                decNum = hexToDecimal(hexNum);

                while (decNum != 0) {
                    octalNum[i++] = decNum % 8;
                    decNum = decNum / 8;
                }
                System.out.print("Equivalent of octal number is: ");
                for (j = i-1; j > 0; j--) {
                    System.out.print(octalNum[j]);
                }
                System.out.print("\n");
                valid = true;

            } catch (NoSuchElementException noSuchElementException) {
                input.nextLine();       // don't really need this, but it doesn't hurt... :)
                System.err.println("No input provide in line. Please, enter hexadecimal number.");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner has been closed. Terminating...");
                break;
            }
        } while (!valid);
    }
}
