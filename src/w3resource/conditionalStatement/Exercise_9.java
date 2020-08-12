package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Takes a year from user and prints whether that year is a leap year  #
// #                     or not.                                                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_9 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainYearFromUser(String inputMess) {
        boolean inputValid = false;
        int userYear = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userYear = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userYear;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || ((year % 100 == 0) && (year % 400 == 0)));
    }

    public static void main(String[] args) {

        int userYear = obtainYearFromUser("Enter year to check if leap: ");
        System.out.printf("Is %d a leap year: %s%n", userYear, isLeapYear(userYear) ? "YES" : "NO");
    }

}
