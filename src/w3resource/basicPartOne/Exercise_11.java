package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Find the area and perimeter of a circle.                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 4, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_11 {

    private static double computeAreaOfCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static double computePerimeterOfCircle(double radius) {
        // this is basically the circumference of a circle
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double radius = 0.0;    // radius of circle.
        boolean cont = true;

        do {
            try {
                System.out.print("Enter radius of the circle: ");
                radius = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();       // clear data from input stream (not needed)
                System.err.println("Invalid input. Try again.");

            } catch (Exception exc) {
                System.err.println("Terminating...");
                exc.printStackTrace();
            }
        } while (cont);

        // Print info to console

        System.out.printf("Area of circle: %.1f\n", computeAreaOfCircle(radius));
        System.out.printf("Perimeter of circle: %.1f\n", computePerimeterOfCircle(radius));
    }
}
