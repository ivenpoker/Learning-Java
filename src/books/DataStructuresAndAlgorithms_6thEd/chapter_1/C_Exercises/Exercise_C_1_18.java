// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.18 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.security.SecureRandom;
import java.util.Scanner;

public class Exercise_C_1_18 {

    private static SecureRandom random = new SecureRandom();

    public static int[] generateRandom(int size, int low, int high) {
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
        return data;
    }

    public static void printData(String mess, int[] data) {
        System.out.print(mess);
        int i = 0;
        for (int val : data)
            System.out.printf("%d%s", val, (i++ == data.length-1 ? "\n" : " "));
    }


    public static double norm(int[] vector, int p)  {
        long sum = 0;
        for (int val : vector)
            sum += Math.pow(val, p);
        return Math.pow(sum, (double) 1 / p);
    }

    public static double norm(int[] vector) {
        return norm(vector, 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of p: ");
        int pVal = input.nextInt();

        int[] vector = generateRandom(10, 0, 10);
        printData("Generated data: ", vector);

        System.out.printf("Value of norm(<data>, %d): %.2f\n", pVal, norm(vector, pVal));
        System.out.printf("Value of norm(<data>, %d) : %.2f\n", 2, norm(vector, 2));
    }

}
