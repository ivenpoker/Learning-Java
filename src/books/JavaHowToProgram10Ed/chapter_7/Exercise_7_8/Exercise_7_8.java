package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_8;

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_7_8 {

    public static void main(String[] args) {

        // Let's assume that this is the array
        int[] f = new int[10];

        // Initialize the array
        Arrays.fill(f, 0);

        // Question a)
        System.out.printf("Value of 6 of 'f': %d%n", f[5]);

        // Question b)
        int[] g = {8, 8, 8, 8, 8, 8};  // OR use 'Arrays.fill(g, 8)' after instantiation.

        // Question c)
        int[] a = new int[15];
        int[] b = new int[34];

        System.arraycopy(a, 0, b, 0, 11);

        // Question d)

        SecureRandom random = new SecureRandom();
        float[] w = new float[99];

        // Initialize 'w'
        for (int i = 0; i < w.length; i++) {
            w[i] = random.nextInt(100);
        }

        // find smallest and largest
        float smallest = Float.MAX_VALUE;
        float largest = Float.MIN_VALUE;

        for (float v : w) {
            if (v < smallest) {
                smallest = v;
            } else if (v > largest) {
                largest = v;
            }
        }

        System.out.printf("Smallest in array: %.2f%n", smallest);
        System.out.printf("  Largest n array: %.2f%n", largest);



    }
}
