// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.8 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.util.Scanner;

public class Exercise_6_8 {

    public static double calculateCharges(double hours) {
        if (hours <= 3) return 2.00;
        if (hours >= 24) return 10.00;

        double charge = 2.00;
        hours -= 3;

        while (hours > 0) {
            charge += 0.50;
            hours--;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter parking lot hours [3.3 -> 3hours 3 mins] for 3 customers: ");
        double hourA = input.nextDouble();
        double hourB = input.nextDouble();
        double hourC = input.nextDouble();

        System.out.printf("Charge for customer A: $%.2f\n", calculateCharges(hourA));
        System.out.printf("Charge for customer B: $%.2f\n", calculateCharges(hourB));
        System.out.printf("Charge for customer C: $%.2f\n", calculateCharges(hourC));

    }
}
