package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Takes a number from the user between 1 and 7 and displays the name  #
// #                     of the weekday.                                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_5 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 7;

    private static final Scanner input = new Scanner(System.in);

    private static boolean inRange(int lower, int val, int upper) {
        return lower <= val && val <= upper;
    }

    private static int obtainUserInput(String inputMess, int lower, int upper) {
        boolean inputValid = false;
        int userVal = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userVal = input.nextInt();

                if (!inRange(lower, userVal, upper)) {
                    throw new InputMismatchException(
                            String.format("please number must be in [%d, %d]%n", lower, upper));
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userVal;
    }

    private static DayName getDayNameFromDayNumber(int dayNumber) {
        switch (dayNumber) {
            case 1: return DayName.MONDAY;
            case 2: return DayName.TUESDAY;
            case 3: return DayName.WEDNESDAY;
            case 4: return DayName.THURSDAY;
            case 5: return DayName.FRIDAY;
            case 6: return DayName.SATURDAY;
            case 7: return DayName.SUNDAY;
            default:
                return DayName.INVALID_DAY;
        }
    }

    public static void main(String[] args) {

        int userInput = obtainUserInput(String.format("Enter an integer in range [%d, %d]: ", LOWER_BOUND, UPPER_BOUND),
                            LOWER_BOUND, UPPER_BOUND);

        System.out.printf("Day #%d name: %s%n", userInput, getDayNameFromDayNumber(userInput));
    }
}

enum DayName {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday"),
    INVALID_DAY("[invalid_day]");

    private String dayName;

    DayName(String dayName) {
        this.dayName = dayName;
    }


    @Override
    public String toString() {
        return this.dayName;
    }
}
