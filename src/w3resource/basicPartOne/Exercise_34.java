package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Computes the area of a hexagon.                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_34 {

    private static double computeAreaOfHexagon(int sideLength) {
        return (6 * Math.pow(sideLength, 2) / (4 * Math.tan(Math.PI / 6)));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sideLength = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Enter side length for hexagon: ");
                sideLength = input.nextInt();

                if (sideLength <= 0) {
                    throw new IllegalArgumentException("Invalid input. Please provide positive side length");
                }
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();               // clear input stream.
                System.err.println("Invalid input. Please try again.");

            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        } while (!valid);

        System.out.printf("Area of Hexagon: %.2f\n", computeAreaOfHexagon(sideLength));

    }

}
