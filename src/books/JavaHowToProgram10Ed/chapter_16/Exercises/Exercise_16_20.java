package books.JavaHowToProgram10Ed.chapter_16.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 16.20 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : September 15, 2019                                         #
// #                                                                                  #
// ####################################################################################

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Exercise_16_20 {

    private static Scanner scanner = new Scanner(System.in);

    private static TreeSet<String> readData(String inputMessage) {
        boolean isValid = false;
        TreeSet<String> dataSet = new TreeSet<>();

        do {
            try {
                System.out.print(inputMessage);
                String inputLine = scanner.nextLine().trim();
                String[] mainData = inputLine.split(" ");

                // Fill int the set with tokens
                dataSet.addAll(Arrays.asList(mainData));

                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner has been closed. Re-opening...");
                scanner = new Scanner(System.in);
                System.err.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                System.err.println("Try again.");
            }
        } while (!isValid);
        return dataSet;
    }

    private static void printData(String message, TreeSet<String> dataSet) {
        System.out.print(message);

        for (String data : dataSet)
            System.out.print(data + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        TreeSet<String> dataSet = readData("Enter a sentence: ");
        printData("Data from TreeSet: ", dataSet);
    }
}
