package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Prints multiplication table of a number.                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 4, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_7 {

    private static void printMultiplicationTable(int num, int upper) {
        for (int i = 1; i <= upper; i++)
            System.out.printf("%d x %d = %d\n", num, i, (num * i));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;        // user number
        boolean cont = true;

        do {
            try {
                System.out.print("Enter a number to print table: ");
                num = input.nextInt();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();       // clear data in input stream.
                System.err.println("Invalid input entered.");
            }
        } while (cont);

        // print table to stdin (console)

        printMultiplicationTable(num, 10);

    }

}
