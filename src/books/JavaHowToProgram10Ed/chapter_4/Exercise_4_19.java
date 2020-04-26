// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.19 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

import java.util.Scanner;

public class Exercise_4_19 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cnt = 1;
        double totalSales  = 0;

        System.out.printf("Enter sales #%d for week [-1 to quit]: ", cnt++);
        double tempSale = input.nextDouble();

        while (tempSale != -1) {
            totalSales += tempSale;
            System.out.printf("Enter sales #%d for week [-1 to quit]: ", cnt++);
            tempSale = input.nextDouble();
        }
        System.out.printf("%n%nYour earning: $%.2f%n", (200 + (((double)9/100) * totalSales)));
    }

}
