// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.33 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_33 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weight (in pounds): ");
        int weightInPounds = input.nextInt();

        System.out.print("Enter your height (in inches): ");
        int heightInInches = input.nextInt();

        float BMI = (weightInPounds * 703) / (heightInInches * heightInInches);

        System.out.printf("Your BMI is: %f\n", BMI);

        if (BMI < 18.5)
            System.out.println("You're Underweight.");
        if (BMI >= 18.5 && BMI <= 24.9)
            System.out.println("You're Normal.");
        if (BMI >= 25 && BMI <= 29.9)
            System.out.println("You're Overweight.");
        if (BMI >= 30)
            System.out.println("You're Obese.");

    }
}
