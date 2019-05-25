// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.16 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 25/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_16;

import java.util.Scanner;

public class HearRateTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = input.next();

        System.out.print("Enter your last name: ");
        String lastName  = input.next();

        System.out.print("Enter your birth date (mm dd yy): ");
        int month = input.nextInt();
        int day   = input.nextInt();
        int year  = input.nextInt();

        HeartRates userHeartRate = new HeartRates(firstName, lastName, month, day, year);
        System.out.println("----------------------------------------------");
        System.out.printf("Name: %s %s\n", userHeartRate.getFirstName(), userHeartRate.getLastName());
        System.out.printf("Age : %d\n", userHeartRate.computeAge());
        System.out.printf("Birth date: %d/%d/%d [mm/dd/yyyy]\n",
                userHeartRate.getMonth(), userHeartRate.getDay(), userHeartRate.getYear());
        System.out.printf("Maximum Heart Rate: %d\n", userHeartRate.maximumHeartRate());
        System.out.printf("Target Heart Rate : %.2f\n", userHeartRate.computeTargetHeartRate());
    }
}
