package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_20;

import java.security.SecureRandom;
import java.util.Arrays;

public class MonthSlips {

    private final Slip[][] slips;
    private final int NUMBER_OF_SALES_PERSONS = 4;
    private final SecureRandom random;

    String[] productNames = {Slip.ProductType.PROD_1.toString(), Slip.ProductType.PROD_2.toString(),
            Slip.ProductType.PROD_3.toString(), Slip.ProductType.PROD_4.toString(),
            Slip.ProductType.PROD_5.toString()};

    public MonthSlips(int numDays) {
        this.slips = new Slip[NUMBER_OF_SALES_PERSONS][numDays];
        this.random = new SecureRandom();
    }

    public void randomlyFillMonth() {
        for (int i = 0; i < this.NUMBER_OF_SALES_PERSONS; i++) {
            for (int j = 0; j < this.slips[i].length; j++) {
                int randomSalesPersonNum = 100 + this.random.nextInt(1000);
                String randomProductNumber = String.format("PROD_#%d", random.nextInt(1000));
                double randomTotalSold = this.random.nextInt(1000);
                int randCnt = this.random.nextInt(100);

                int randProductTypeNum = 1 + this.random.nextInt(5);
                Slip.ProductType productType;
                switch (randProductTypeNum) {
                    case 1:
                        productType = Slip.ProductType.PROD_1;
                        break;
                    case 2:
                        productType = Slip.ProductType.PROD_2;
                        break;
                    case 3:
                        productType = Slip.ProductType.PROD_3;
                        break;
                    case 4:
                        productType = Slip.ProductType.PROD_4;
                        break;
                    case 5:
                    default:
                        productType = Slip.ProductType.PROD_5;
                }

                Slip newSlip = new Slip(randomSalesPersonNum, randomProductNumber, randomTotalSold, randCnt, productType);
                this.slips[i][j] = newSlip;
            }
        }
    }

    public void printTotalSalesByPerson() {
        System.out.printf("============= [TOTAL SALES BY PERSON] =========\n\n");
        System.out.println(this);
    }

    public void printTotalSalesByProduct() {
        System.out.println("========= [SALES BY PRODUCT] =========\n");
        for (String productName : this.productNames) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;

            for (Slip[] slip : this.slips) {
                for (Slip value : slip) {
                    if (value.getProductType().toString().equals(productName)) {
                        sb.append(String.format("%-36s", value)).append(" | ");
                        cnt++;
                    }
                }
            }
            System.out.printf("%s [%2d]: %s%n", productName, cnt, sb.toString());
        }
    }

    private double getAllDataFor(int salesPersonNum, String productName) {
        double totalSales = 0;
        Slip[] salesPersonSlips = this.slips[salesPersonNum];
        for (Slip singleSlip : salesPersonSlips) {
            if (singleSlip.getProductType().toString().equals(productName)) {
                totalSales += singleSlip.getTotalSold();
            }
        }
        return totalSales;
    }

    public void coreProcessingOfSales() {
        System.out.println("\n============================================================================");

        // Holds total sales for all 5 products with 4 sales person.
        double[][] totalsForAllSalesPerson = new double[5][NUMBER_OF_SALES_PERSONS];

        // Computing the sum of all particular product sales by sales persons and storing
        // it in the array above.

        for (int i = 0; i < this.productNames.length; i++) {
            String productName = this.productNames[i];
            for (int j = 0; j < this.slips.length; j++) {
                double salesPersonTotal = this.getAllDataFor(j, productName);
                totalsForAllSalesPerson[i][j] = salesPersonTotal;
            }
        }

        // Displaying the sum computed above in a tabular manner, with product type names
        // as rows and Sales person as columns.

        System.out.printf("%10s%10s%10s%10s%10s%5s%20s%n", "", "P1", "P2", "P3", "P4", "|", "Product Row Total");
        for (int i = 0; i < totalsForAllSalesPerson.length; i++) {
            System.out.printf("%10s", this.productNames[i]);
            double sum = 0;
            for (int j = 0; j < totalsForAllSalesPerson[i].length; j++) {
                System.out.printf("%10.1f", totalsForAllSalesPerson[i][j]);
                sum += totalsForAllSalesPerson[i][j];
            }
            System.out.printf("%5s%10.1f%n", "|", sum);
        }
        System.out.println("============================================================================");
        System.out.printf("%10s", "Column Sum");

        for (int j = 0; j < totalsForAllSalesPerson[0].length; j++) {
            double sum = 0;
            for (int i = 0; i < totalsForAllSalesPerson.length; i++) {
                sum += totalsForAllSalesPerson[i][j];
            }
            System.out.printf("%10.1f", sum);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (Slip[] slipRow : this.slips) {
            sb.append(String.format("Sales person #%d --> : ", ++cnt));
            sb.append(Arrays.toString(slipRow)).append("\n");
        }
        return sb.toString();
    }
}
