package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Program to compute the area of a polygon.                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_35 {

    private static double computeAreaOfPolygon(int numSides, int sideLength) {
        return (numSides * Math.pow(sideLength, 2) / (4 * Math.tan(Math.PI / numSides)));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numSides = 0;
        int sideLength = 0;
        boolean valid = false;

        // Get number of sides for polygon.
        do {
            try {
                System.out.print("Enter number of sides for polygon: ");
                numSides = input.nextInt();

                if (numSides <= 0)
                    throw new IllegalArgumentException("Invalid input. Number of sides must be >= 0.");
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();           // clear input stream, discarding data.
                System.err.println("Input invalid. Please, enter number of sides.");

            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        } while (!valid);

        valid = false;              // prepare for next input

        // For a side, we obtain the side length.

        do {
            try {
                System.out.print("Enter side length: ");
                sideLength = input.nextInt();

                if (sideLength <= 0)
                    throw new IllegalArgumentException("Invalid input. Side length must be >= 0.");
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();
                System.err.println("Input invalid. Please, enter side length (>= 0).");

            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        } while (!valid);

        System.out.printf("Area of polygon: %.2f\n", computeAreaOfPolygon(numSides, sideLength));
    }
}
