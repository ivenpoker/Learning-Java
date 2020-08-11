package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Reads in two floating-point numbers and tests whether they are the  #
// #                     same up to the three decimal places.                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_6 {

    private static final Scanner input = new Scanner(System.in);

    private static float obtainFloatFromUser(String inputMess) {
        boolean inputValid = false;
        float userInput = 0.0f;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextFloat();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[input_error]: %s%n", iMe.getMessage());
                input.nextLine();                   // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static boolean floatsSameTill3DecimalPlaces(float flt1, float flt2) {
        String strFlt1 = String.format("%.3f", flt1);
        String strFlt2 = String.format("%.3f", flt2);
        return strFlt1.equals(strFlt2);
    }

    public static void main(String[] args) {

        float float1 = obtainFloatFromUser("Enter first float value: ");
        float float2 = obtainFloatFromUser("Enter second float value: ");

        System.out.printf("Are floats same up to three decimal places: %s%n",
                floatsSameTill3DecimalPlaces(float1, float2) ? "YES" : "NO");
    }

}
