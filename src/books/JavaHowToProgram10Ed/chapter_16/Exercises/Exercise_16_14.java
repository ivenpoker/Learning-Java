package books.JavaHowToProgram10Ed.chapter_16.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 16.14 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : September 15, 2019                                         #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;
import java.util.HashMap;

public class Exercise_16_14 {

    private static Scanner scanner = new Scanner(System.in);

    private static void createMap(Map<String, Integer> map) {
        boolean isValid = false;
        String inputLine = "";
        do {
            try {
                System.out.print("Enter a string: ");
                inputLine = scanner.nextLine().trim();
                isValid = true;

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        } while (!isValid);

        // Tokenize the input
        String[] tokens = inputLine.split(" ");

        // Processing input text
        for (String token : tokens) {
            for (int i = 0; i < token.length(); i++) {
                String tempChar = String.format("%c", token.charAt(i));
                if (map.containsKey(tempChar)) {
                    int tmpCnt = map.get(tempChar);
                    map.put(tempChar, tmpCnt + 1);
                } else {
                    map.put(tempChar, 1);
                }
            }
        }
    }

    private static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet();

        // Sort keys
        TreeSet<String> sortedKeys = new TreeSet<>(keys);
        System.out.printf("%nMap contains:%nKey\t\t\t\tValue%n");

        // Generate output for each key in map
        for (String key : sortedKeys)
            System.out.printf("%-10s%10s%n", key, map.get(key));

        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap);
        displayMap(myMap);
    }
}
