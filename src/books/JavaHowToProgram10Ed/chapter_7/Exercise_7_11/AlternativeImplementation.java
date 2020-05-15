package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_11;

import java.util.Arrays;
import java.security.SecureRandom;

public class AlternativeImplementation {

    public static void main(String[] args) {

        // ############# QUESTION a) #################

        int[] counts = new int[10];

        // Sets element of array counts to zero.
        Arrays.fill(counts, 0);

        // ############# QUESTION b) #################

        int[] bonus = new int[15];

        // Add one to the contents of the array.

        for (int i = 0; i < bonus.length; i++) {
            bonus[i] += 1;
        }

        // ############# QUESTION c) ###############

        int[] bestScores = new int[10];
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < bestScores.length; i++) {
            bestScores[i] = random.nextInt(100);
        }

        System.out.println("Contents of array [5 values] in tabular format\n");
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.printf(" %2d%n", bestScores[i]);
            } else {
                System.out.printf(" %2d", bestScores[i]);
            }
        }

    }
}
