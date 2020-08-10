package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Converts minutes into a number of years and days.                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Exercise_4 {

    private static final Scanner input = new Scanner(System.in);
    private static final int MINS_IN_DAY = 1440;
    private static final int DAYS_IN_YEAR = 365;    // exclude leap years.

    private static long obtainUserNumberOfMinutes(String inputMess) {
        boolean inputValid = false;
        long numOfMinutes = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                numOfMinutes = input.nextInt();

                if (numOfMinutes < 0) {
                    throw new InputMismatchException("please enter number > 0");
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return numOfMinutes;
    }

    private static List<Long> processMinutes(long mainMinutes) {
        List<Long> dateInfo = new ArrayList<>();
        long days = 0;
        long years = 0;

        while (mainMinutes >= MINS_IN_DAY) {
            mainMinutes -= MINS_IN_DAY;
            days += 1;
        }

        while (days >= DAYS_IN_YEAR) {
            years += 1;
            days -= DAYS_IN_YEAR;
        }
        dateInfo.add(years);
        dateInfo.add(days);

        return dateInfo;
    }

    private static void displayInfo(List<Long> dateInfo, Long mins) {
        System.out.printf("%d minutes is approximately %d years and %d days.%n", mins,
                dateInfo.get(0), dateInfo.get(1));
    }

    public static void main(String[] args) {

        long minutes = obtainUserNumberOfMinutes("Enter minutes count: ");
        List<Long> dateInfo = processMinutes(minutes);

        displayInfo(dateInfo, minutes);
    }
}
