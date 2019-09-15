package books.JavaHowToProgram10Ed.chapter_16;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.security.SecureRandom;

public class Exercise_16_17 {

    private static SecureRandom random = new SecureRandom();

    private static void randomlyFillIntegerList(List<Integer> integerList, int low, int high,
                                                int count) {
        for (int i = 0; i < count; i++) {
            int randInt = low + random.nextInt(high);
            integerList.add(randInt);
        }
        Collections.sort(integerList);
    }

    private static int findIntegerListSum(List<Integer> integerList) {
        int sum = 0;
        for (Integer intVal : integerList)
            sum += intVal;      // auto-unboxing
        return sum;
    }

    private static double findIntegerListAverage(List<Integer> integerList) {
        int sum = findIntegerListSum(integerList);
        return (double) sum / integerList.size();
    }

    private static void printIntegerList(List<Integer> integerList, String message) {
        System.out.print(message);
        for (int i = 0; i < integerList.size(); i++)
            System.out.printf("%d%s", integerList.get(i), i == integerList.size()-1 ? "" : " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>();

        randomlyFillIntegerList(integerList, 0, 100, 25);
        printIntegerList(integerList, " Generated list: ");

        System.out.printf("    Sum of list: %d\n", findIntegerListSum(integerList));
        System.out.printf("Average of list: %.2f\n", findIntegerListAverage(integerList));

    }
}
