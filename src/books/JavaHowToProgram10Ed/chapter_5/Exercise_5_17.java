// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5;

import java.util.Scanner;

public class Exercise_5_17 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double pricePD1 = 2.98;
        double pricePD2 = 4.50;
        double pricePD3 = 9.98;
        double pricePD4 = 4.49;
        double pricePD5 = 6.87;

        int cntPD1 = 0;
        int cntPD2 = 0;
        int cntPD3 = 0;
        int cntPD4 = 0;
        int cntPD5 = 0;

        System.out.print("There are five products [P1, P2, P3, P4, P5]\n" +
                "Enter name of product alongside the prices. To quit press CTRL-D or CTRL-Z\n\n");
        System.out.print("Enter product and quantity sold: ");

        while (input.hasNext()) {
            String pdName = input.next();
            int soldCnt = input.nextInt();

            switch (pdName) {
                case "P1" : cntPD1 += soldCnt; break;
                case "P2" : cntPD2 += soldCnt; break;
                case "P3" : cntPD3 += soldCnt; break;
                case "P4" : cntPD4 += soldCnt; break;
                case "P5" : cntPD5 += soldCnt; break;
                default:
                    System.out.println("\tInvalid product name");
            }
            System.out.print("Enter product and quantity sold: ");
        }
        System.out.println();

        // Displaying total
        System.out.printf("Product-I   [price: %.2f] [sold: %02d]: $%.2f\n", pricePD1, cntPD1, (cntPD1 * pricePD1));
        System.out.printf("Product-II  [price: %.2f] [sold: %02d]: $%.2f\n", pricePD2, cntPD2, (cntPD2 * pricePD2));
        System.out.printf("Product-III [price: %.2f] [sold: %02d]: $%.2f\n", pricePD3, cntPD3, (cntPD3 * pricePD3));
        System.out.printf("Product-IV  [price: %.2f] [sold: %02d]: $%.2f\n", pricePD4, cntPD4, (cntPD4 * pricePD4));
        System.out.printf("Product-V   [price: %.2f] [sold: %02d]: $%.2f\n", pricePD5, cntPD5, (cntPD5 * pricePD5));
    }
}
