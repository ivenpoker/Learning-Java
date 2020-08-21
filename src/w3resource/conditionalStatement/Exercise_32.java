package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Accepts two floating point numbers and check whether they are the   #
// #                     same up to two decimal places.                                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_32 {

    private static final Scanner input = new Scanner(System.in);

    private static float obtainUserFloatValue(String inputMess) {
        boolean inputValid = false;
        float userData = 0.0f;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userData = input.nextFloat();

                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();                       // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userData;
    }

    private static boolean floatsAreSame(float fltA, float fltB) {
        return String.format("%.2f", fltA).equals(String.format("%.2f", fltB));
    }


    public static void main(String[] args) {

        float fstFlt = obtainUserFloatValue("Enter first float data: ");
        float sndFlt = obtainUserFloatValue("Enter second float data: ");

        System.out.printf("Are '%.2f' and '%.2f' equal: %s%n",
                fstFlt, sndFlt, floatsAreSame(fstFlt, sndFlt) ? "YES" : "NO");

    }

}
