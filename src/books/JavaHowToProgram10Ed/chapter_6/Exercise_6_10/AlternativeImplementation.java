package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_10;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final double INPUT_END_VALUE = 0.0;
    private static final Scanner input = new Scanner(System.in);


    public static int roundToInteger(double number) {
        return (int) Math.floor(number + 0.5);
    }

    public static double roundToTenths(double number) {
        return Math.floor(number * 10 + 0.5) / 10;
    }

    public static double roundToHundredths(double number) {
        return Math.floor(number * 100 + 0.5) / 100;
    }

    public static double roundsToThousandths(double number) {
        return Math.floor(number * 1000 + 0.5) / 1000;
    }

    public static double readUserNumber(String message) {
        System.out.print(message);
        return input.nextDouble();
    }

    public static void main(String[] args) {
        double userVal;
        do {
            userVal = readUserNumber("Enter a double value to round [0 to stop]: ");
            if (userVal != INPUT_END_VALUE) {
                int intVal = roundToInteger(userVal);
                double tenthsVal = roundToTenths(userVal);
                double hundredthsVal = roundToHundredths(userVal);
                double thousandthsVal = roundsToThousandths(userVal);

                // display the computed values
                System.out.printf("Original value was '%.2f' and rounded value is: %d%n", userVal, intVal);
                System.out.printf("Original value was '%.2f' and rounded value is: %f [tenths]%n", userVal, tenthsVal);
                System.out.printf("Original value was '%.2f' and rounded value is: %f [hundredths]%n",
                        userVal, hundredthsVal);
                System.out.printf("Original value was '%.2f' and rounded value is: %f [thousandths]%n",
                        userVal, thousandthsVal);
            }
        } while (userVal != INPUT_END_VALUE);
    }
}
