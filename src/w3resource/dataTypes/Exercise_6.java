package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Computes the body mass index (BMI).                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_6 {

    private static final Scanner input = new Scanner(System.in);

    private static double obtainDataFromUser(String inputMess) {
        boolean inputValid = false;
        double inputVal = 0.0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                inputVal = input.nextDouble();

                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();           // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return inputVal;
    }

    private static double computeBMI(double weightInPounds, double heightInInches) {
        return weightInPounds * 0.45359237 / (heightInInches * 0.0254 * heightInInches * 0.0254);
    }

    public static void main(String[] args) {

        double weightInPounds = obtainDataFromUser("Enter weight in pounds: ");
        double heightInInches = obtainDataFromUser("Enter height in inches: ");

        System.out.printf("BMI: %.2f%n", computeBMI(weightInPounds, heightInInches));

    }

}
