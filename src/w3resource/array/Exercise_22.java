package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Find all pairs of elements in an array whose sum is equal to a      #
// #                     specified number.                                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 2, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.Scanner;
import java.util.Arrays;

public class Exercise_22 {

    private static final int LOWER_BOUND = -10;
    private static final int UPPER_BOUND = 30;
    private static final int SIZE = 15;

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    private static class IntPair {
        private int valA;
        private int valB;

        public IntPair(int valA, int valB) {
            this.valA = valA;
            this.valB = valB;
        }

        public int getValA() {
            return this.valA;
        }

        public int getValB() {
            return this.valB;
        }

        @Override
        public boolean equals(Object obj) {
            if (Objects.isNull(obj) || !(obj instanceof IntPair)) {
                return false;
            }
            IntPair otherObj = (IntPair) obj;
            return otherObj.getValA() == this.getValA() && otherObj.getValB() == this.getValB();
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", this.getValA(), this.getValB());
        }
    }


    private static int[] createRandomIntArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified bounds. Lower bound (%d) must be < Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((val) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static int readUserInput(String inputMess) {
        boolean isInputValid = false;
        int userInupt = 0;

        while (!isInputValid) {
            try {
                System.out.print(inputMess);
                userInupt = scanner.nextInt();

                isInputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();                     // clear input stream

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getCause().getMessage());
            }
        }
        return userInupt;
    }

    private static List<IntPair> findAllSumPairs(int[] dataSource, int keySum) {
        List<IntPair> pairsList = new ArrayList<>();
        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j < dataSource.length; j++) {

                if (dataSource[i] + dataSource[j] == keySum) {

                    IntPair newPair = new IntPair(dataSource[i], dataSource[j]);
                    if (!pairsList.contains(newPair)) {
                        pairsList.add(newPair);
                    }
                }
            }
        }
        return pairsList;
    }

    public static void main(String[] args) {

        int[] randomData = createRandomIntArray(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated random data: %s%n", Arrays.toString(randomData));

        int userKeySum = readUserInput("Enter your target sum: ");
        List<IntPair> allSumPairs = findAllSumPairs(randomData, userKeySum);

        System.out.printf("All sum pairs: %s%n", allSumPairs);

    }
}

