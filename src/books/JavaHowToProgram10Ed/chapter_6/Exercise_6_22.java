// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.22 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.util.Scanner;

public class Exercise_6_22 {

    public static double celcius(double fahr) {
        return 5.0 / 9.0 * (fahr - 32);
    }

    public static double fahrenheit(double celsius) {
        return 9.0  / 5.0 * celsius + 32;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("\n\t\t[ === Temperature program === ]\n");
        System.out.print("\n\t1. Convert fahrenheit to celsius");
        System.out.print("\n\t2. Convert celsius to fahrenheit");
        System.out.print("\n\t---------------------------------\n");

        System.out.print("\tEnter you choice: ");
        int userChoice = input.nextInt();

        System.out.print("\n\t---------------------------------\n");

        switch (userChoice) {
            case 1: {
                System.out.print("\tEnter fahrenheit value: ");
                double val = input.nextDouble();
                System.out.printf("\tCelsius equivalent: %.2f\n", celcius(val));
                break;
            }
            case 2: {
                System.out.print("\tEnter celsius value: ");
                double val = input.nextDouble();
                System.out.printf("\tFahrenheit equivalent: %.2f\n", fahrenheit(val));
                break;
            }
            default:
                System.out.print("\tInvalid choice");
                break;
        }
        System.out.print("\n\t---------------------------------\n");

    }
}
