package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_16;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 16.16 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : September 15, 2019                                         #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.HashMap;

public class Exercise_16_16 {

    private static Scanner scanner = new Scanner(System.in);

    private static void readAndFill(Map<String, Integer> mapStore, String message) {
        boolean isValid = false;
        String inputLine = "";

        do {
            try {
                System.out.print(message);
                inputLine = scanner.nextLine().trim();

                String[] inputLineTokens = inputLine.split(" ");

                for (String token : inputLineTokens) {

                    if (!Character.isAlphabetic(token.charAt(0)))
                        continue;

                    if (mapStore.containsKey(token.toLowerCase())) {
                        int cnt = mapStore.get(token.toLowerCase());
                        mapStore.put(token.toLowerCase(), cnt+1);
                    } else {
                        mapStore.put(token.toLowerCase(), 1);
                    }
                }
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner has been closed. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("No input line was found. Try again.");

            } catch (Exception exception) {
                System.err.println("Error during processing data. Try again.");
            }
        } while (!isValid);
    }

    private static List<String> findDuplicates(Map<String, Integer> mapData) {

        List<String> duplicates = new LinkedList<>();
        Set<String> keySet = mapData.keySet();
        for (String key : keySet) {
            if (mapData.get(key) >= 2) {
                duplicates.add(key);
            }
        }
        return duplicates;
    }

    private static String duplicatesToString(List<String> duplicates) {
        ListIterator<String> iterator = duplicates.listIterator();
        StringBuilder builder = new StringBuilder();

        while (iterator.hasNext()) {
            builder.append(iterator.next()).append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        Map<String, Integer> dataStore = new HashMap<>();

        readAndFill(dataStore, "Enter a sentence to find duplicate words: ");
        List<String> duplicates = findDuplicates(dataStore);

        String duplicatesStr = duplicatesToString(duplicates);

        System.out.printf("Duplicates: %s\n", duplicatesStr.length() > 0 ? duplicatesStr : "[NONE]");
    }
}
