package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_17;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class AlternativeImplementation {

    private static final SecureRandom randomNumber = new SecureRandom();
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ARRAY_SIZE = 25;

    private static int[] randomIntegerArray(int lower, int upper, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified array size '%d'", size));
        }
        int[] mainData = new int[size];
        for (int i = 0; i < mainData.length; i++) {
            mainData[i] = lower + randomNumber.nextInt(upper);
        }
        return mainData;
    }

    private static LinkedList<Integer> makeAListOutOfArray(int[] mainData) {
        int[] copy = Arrays.copyOf(mainData, mainData.length);          // make a copy of the original array
        Arrays.sort(copy);                                              // sort the copy of the original array

        LinkedList<Integer> mainList = new LinkedList<>();
        for (int data : copy) {
            mainList.add(data);
        }
        return mainList;
    }

    private static int listSum(List<Integer> someList) {
        int sum = 0;
        for (int currInt : someList) {
            sum += currInt;
        }
        return sum;
    }

    private static float listAverage(List<Integer> someList) {
        int listSum = listSum(someList);
        return (float) listSum / someList.size();
    }

    public static void main(String[] args) {

        int[] randomData = randomIntegerArray(LOWER_BOUND, UPPER_BOUND, MAX_ARRAY_SIZE);
        System.out.printf("Random data: %s%n", Arrays.toString(randomData));

        LinkedList<Integer> randList = makeAListOutOfArray(randomData);
        System.out.printf("Random list data: %s%n", randList);

        System.out.printf("Random list sum: %d%n", listSum(randList));
        System.out.printf("Random list average: %.2f%n", listAverage(randList));

    }

}
