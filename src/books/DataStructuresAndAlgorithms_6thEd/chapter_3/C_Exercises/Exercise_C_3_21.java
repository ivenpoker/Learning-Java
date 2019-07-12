// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C-3.21 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 23/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.C_Exercises;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class Exercise_C_3_21 {

    private static SecureRandom random = new SecureRandom();

    private static class Count {
        private int someNum;
        private int cnt;

        public Count(int val) {
            this.someNum = val;
            this.cnt = 0;
        }
        public int getCnt() {
            return this.cnt;
        }
        public void increment() {
            this.cnt++;
        }
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != this.getClass()) return false;
            Count other = (Count)obj;
            return this.someNum == other.someNum;
        }
    }

    private static void randomFillArray(int[] data, int low, int high) {
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
    }

    private static int findProduct(int[] data) {
        int prod = 1;
        for (int intVal : data) prod *= intVal;
        return prod;
    }

    public static void main(String[] args) {
        int[] data = new int[100];

        // Launching 100 simulations to find that x that wil;
        // have the probability of 0.99.

        for (int i = 0; i < data.length; i++) {
            randomFillArray(data, 0, 100);
            System.out.printf("Product #%03d: %d\n", (i+1), findProduct(data));
        }

        // The number is zero.


    }
}
