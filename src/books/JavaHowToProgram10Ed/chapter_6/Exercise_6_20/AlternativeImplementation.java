package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_20;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    private static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static double obtainRadiusFromUser(String inputMessage) {
        System.out.print(inputMessage);
        return input.nextDouble();
    }

    public static void main(String[] args) {

        double circleRadius = obtainRadiusFromUser("Enter radius for the circle: ");
        System.out.printf("Area of circle is: %.4f%n", circleArea(circleRadius));

    }
}
