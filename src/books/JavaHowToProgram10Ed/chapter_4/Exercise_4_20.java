// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.20 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_4;

import java.util.Scanner;

public class Exercise_4_20 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxEmployeeCnt = 3, i = 1;
        double finalPay;

        while (maxEmployeeCnt-- > 0) {
            System.out.printf("Enter employee %d worked hours: ", i);
            int workedHours = input.nextInt();
            System.out.printf("Enter employee %d pay per hour: ", i);
            double salary = input.nextDouble();

            if (workedHours <= 40) {
                finalPay = workedHours * salary;
            } else {
                finalPay = 40 * salary;
                finalPay += (1.5) * (workedHours - 40) * salary;
            }
            System.out.printf("Gross employee pay: $%.2f\n\n", finalPay);
            i++;
        }
    }
}
