package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_35;

import java.util.Scanner;

public class AlternativeImplementation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter side A length: ");
        int sideA = input.nextInt();

        while (sideA <= 0) {
            System.out.print("Enter side A length [must be > 0]: ");
            sideA = input.nextInt();
        }

        System.out.print("Enter side B length: ");
        int sideB = input.nextInt();

        while (sideB <= 0) {
            System.out.print("Enter side B length [must be > 0]: ");
            sideB = input.nextInt();
        }

        System.out.print("Enter side C length: ");
        int sideC = input.nextInt();

        while (sideC <= 0) {
            System.out.print("Enter side C length [must be > 0]: ");
            sideC = input.nextInt();
        }

        String triangleInfoMessage = "";

        // Validating side A. We're using the static method 'abs' from the 'Maths' class
        // make sure that the difference between side C and side B is always positive.

        if (sideA < (sideB + sideC) && sideA > (Math.abs(sideC - sideB))) {

            // Since side A is valid, we check side B

            if (sideB < (sideA + sideC) && sideB > (Math.abs(sideA - sideC))) {

                // Since side side B is valid, we validate side C

                if (sideC < (sideA + sideB) && sideC > (Math.abs(sideA - sideB))) {
                    triangleInfoMessage = "Sides represents a triangle";
                } else {
                    triangleInfoMessage = "Invalid side C";
                }
            } else {
                triangleInfoMessage = "Invalid side B";
            }
        } else {
            triangleInfoMessage = "Invalid side A";
        }

        System.out.println(triangleInfoMessage);
    }
}