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

        System.out.print("Enter number of trips: ");
        int tripsCnt = input.nextInt();

        System.out.println();
        while (tripsCnt > 0) {
            System.out.printf("[%d] Enter miles driven: ", tripsCnt);
            int milesDriven = input.nextInt();

            System.out.printf("[%d] Enter gallons used: ", tripsCnt);
            int gallonsUsed = input.nextInt();
            System.out.printf("Miles per gallon: %.2f\n\n", (double) milesDriven / gallonsUsed);
            totalMilesPerGallon += (double) milesDriven / gallonsUsed;
            --tripsCnt;
        }
        System.out.printf("Total miles per gallon: %.2f\n", totalMilesPerGallon);
    }
}
