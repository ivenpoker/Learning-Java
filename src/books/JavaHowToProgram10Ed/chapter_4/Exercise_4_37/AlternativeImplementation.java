package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_37;

import java.util.Scanner;

public class AlternativeImplementation {

    private static int findFactorial(int someNum) {
        int fact = 1;                   // default factorial value (if 'someNum' was zero)
        if (someNum > 0) {
            while (someNum > 0) {       // Perform factorial computation if user specified a number > 0.
                fact *= someNum;
                someNum -= 1;
            }
        }
        return fact;
    }

    private static double findEstimationOfE(int maxSeriesCnt) {
        double e = 1.0;             // default value of E
        int cnt = 1;                // counter to know how many times to do addition in series
        while (cnt <= maxSeriesCnt) {
            e += 1.0 / findFactorial(cnt++);    // perform series addition and increment appropriate variables.
        }
        return e;
    }

    private static double computEtoTheX(int xVal, int maxSeriesCnt) {
        double e = 1.0;             // default value of E
        int cnt = 1;                // counter to know how many times to do addition in series
        int toPow = 1;              // track, to know 'to what power to raise' at the moment in computation
        while (cnt <= maxSeriesCnt) {
            e += Math.pow(xVal, toPow++) / findFactorial(cnt++);    // perform series addition and increment appropriate variables
        }
        return e;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Factorial program test

        System.out.print("Enter number: ");
        int userNum = input.nextInt();

        while (userNum < 0) {
            System.out.print("Enter valid number [must be >= 0]: ");
            userNum = input.nextInt();
        }
        System.out.printf("Factorial of %d is: %d\n", userNum, findFactorial(userNum));

        // Constant E estimation

        System.out.print("Enter max additions for approximation: ");
        int userMax = input.nextInt();

        while (userMax < 0) {
            System.out.print("Enter max additions for approximation [must be > 0]: ");
            userMax = input.nextInt();
        }
        System.out.printf("Approximation i: %.2f%n", findEstimationOfE(userMax));

        // Test program for computing e^x

        System.out.print("Enter the value of x (in e^x): ");
        int userX = input.nextInt();

        System.out.print("Enter max additions for approximation [must be > 0]: ");
        userMax = input.nextInt();

        while (userMax < 0) {
            System.out.print("Enter max additions for approximation [must be > 0]: ");
            userMax = input.nextInt();
        }

        System.out.printf("Approximation of e^x: %.2f%n", computEtoTheX(userX, userMax));
    }

}
