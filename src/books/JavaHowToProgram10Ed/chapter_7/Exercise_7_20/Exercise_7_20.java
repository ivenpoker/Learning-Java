// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.20 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 11/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_20;

import java.security.SecureRandom;

public class Exercise_7_20 {

    private static int MAX_SALES_PERSON = 4;
    private static int MAX_SALES_PRODUCT = 5;
    private static SecureRandom random = new SecureRandom();

    private static class Slip {
        private int _cnt;
        private int _number;
        private int _prodNumber;
        private double _totalDollarValue;
        private static enum ProductType {PRODUCT_A, PRODUCT_B, PRODUCT_C, PRODUCT_D, PRODUCT_E}
        private ProductType _prodType;


        public Slip(int personNumber, int prodNumber, double totalDollarValue) {
            this._number = personNumber;
            this._prodNumber = prodNumber;
            this._totalDollarValue = totalDollarValue;
            this._cnt = 0;
            switch (random.nextInt(4)) {
                case 0: this._prodType = ProductType.PRODUCT_A; break;
                case 1: this._prodType = ProductType.PRODUCT_B; break;
                case 2: this._prodType = ProductType.PRODUCT_C; break;
                case 3: this._prodType = ProductType.PRODUCT_D; break;
                case 4: this._prodType = ProductType.PRODUCT_E; break;
            }
        }
        public int getNumber() {
            return this._number;
        }
        public int getProductNumber() {
            return this._prodNumber;
        }
        public double getDollarValue() {
            return this._totalDollarValue;
        }
        public void incrementCount() { ++this._cnt; }
        public ProductType getProductType() {
            return this._prodType;
        }
        public int getSalesCount() {
            return this._cnt;
        }
    }

    public static void main(String[] args) {
        Slip[][] sales = new Slip[MAX_SALES_PRODUCT][MAX_SALES_PERSON];

        fillSales(sales);

        printSales(sales);


    }

    private static void fillSales(Slip[][] sales) {
        int cntTmpNumber = 124;
        int productNumber = 345;

        for (Slip[] slip : sales) {
            for (int i = 0; i < slip.length; i++) {
                slip[i] = new Slip(cntTmpNumber, productNumber,100 + 10 * random.nextDouble());
                int tmp = random.nextInt(6);  // lets randomly assign the number of products sold;
                for (int k = 0; k < tmp; k++)
                    slip[i].incrementCount();
            }
            cntTmpNumber  += 10 + 20 * (1 + random.nextInt(10));
            productNumber += 10 + 20 * (1 + random.nextInt(10));
        }
    }

    private static void printSales(Slip[][] sales) {
        int k = 1;
        int[] totalSalesByPerson = new int[sales[0].length];
        for (Slip[] slip : sales) {
            System.out.printf("%s %d: ", "Product", k++);
            int totalSalesCnt = 0;
            double totalDollars = 0.0;
            for (int i = 0; i < slip.length; i++) {
                totalSalesCnt += slip[i].getSalesCount();
                totalDollars += slip[i].getDollarValue();
                totalSalesByPerson[i] += slip[i].getSalesCount();
                System.out.printf("%2d%s", slip[i].getSalesCount(), (i == slip.length-1) ? "" : " ");
            }
            System.out.printf(" [Total sales: %02d] ----- [Amount: $%.2f]\n", totalSalesCnt, totalDollars);
        }
        System.out.println("----------------------");
        System.out.printf("%s: ", "Sales sum");
        for (int i = 0; i < totalSalesByPerson.length; i++)
            System.out.printf("%2d%s", totalSalesByPerson[i], (i == totalSalesByPerson.length-1) ? "\n" : " ");
    }
}
