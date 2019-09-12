package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Converts a string to an integer in Java.                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_52 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean isValid = false;

        do {
            try {
                System.out.print("Enter an integer: ");
                userInput = scanner.next().trim();
                isValid = true;

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println(noSuchElementException.getMessage());

            } catch (IllegalStateException illegalStateException) {
                System.err.println(illegalStateException.getMessage());
            }
        } while (!isValid);

        // Let's try converting string to integer
        int intEquivalent = 0;
        try {
            intEquivalent = Integer.parseInt(userInput);
            System.out.printf("Integer value: %d\n", intEquivalent);

        } catch (NumberFormatException numberFormatException) {
            System.out.println("[ERROR] Invalid number --> " + numberFormatException.getMessage());
        }
    }
}
