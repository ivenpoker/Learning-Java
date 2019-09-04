package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Print the area and perimeter of a rectangle.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 4, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_13 {

    private static double computeAreaOfRectangle(double width, double height) {
        return height * width;
    }

    private static double computePerimeterOfRectangle(double width, double height) {
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double height = 0.0;    // height of rectangle
        double width  = 0.0;    // width of rectangle
        boolean cont = true;

        // Obtain rectangle height.

        do {
            try {
                System.out.print("Enter height of rectangle: ");
                height = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();           // clear remaining input in stream if any.
                System.err.println("Invalid input. Try again");

            } catch (Exception exc) {
                System.err.println("Something wrong happened. Terminating....");
                exc.printStackTrace();
                System.exit(1);
            }
        } while (cont);

        cont = true;  // reset 'cont' for next input

        // Obtain rectangle width

        do {
            try {
                System.out.print("Enter width of rectangle: ");
                width = input.nextDouble();
                cont = false;

            } catch (InputMismatchException exc) {
                input.nextLine();
                System.err.println("Invalid input. Try again.");

            } catch (Exception exc) {
                System.err.println("Something wrong happened. Terminating...");
                exc.printStackTrace();
                System.exit(1);
            }
        } while (cont);

        System.out.printf("\nArea of rectangle: %.1f\n", computeAreaOfRectangle(width, height));
        System.out.printf("Perimeter of rectangle: %.1f\n", computePerimeterOfRectangle(width, height));

    }

}
