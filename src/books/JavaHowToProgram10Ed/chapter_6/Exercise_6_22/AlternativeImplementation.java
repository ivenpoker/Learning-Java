package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_22;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final int MAX_LINE_LENGTH = 50;
    private static enum ConversionType {TO_CELSIUS, TO_FAHRENHEIT, NONE}

    private static final Scanner input = new Scanner(System.in);

    public static double celsius(double fahrenheit) {
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    public static double fahrenheit(double celsius) {
        return 9.0 / 5.0 * celsius + 32;
    }

    public static void printLine(int times, char ch) {
        for (int i = 0; i < times; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static int displayInstructions() {
        System.out.printf("============[ Temperature Converter ]=============%n");
        System.out.println("1. Convert to Celsius");
        System.out.println("2. Convert to Fahrenheit");
        System.out.println("3. Exit application");

        printLine(MAX_LINE_LENGTH, '-');

        System.out.print("Enter your choice: ");

        return input.nextInt();
    }

    public static void main(String[] args) {


        boolean cont = true;

        while (cont) {
            int userChoice = displayInstructions();
            ConversionType conversionType = (userChoice == 1) ? ConversionType.TO_CELSIUS :
                                (userChoice == 2) ? ConversionType.TO_FAHRENHEIT : ConversionType.NONE;

            printLine(MAX_LINE_LENGTH, '-');
            switch (conversionType) {
                case TO_CELSIUS:
                    System.out.print("Enter fahrenheit temperature: ");
                    double fahrenheit = input.nextDouble();

                    printLine(MAX_LINE_LENGTH, '-');

                    System.out.printf("Celsius equivalent: %.2f%n", celsius(fahrenheit));
                    break;

                case TO_FAHRENHEIT:
                    System.out.print("Enter celsius temperature: ");
                    double celsius = input.nextDouble();

                    printLine(MAX_LINE_LENGTH, '-');

                    System.out.printf("Fahrenheit equivalent: %.2f%n", fahrenheit(celsius));
                    break;

                case NONE:
                    cont = false;
                    break;

                default:
                    printLine(MAX_LINE_LENGTH, '-');
                    System.out.println("[SYSTEM_ERROR]: Invalid application state");
                    cont = false;
                    break;
            }
            if (conversionType != ConversionType.NONE) {
                printLine(MAX_LINE_LENGTH, '-');
            }
            System.out.println();
        }

    }
}
