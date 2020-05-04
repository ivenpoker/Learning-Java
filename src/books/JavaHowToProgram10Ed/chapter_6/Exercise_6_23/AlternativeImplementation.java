package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_23;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    private static class ThreeDouble {
        public double dbA;
        public double dbB;
        public double dbC;

        public ThreeDouble(double dbA, double dbB, double dbC) {
            this.dbA = dbA;
            this.dbB = dbB;
            this.dbC = dbC;
        }
    }

    public static ThreeDouble readUserData(String inputMessage) {
        System.out.print(inputMessage);
        double valA = input.nextDouble();
        double valB = input.nextDouble();
        double valC = input.nextDouble();

        return new ThreeDouble(valA, valB, valC);
    }

    public static double minimum3(double valA, double valB, double valC) {
        return Math.min(valA, Math.min(valB, valC));
    }

    public static void main(String[] args) {
        ThreeDouble values = readUserData("Enter 2 double values [as: a b c]: ");
        System.out.printf("Max of three doubles is: %.2f%n", minimum3(values.dbA, values.dbB, values.dbC));
    }
}

