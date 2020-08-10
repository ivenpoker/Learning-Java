package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Does some basic distance conversions.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_7 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainDataFromUser(String inputMess) {
        boolean validInput = false;
        int userInput = 0;

        while (!validInput) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (userInput < 0) {
                    throw new InputMismatchException("please your input must be > 0");
                }
                validInput = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    public static void main(String[] args) {

        int distanceInMeter = obtainDataFromUser("Enter distance in meters: ");
        int hour = obtainDataFromUser("Enter hour: ");
        int minute = obtainDataFromUser("Enter minute: ");
        int seconds = obtainDataFromUser("Enter seconds: ");

        System.out.printf("Your speed in meters/second: %.8f%n", (double) distanceInMeter / seconds);
        System.out.printf("Your speed in km/hr is: %.8f%n", ((double) distanceInMeter / 1000) * hour);
        System.out.printf("Your speed in miles/hr is: %.8f%n",((double) distanceInMeter / 1609.34) * hour);

    }

}
