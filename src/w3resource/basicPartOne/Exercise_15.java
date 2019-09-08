package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Swap two variables.                                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_15 {

    public static void main(String[] args) {
        int intA = 0;
        int intB = 0;

        Scanner input = new Scanner(System.in);
        boolean valid = false;

        do {
            try {
                System.out.print("Enter first integer: ");
                intA = input.nextInt();
                valid = true;

            } catch (InputMismatchException inputExc) {
                input.nextLine();           // clear input stream
                System.err.println("Invalid input");
            }
        } while (!valid);

        valid = false;

        do {
            try {
                System.out.print("Enter second integer: ");
                intB = input.nextInt();
                valid = true;

            } catch (InputMismatchException inputExc) {
                input.nextLine();           // clear input stream
                System.err.println("Invalid input");
            }
        } while (!valid);

        System.out.println();

        System.out.println("Before swapping....");
        System.out.println("First integer : " + intA);
        System.out.println("Second integer: " + intB);

        System.out.println();

        int temp = intA;
        intA = intB;
        intB = temp;

        System.out.println("After swapping...");
        System.out.println("First integer : " + intA);
        System.out.println("Second integer: " + intB);

    }

    private static void tryModifying(String name) {
        name = "King Kong";
    }
}
