package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Compute the distance between two points on the surface of earth. #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 9, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_36 {

    private static final Scanner input = new Scanner(System.in);
    private static final double EARTH_RADIUS = 6371.01;

    private static class Point {
        private double x;
        private double y;

        public Point(double xCord, double yCord) {
            this.x = xCord;
            this.y = yCord;
        }

        public double getX() { return this.x; }
        public double getY() { return this.y; }
    }

    private static Point getPointFromUser(String message) {
        Point pointA = null;
        boolean valid = false;

        do {
            try {
                System.out.print(message);
                String[] data = input.nextLine().trim().split(" ");

                if (data.length != 2)
                    throw new IllegalArgumentException("Invalid number of arguments. Try again.");

                double valA = Double.parseDouble(data[0].trim());
                double valB = Double.parseDouble(data[1].trim());

                pointA = new Point(valA, valB);
                valid = true;

            } catch (NumberFormatException numberFormatException) {
                input.nextLine();               // clear input stream.
                System.err.println("Invalid input format. Make sure they're integers. ");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner has been closed. Terminating...");
                break;

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("No line found. Please, try again.");

            } catch (IllegalArgumentException illegalArgumentException) {
                input.nextLine();           // clear input stream.
                System.err.println(illegalArgumentException.getMessage());
            }
        } while (!valid);

        return pointA;
    }

    private static double computeDistanceBetweenPoints(Point pointA, Point pointB) {
        return EARTH_RADIUS * Math.acos(Math.sin(pointA.getX()) * Math.sin(pointB.getX()) +
                Math.cos(pointA.getX()) * Math.cos(pointB.getX())* Math.cos(pointA.getY() - pointB.getY()));
    }

    public static void main(String[] args) {

        Point pointA = getPointFromUser("Enter first coordinate point (as x y) : ");
        Point pointB = getPointFromUser("Enter second coordinate point (as x y): ");

        System.out.printf("Distance between points: %.2f\n",
                computeDistanceBetweenPoints(pointA, pointB));

    }
}
