package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Checks if a number is even or odd, prints 1 if the number is even  #
// #                     else prints 0 if the number is odd.                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_50 {

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userNum = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print("Enter a number: ");
                userNum = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Invalid input. Please, try again.");

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Input is exhausted.");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner is closed");
            }
        } while (!isValid);

        if (isEven(userNum)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

}
