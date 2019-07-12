// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.20 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.util.Scanner;

public class Exercise_C_1_20 {

    public static boolean isFloatDataDistinct(float[] floats) {
        for (int i = 0; i < floats.length; i++)
            for (int j = i+1; j < floats.length; j++)
                if (Float.compare(floats[i], floats[j]) == 0)
                    return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter size of float array: ");
        int floatArraySize = input.nextInt();

        float[] floatData = new float[floatArraySize];
        for (int i = 0; i < floatArraySize; i++) {
            System.out.printf("Enter float(s): ");
            floatData[i] = input.nextFloat();
        }

        System.out.printf("\nAre all data distinct: %s\n", isFloatDataDistinct(floatData));
    }
}
