package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_16;

import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner input = new Scanner(System.in);

    private static class IntPair {
        private final int intA;
        private final int intB;

        public IntPair(int intA, int intB) {
            this.intA = intA;
            this.intB = intB;
        }
    }

    public static boolean isMultiples(IntPair pairs) {
        return pairs.intA % pairs.intB == 0;
    }

    public static IntPair obtainPairsFromUser(String message) {
        System.out.print(message);
        int intA = input.nextInt();
        int intB = input.nextInt();
        return new IntPair(intA, intB);
    }

    public static void doCheckForMultiplePairs() {
        boolean cont = true;
        do {
            IntPair currPair = obtainPairsFromUser("Enter pair (enter: 0 0, to quit): ");
            if (currPair.intA == 0 && currPair.intB == 0) {
                cont = false;
            } else {
                if (isMultiples(currPair)) {
                    System.out.printf("Pair %d is a multiple of %d%n", currPair.intA, currPair.intB);
                } else {
                    System.out.printf("Pair %d is NOT a multiple of %d%n", currPair.intA, currPair.intB);
                }
            }
        } while (cont);
    }

    public static void main(String[] args) {
        IntPair intPair = obtainPairsFromUser("Enter pair [as: a b]: ");
        if (isMultiples(intPair)) {
            System.out.printf("Pair %d is a multiple of %d%n", intPair.intA, intPair.intB);
        } else {
            System.out.printf("Pair %d is NOT a multiple of %d%n", intPair.intA, intPair.intB);
        }

        // Perform operation for multiple pairs
        doCheckForMultiplePairs();
    }

}
