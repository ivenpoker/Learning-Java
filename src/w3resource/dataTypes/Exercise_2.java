package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Converts Inches to Metres.                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_2 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final double METER_DIVIDEND = 39.37;

    private static double readUserInchValue(String inputMess) {
        boolean inputValid = false;
        double inchValue = 0.0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                inchValue = scanner.nextDouble() ;

                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return inchValue;
    }

    private static double convertInchToMetre(double inchVale) {
        return inchVale / METER_DIVIDEND;
    }

    public static void main(String[] args) {

        double userInchValue = readUserInchValue("Enter your inch value: ");
        System.out.printf("Metre equivalent for %.2f inches: %.2f%n", userInchValue,
                convertInchToMetre(userInchValue));

    }

}
