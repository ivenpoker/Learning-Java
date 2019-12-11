package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Uses Euclid's algorithm to compute the greatest common       #
// #                     divisor of two positive given integers.                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_157 {

    private static Scanner scanner = new Scanner(System.in);

    private static int[] obtainUserData(String inputMessage) {
        boolean isValid = false;
        int[] userData = new int[2];

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                String[] input = scanner.nextLine().trim().split(" ");

                if (input.length != 2) {
                    throw new IllegalArgumentException(String.format("Invalid number of arguments. Expected 2, got %d",
                            input.length));
                }
                userData[0] = Integer.parseInt(input[0].trim());
                userData[1] = Integer.parseInt(input[1].trim());

                isValid = true;

            } catch (InputMismatchException inputExc) {
                System.err.println("Oops, invalid input detected!");

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        return userData;
    }

    private static int euclid(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        }
        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }
        if (x % y == 0) {
            return y;
        } else {
            return euclid(y, x % y);
        }
    }

    public static void main(String[] args) {
        int[] mainData = obtainUserData("Enter two numbers (separated by space): ");
        System.out.printf("Result: %d\n", euclid(mainData[0], mainData[1]));
    }
}
