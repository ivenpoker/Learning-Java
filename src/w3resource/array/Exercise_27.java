package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the number of even and odd integers in a given array of       #
// #                     integers.                                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 3, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_27 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 20;

    private static final SecureRandom secureRandom = new SecureRandom();

    private static class EvenOdd {
        private int numOfEvens = 0;
        private int numOfOdds = 0;

        public EvenOdd(int numOfEvens, int numOfOdds) {
            this.numOfEvens = numOfEvens;
            this.numOfOdds = numOfOdds;
        }

        public int getNumOfEvens() {
            return this.numOfEvens;
        }

        public int getNumOfOdds() {
            return this.numOfOdds;
        }

        public void setNumOfEvens(int val) {
            this.numOfEvens = val;
        }

        public void setNumOfOdds(int val) {
            this.numOfOdds = val;
        }
    }

    private static int[] randomIntArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified bounds. Lower bound (%d) must be <= Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). Must be >= 0",
                    size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static EvenOdd findNumOfEvensAndOdds(int[] dataSource) {
        EvenOdd newEvenOdd = new EvenOdd(0, 0);
        IntStream.of(dataSource).forEach((val) -> {
            if (val % 2 == 0) {
                newEvenOdd.setNumOfEvens(newEvenOdd.getNumOfEvens() + 1);
            } else {
                newEvenOdd.setNumOfOdds(newEvenOdd.getNumOfOdds() + 1);
            }
        });
        return newEvenOdd;
    }

    public static void main(String[] args) {
        int[] randIntData = randomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randIntData));

        EvenOdd evenOdd = findNumOfEvensAndOdds(randIntData);
        System.out.printf("Number of evens: %d%n", evenOdd.getNumOfEvens());
        System.out.printf("Number of odds: %d%n", evenOdd.getNumOfOdds());
    }

}
