package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Computes and prints the sum of two given integers (more than or equal #
// #                     to zero). If given integers or the sum have more than 80 digits,      #
// #                     print "overflow".                                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 10, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise_220 {

    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_DIGIT_SIZE = 80;
    private static final int EXIT_FAILURE = 1;

    private static BigInteger obtainUserInteger(String inputMess) {
        boolean isValid = false;
        BigInteger userInt = null;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                String userInput = scanner.nextLine().trim();
                userInt = new BigInteger(userInput);

                isValid = true;

            } catch (NumberFormatException nFe) {
                System.out.printf("[INVALID_INPUT]:  %s%n", nFe.getMessage());

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-OPENING__SCANNER] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();                      // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[CORE__ERROR]: %s%n", exc.getMessage());
                scanner.nextLine();                     // clear input stream.
            }
        }
        return userInt;
    }

    public static void main(String[] args) {

        BigInteger userFirstInt = obtainUserInteger("Enter first integer: ");

        // Validate user first input
        if (userFirstInt.toString().length() > MAX_DIGIT_SIZE) {
            System.out.printf("Oops, overflow [max digits: %d]%n", MAX_DIGIT_SIZE);
            System.exit(EXIT_FAILURE);
        }

        BigInteger userSecondInt = obtainUserInteger("Enter second integer: ");

        // Validate user second input
        if (userFirstInt.toString().length() > MAX_DIGIT_SIZE) {
            System.out.printf("Oops, overflow [max digits: %d%n]", MAX_DIGIT_SIZE);
            System.exit(EXIT_FAILURE);
        }

        // Sum the two Big integers
        BigInteger results = userFirstInt.add(userSecondInt);

        // Validate the results of the sum
        if (results.toString().length() > MAX_DIGIT_SIZE) {
            System.out.println("Oops, overflow");
        } else {
            System.out.printf("Results: %s%n", results);
        }

    }

}







































