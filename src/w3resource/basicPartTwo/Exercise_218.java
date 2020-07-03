package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Computes the radius and the central coordinate (x, y) of a circle     #
// #                     which is constructed by three given points on the plane surface.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 03, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_218 {

    private static Scanner scanner = new Scanner(System.in);

    private static double readCoordinateValue(String inputMess) {
        boolean isValid = false;
        double cordVal = 0;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                cordVal = scanner.nextDouble();
                isValid = true;

            } catch (InputMismatchException iMe) {
                System.err.println("[INVALID__INPUT]: Must be an integer");
                scanner.nextLine();             // clear input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-OPENING__SCANNER]: ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();             // clear input stream.

                System.out.println("[DONE]");
            }
        }
        return cordVal;
    }


    public static void main(String[] args) {

        double x1 = readCoordinateValue("Enter x1 coordinate: ");
        double y1 = readCoordinateValue("Enter y1 coordinate: ");
        double x2 = readCoordinateValue("Enter x2 coordinate: ");
        double y2 = readCoordinateValue("Enter y2 coordinate: ");
        double x3 = readCoordinateValue("Enter x3 coordinate: ");
        double y3 = readCoordinateValue("Enter y3 coordinate: ");

        double A = x2 - x1;
        double B = y2 - y1;
        double p = (y2 * y2 - y1 * y1 + x2 * x2 - x1 * x1) / 2;
        double C = x3 - x1;
        double D = y3 - y1;
        double q = (y3 * y3 - y1 * y1 + x3 * x3 - x1 * x1) / 2;

        double X = (D * p - B * q) / (A * D - B * C);
        double Y = (A * q - C * p) / (A * D - B * C);

        double radius = Math.sqrt(Math.pow(X - x1, 2.0) + Math.pow(Y - y1, 2.0));

        System.out.printf("%nRadius and the central coordinate: %.3f (%.3f %.2f)%n", radius, X, Y);
    }

}
