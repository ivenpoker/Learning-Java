package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Converts fahrenheit temperature to a celsius temperature.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_1 {

    private static final Scanner input = new Scanner(System.in);

    private static double readUserInput(String inputMess) {
        boolean inputValid = false;
        double userTempVal = 0.0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userTempVal = input.nextDouble();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userTempVal;
    }

    private static double toCelsius(double fahrenheitTemp) {
        return (fahrenheitTemp - 32) * (5.0 / 9);
    }

    public static void main(String[] args) {

        double fahrenheitTemp = readUserInput("Enter fahrenheit temperature: ");
        System.out.printf("Celsius equivalent: %.2f%n", toCelsius(fahrenheitTemp));
    }

}
