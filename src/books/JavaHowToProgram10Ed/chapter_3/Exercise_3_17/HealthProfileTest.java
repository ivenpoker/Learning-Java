// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.17 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 25/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_17;

import java.util.Scanner;

public class HealthProfileTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = input.next();

        System.out.print("Enter your last name: ");
        String lastName = input.next();

        System.out.print("Enter your gender: ");
        String gender = input.next();

        System.out.print("Enter your birth date [mm dd yyyy]: ");
        int month = input.nextInt();
        int day   = input.nextInt();
        int year  = input.nextInt();

        System.out.print("Enter your height (in cm): ");
        int height = input.nextInt();

        System.out.print("Enter your weight (in kg): ");
        int weight = input.nextInt();

        HealthProfile hp = new HealthProfile(firstName, lastName, gender,
                month, day, year, height, weight);

        System.out.println("--------------------------------------------");
        System.out.printf("Name is: %s %s\n", hp.getFirstName(), hp.getLastName());
        System.out.printf("Gender : %s\n", hp.getGender());
        System.out.printf("Birth date: %d/%d/%d [mm/dd/yyyy]", hp.getMonth(), hp.getDay(), hp.getYear());
        System.out.printf("Age: %d\n", hp.computeAge());
        System.out.printf("Height: %d cm\n", hp.getHeight());
        System.out.printf("Weight: %d cm\n", hp.getWeight());
        System.out.printf("Maximum heart rate: %d\n", hp.computeMaximumHeartRate());
        System.out.printf("Target heart rate: %.2f", hp.computeTargetHeartRate());
        System.out.printf("BMI: %.2f\n", hp.computeBMI());
    }
}
