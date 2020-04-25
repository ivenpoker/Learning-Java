// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.17 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

import java.util.Scanner;

public class Exercise_4_17 {

    public static void main(String[] args) {

        double totalMilesPerGallon = 0.0;
        Scanner input = new Scanner(System.in);

        // Request number of trips
        System.out.print("Enter number of trips: ");
        int tripsCnt = input.nextInt();

        System.out.println();

        // For each trip
        while (tripsCnt > 0) {

            // Obtain miles driven from user
            System.out.printf("[%d] Enter miles driven: ", tripsCnt);
            int milesDriven = input.nextInt();

            // Obtains gallon(s) used from user
            System.out.printf("[%d] Enter gallons used: ", tripsCnt);
            int gallonsUsed = input.nextInt();

            // Display miles per gallon value.
            System.out.printf("Miles per gallon: %.2f\n\n", (double) milesDriven / gallonsUsed);

            // Update the total miles per gallon data
            totalMilesPerGallon += (double) milesDriven / gallonsUsed;
            --tripsCnt;
        }

        // Alert the user of the total miles per gallon used.
        System.out.printf("Total miles per gallon: %.2f\n", totalMilesPerGallon);
    }
}
