package books.DataStructuresAndAlgorithms_6thEd.chapter_3.C_Exercises;

import java.security.SecureRandom;
import java.util.Collections;

public class Exercise_C_3_22 {

    private static SecureRandom random = new SecureRandom();

    private static void randomlyFillWithData(int[] data, int low, int high) {
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
    }

    private static void printData(String mess, int[] data, int brkPt) {
        System.out.printf("%s", mess);

        int cnt = 1;
        for (int i = 0; i < data.length; i++)
            System.out.printf("%2d%s", data[i], (cnt++ % brkPt == 0) ? "\n" :  " ");
    }

    public static void shuffle(int[] data) {
        Collections.shuffle();
    }

    public static void main(String[] args) {
        int[] data = new int[100];

        randomlyFillWithData(data, 0, 100);
        printData("Generated data:\n", data, 10);
    }
}
