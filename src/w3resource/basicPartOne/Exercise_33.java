package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Computes the sum of digits of an integer.                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_33 {

    private static int computeSumOfDigits(String someString) {
        int sum = 0;
        for (int i = 0; i < someString.length(); i++)
            sum += Integer.parseInt("" + someString.charAt(i));
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mainNumber = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Enter some integer: ");
                mainNumber = input.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();           // clear input stream.
                System.err.println("Invalid input. Please, try again.");
            }
        } while (!valid);

        String mainString = Integer.toString(mainNumber);
        System.out.printf("Sum of digits in %d: %d\n", mainNumber, computeSumOfDigits(mainString));
    }
}
