// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C-3.18 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 23/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.C_Exercises;

import java.util.LinkedList;
import java.util.List;

import java.security.SecureRandom;

public class Exercise_C_3_18 {

    private static SecureRandom random = new SecureRandom();

    private static void randomFillArray(int[] data, int low, int high) {
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
    }
    private static void printArrayData(String mess, int[] data, int brkPt) {

        System.out.printf("%s", mess);
        for (int i = 0, cnt = 1; i < data.length; i++, cnt++)
            System.out.printf("%2d%s", data[i], (cnt % brkPt == 0) ? "\n" : " ");
    }
    private static void printLine(char ch, int times) {
        for (int i = 0; i < times; i++)
            System.out.printf("%c", ch);
        System.out.println();
    }

    private static List<Integer> findFiveRepeatedInts(int[] data) {
        List<Integer> unique = new LinkedList<>();        // we could have used chapter Lists if we wanted
        List<Integer> repeat = new LinkedList<>();

        for (int intVal : data) {
            if (unique.contains(intVal)) {
                repeat.add(intVal);
            } else {
                unique.add(intVal);
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int[] data = new int[100];

        randomFillArray(data, 1, data.length-5);
        printArrayData("Generated Array Data:\n", data, 10);

        printLine('-', 30);

        List<Integer> list = findFiveRepeatedInts(data);
        System.out.printf("Number of repeated integers: %d\n", list.size());
        printLine('-', 30);

        int cnt = 1;

        System.out.println("Generated numbers that repeat");
        for (Integer intVal : list)
            System.out.printf("%2d%s", intVal, (cnt++ % 5 == 0) ? "\n" : " ");

        printLine('-', 30);
    }
}
