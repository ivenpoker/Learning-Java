package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Accepts two double variables and test if both are strictly
// #                     between 0 and 1 and false otherwise.
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.InputMismatchException;
import java.util.stream.DoubleStream;
import java.util.Scanner;

public class Exercise_153 {

    private static Scanner scanner = new Scanner(System.in);

    private static double obtainUserData(String inputMessage) {
        double userData = 0.0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextDouble();
                isValid = true;

            } catch (InputMismatchException inputExc) {
                System.err.println("Oops, invalid input.");

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        return userData;
    }

    private static boolean inRange(int low, double val, int high, boolean inclusive) {
        if (inclusive) {
            return low <= val && val <= high;
        } else {
            return low < val && val > high;
        }
    }

    private static boolean isTestValid(double[] data) {
        return inRange(0, data[0], 1 , true) &&
                inRange(0, data[1], 1, true);
    }

    public static void main(String[] args) {
        double[] mainData = new double[2];
        int[] temp = {0};
        mainData = DoubleStream.of(mainData).map((val) -> {
            val = obtainUserData(String.format("Enter double value #%d: ", temp[0] + 1
            ));
            temp[0]++;
            return val;
        }).toArray();

        System.out.printf("Does values pass test: [%s]\n",
                isTestValid(mainData) ? "YES" : "NO");

    }
}
