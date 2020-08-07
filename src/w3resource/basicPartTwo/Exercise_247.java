package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Accepts three integers and checks whether sum of the first two given  #
// #                     integers is greater than the third one. Three integers are in the     #
// #                     interval [-2^31, 2^31 ].                                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : August 07, 2020                                                       #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Exercise_247 {

    private static final Scanner input = new Scanner(System.in);
    private static final long LOWER_BOUND = (long) Math.pow(-2, 31);
    private static final long UPPER_BOUND = (long) Math.pow(2, 31);

    private static boolean inRange(long lower, long val, long upper) {
        return lower <= val && val <= upper;
    }

    private static int readUserInteger(String inputMess, long lower, long upper) {
        boolean inputValid = false;
        int userInt = -1;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (!inRange(lower, userInt, upper)) {
                    throw new InputMismatchException(
                            String.format("please enter integer value in range [%d, %d]", lower, upper));
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                String mess = exc.getMessage();

                if (!Objects.isNull(mess) && !mess.isEmpty()) {
                    System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
                } else {
                    System.err.println("[MAIN_EXCEPTION]: Something 'bad' happened");
                }
            }
        }
        return userInt;
    }

    private static boolean doCheck(int intA, int intB, int intC) {
        return  (intA + intB) > intC;
    }

    public static void main(String[] args) {

        int intA = readUserInteger(String.format("Enter first integer (in range [%d, %d]): ",
                LOWER_BOUND, UPPER_BOUND), LOWER_BOUND, UPPER_BOUND);

        int intB = readUserInteger(String.format("Enter second integer (in range [%d, %d]): ",
                LOWER_BOUND, UPPER_BOUND), LOWER_BOUND, UPPER_BOUND);

        int intC = readUserInteger(String.format("Enter third integer (in range [%d, %d]): ",
                LOWER_BOUND, UPPER_BOUND), LOWER_BOUND, UPPER_BOUND);

        System.out.printf("Check whether (a + b) is greater than C: %s%n",
                doCheck(intA, intB, intC) ? "YES" : "NO");
    }

}
