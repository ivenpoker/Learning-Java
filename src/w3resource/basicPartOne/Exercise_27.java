package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts octal number to hexadecimal number.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_27 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String octalNum;
        String hexNum;
        int decNum = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Input an octal number: ");
                octalNum = input.nextLine().trim();

                decNum = Integer.parseInt(octalNum, 8);
                hexNum = Integer.toHexString(decNum);

                System.out.printf("Equivalent hexadecimal number: %s", hexNum);
                valid = true;


            } catch (NoSuchElementException noSuchElementException) {
                input.nextLine();       // clear input stream.
                System.err.println("No line provide. Please, input octal number.");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner for input stream closed. Terminating...");
                System.exit(1);

            } catch (NumberFormatException numberFormatException) {
                input.nextLine();       // clear input stream.
                System.err.println("Error while processing input. Please, input octal number.");
            }
        } while (!valid);
    }
}
