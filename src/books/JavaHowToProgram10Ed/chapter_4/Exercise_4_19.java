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
        double totalEarnings = 0.0;
        boolean onlyOne = true;
        int itemCnt = 1;

        System.out.printf("Enter item %d value [0 to quit]: ", itemCnt);
        double itemValue = input.nextDouble();

        while (itemValue > 0) {
            if (onlyOne) onlyOne = false;
            totalEarnings += 200 + (((double) (9) /100) * itemValue);
            System.out.printf("Enter item %d value [0 to quit]: ", itemCnt++);
            itemValue = input.nextDouble();
        }
        if (onlyOne) {
            System.out.printf("\nTotal earnings: $%.2f\n", (200 + (double) 9 / 100) * itemValue);
        } else {
            System.out.printf("\nTotal earnings: $%.2f\n", totalEarnings);
        }
    }

}
