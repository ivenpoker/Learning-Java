package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_32;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    public static class Point {
        public final double xCord;
        public final double yCord;

        public Point(double xCord, double yCord) {
            this.xCord = xCord;
            this.yCord = yCord;
        }
    }

    public static Point obtainPointFromUser(String message) {
        System.out.print(message);
        double xCord = input.nextDouble();
        double yCord = input.nextDouble();

        return new Point(xCord, yCord);
    }

    public static double computeDistanceBetweenPoints(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow(pointA.xCord - pointA.xCord, 2) + Math.pow(pointA.yCord - pointB.yCord, 2));
    }

    public static void main(String[] args) {
        Point pointA = obtainPointFromUser(" Enter first point coordinates [as: x y]: ");
        Point pointB = obtainPointFromUser("Enter second point coordinates [as: x y]: ");

        System.out.printf("Distance between points: %.2f\n%n", computeDistanceBetweenPoints(pointA, pointB));

    }

}
