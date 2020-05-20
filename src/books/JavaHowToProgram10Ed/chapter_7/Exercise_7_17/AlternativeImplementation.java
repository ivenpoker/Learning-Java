package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_17;

import java.util.Random;

public class AlternativeImplementation {

    private static final Random random = new Random();
    private static final int MAX_NUMBER_OF_ROLLS = 36000000;

    private static int rollDie() {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        return die1 + die2;
    }

    public static void main(String[] args) {
        int[] frequencies = new int[14];
        System.out.print("Performing rolls ....");
        for (int i = 0; i < MAX_NUMBER_OF_ROLLS; i++) {
            int currRoll = rollDie();
            frequencies[currRoll] += 1;
//            System.out.printf("\rPerforming rolls ... [%.2f%%]", ((double) i / MAX_NUMBER_OF_ROLLS) * 100);
        }
        System.out.printf("\r%30s", "");
        System.out.printf("\r%s\t%20s%n", "Roll", "Frequency");
        for (int i = 2; i < frequencies.length-1; i++) {
            System.out.printf("%2d:\t%20d%n", i, frequencies[i]);
        }
    }
}
