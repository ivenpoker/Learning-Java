package books.JavaHowToProgram10Ed.Chapter_19;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 19.9 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : February 02, 2020                                          #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_19_9 {

    private static SecureRandom generator = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid " +
                    "size '%d' for new array", size));
        }
        return Arrays.stream(new int[size]).map(val ->
                low + generator.nextInt(high)).toArray();
    }

    private static int obtainUserKey(String inputMessage) {
        int userKey = 0;
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMessage);
                userKey = scanner.nextInt();
                cont = false;

            } catch (IllegalStateException stateExc) {
                System.err.print("[SCANNER_ERROR]: RE-BOOTING ... ");
                scanner = new Scanner(System.in);
                System.err.println("[DONE]");

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s\n", exc.getMessage());
            }
        }
        return userKey;
    }

    private static int recursiveBinarySearch(int[] sortedData, int key, int start, int end){
        if (start < end) {
            int mid = start + (end - start) / 2;
            if (key < sortedData[mid]) {
                return recursiveBinarySearch(sortedData, key, start, mid);

            } else if (key > sortedData[mid]) {
                return recursiveBinarySearch(sortedData, key, mid+1, end);

            } else {
                return mid;
            }
        }
        return -(start + 1);
    }

    private static void printArray(String message, final int[] data) {
        System.out.printf("%s %s\n", message, Arrays.toString(data));
    }
    private static void printLine(char someChar, int maxChars) {
        if (maxChars < 0) {
            throw new IllegalArgumentException("Invalid maximum chars to print. Must be > 0");
        }
        Arrays.stream(new int[maxChars]).forEach(val ->
                System.out.printf("%c", someChar));
        System.out.println();
    }

    public static void main(String[] args) {

        int[] sourceData = randomIntegerArray(0, 100, 15);
        printArray("Generated Array:", sourceData);

        Arrays.sort(sourceData);

        while (true) {
            printLine('-', 75);
            int userSearchKey = obtainUserKey("Enter your search key: ");
            printLine('-', 75);

            int results = recursiveBinarySearch(sourceData, userSearchKey, 0, sourceData.length);
            System.out.printf("Is %d found in array: %s\n", userSearchKey,
                    (results >= 0 ? "YES" : "NO"));
        }




    }

}
