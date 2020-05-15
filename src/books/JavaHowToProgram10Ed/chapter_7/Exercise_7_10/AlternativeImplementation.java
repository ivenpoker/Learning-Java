package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_10;

import java.security.SecureRandom;
import java.util.Arrays;

public class AlternativeImplementation {

    private static final int NUMBER_OF_SALES_PERSONS = 100;
    private static final int DEFAULT_SALES_PAY_PER_WEEK = 200;
    private static final SecureRandom random = new SecureRandom();

    private static double randomInRange(double low, double high) {
        double randVal = random.nextDouble();
        return low + (randVal * (high - low));
    }

    private static boolean inRange(double low, double val, double high) {
        return low <= val && val <= high;
    }

    private static double[] randomSalesFromPeople() {
        double[] sales = new double[NUMBER_OF_SALES_PERSONS];
        for (int i = 0; i < sales.length; i++) {
            sales[i] = randomInRange(200, 2000);
        }
        return sales;
    }

    private static void processSales(double[] sales) {
        for (int i = 0; i < sales.length; i++) {
            sales[i] = DEFAULT_SALES_PAY_PER_WEEK + ((9.0 / 100) * sales[i]);
        }
    }

    private static void displaySalesStatistics(double[] sales) {
        int freqLen = 9; 
        int[] freqs = new int[freqLen];
        
        // Obtain frequencies for payments
        for (double sale : sales) {
            if (inRange(200, sale, 299)) {
                freqs[0] += 1;
            } else if (inRange(300, sale, 399)) {
                freqs[1] += 1;
            } else if (inRange(400, sale, 499)) {
                freqs[2] += 1;
            } else if (inRange(500, sale, 599)) {
                freqs[3] += 1;
            } else if (inRange(600, sale, 699)) {
                freqs[4] += 1;
            } else if (inRange(700, sale, 799)) {
                freqs[5] += 1;
            } else if (inRange(800, sale, 899)) {
                freqs[6] += 1;
            } else if (inRange(900, sale, 999)) {
                freqs[7] += 1;
            } else {
                freqs[8] += 1;
            }
        }
        
        // Display frequencies in tabular format
        for (int i = 0, j = 2; i < freqs.length; i++, j++) {
            if (i == (freqLen-1)) {
                System.out.printf("%8s: %d%n", String.format("+%d", 1000), freqs[i]);
            } else {
                System.out.printf("$%3d-%3d: %d%n", (j * 100), (j * 100) + 99, freqs[i]);
            }
        }
    }

    public static void main(String[] args) {

        // Compute random sales for people
        double[] randomSales = randomSalesFromPeople();

        System.out.printf("Array contents: %s%n", Arrays.toString(randomSales));

        // Process sales and compute pay for each person
        processSales(randomSales);

        // Display statistics for payments
        displaySalesStatistics(randomSales);


    }
}







































