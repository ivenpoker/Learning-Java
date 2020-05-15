// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.10 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 10/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_10;

import java.security.SecureRandom;

public class Exercise_7_10 {

    private static final int MAX_RANDOM = 200;
    private static SecureRandom random = new SecureRandom();

    public static double randomSalesOfWeak() {
        return 200 + (9.0 / 100 * (200 + 100 * random.nextInt(10)))
                * (4 + random.nextInt(10));
    }

    public static boolean inRange(int low, double val, int upper) {
        return (low <= (val) && (val) <= upper);
    }

    public static void main(String[] args) {
        int[] rangeCount = new int[10];

        // compute random salaries and keep track of counts in ranges.
        for (int i = 1; i < MAX_RANDOM; i++) {
            double newData = randomSalesOfWeak();
            if (inRange(200, newData, 299)) rangeCount[1]++;
            if (inRange(300, newData, 399)) rangeCount[2]++;
            if (inRange(400, newData, 499)) rangeCount[3]++;
            if (inRange(500, newData, 599)) rangeCount[4]++;
            if (inRange(600, newData, 699)) rangeCount[5]++;
            if (inRange(700, newData, 799)) rangeCount[6]++;
            if (inRange(800, newData, 899)) rangeCount[7]++;
            if (inRange(900, newData, 999)) rangeCount[8]++;
            if (newData >= 1000) rangeCount[9]++;
        }

        // display statistics
        for (int i = 1; i < rangeCount.length; i++) {
            switch (i) {
                case 1: System.out.print("$200-299: "); break;
                case 2: System.out.print("$300-399: "); break;
                case 3: System.out.print("$400-499: "); break;
                case 4: System.out.print("$500-599: "); break;
                case 5: System.out.print("$600-699: "); break;
                case 6: System.out.print("$700-799: "); break;
                case 7: System.out.print("$800-899: "); break;
                case 8: System.out.print("$900-999: "); break;
                case 9: System.out.print("   $1000: "); break;
            }
            for (int j = 0; j < rangeCount[i]; j++)
                System.out.printf("%s", "*");
            System.out.printf(" [%d]\n", rangeCount[i]);
        }

    }
}
