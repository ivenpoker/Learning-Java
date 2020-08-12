package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the number of days in a month.                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_7 {

    private static final Scanner input = new Scanner(System.in);
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 12;

    private static boolean inRange(int lower, int val, int upper) {
        return lower <= val && val <= upper;
    }

    private static int obtainMonthNumberFromUser(String inputMess, int lower, int upper) {
        boolean validInput = false;
        int userMonth = 0;

        while (!validInput) {
            try {
                System.out.print(inputMess);
                userMonth = input.nextInt();

                if (!inRange(lower, userMonth, upper)) {
                    throw new InputMismatchException(
                            String.format("please enter input in range [%d, %d]", lower, upper));
                }
                validInput = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();           // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());

            }
        }
        return userMonth;
    }

    private static MonthName getMonthNameFromMonthNumber(int monthNum) {
        switch (monthNum) {
            case 1: return MonthName.JANUARY; 
            case 2: return MonthName.FEBRUARY; 
            case 3: return MonthName.MARCH; 
            case 4: return MonthName.APRIL; 
            case 5: return MonthName.MAY; 
            case 6: return MonthName.JUNE; 
            case 7: return MonthName.JULY; 
            case 8: return MonthName.AUGUST; 
            case 9: return MonthName.SEPTEMBER; 
            case 10: return MonthName.OCTOBER; 
            case 11: return MonthName.NOVEMBER; 
            case 12: return MonthName.DECEMBER; 
            default:
                return MonthName.INVALID_MONTH;
        }
    }

    public static void main(String[] args) {

        int monthNum = obtainMonthNumberFromUser(String.format("Enter month number in range [%d, %d]: ", LOWER_BOUND,
                                UPPER_BOUND), LOWER_BOUND, UPPER_BOUND);
        int year = obtainMonthNumberFromUser("Enter year: ", 2000, 2020);

        MonthName monthName = getMonthNameFromMonthNumber(monthNum);
        System.out.printf("%s %d has %d days", monthName, year, monthName.days());
    }
}

enum MonthName {
    JANUARY("January", 31),
    FEBRUARY("February", 28),
    MARCH("March", 31),
    APRIL("April", 30),
    MAY("May", 31),
    JUNE("June", 30),
    JULY("July", 31),
    AUGUST("August", 31),
    SEPTEMBER("September", 30),
    OCTOBER("October", 31),
    NOVEMBER("November", 30),
    DECEMBER("December", 31),
    INVALID_MONTH("[invalid_month]", 1);

    private String monthName;
    private int monthNumDays;

    MonthName(String monthName, int monthNumDays) {
        this.monthName = monthName;
        this.monthNumDays = monthNumDays;
    }

    public int days() {
        return this.monthNumDays;
    }

    @Override
    public String toString() {
        return this.monthName;
    }
}
