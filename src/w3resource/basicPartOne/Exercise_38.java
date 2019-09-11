package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Count the letters, spaces, numbers and other characters of an    #
// #                     input string.                                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.Set;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.HashMap;

public class Exercise_38 {

    private static String[] readInputStringAndTokenize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter some string: ");
        String input = "";

        try {
            input = scanner.nextLine();

        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("No line input found");

        } catch (IllegalStateException illegalStateException) {
            System.err.println("Scanner has been closed");
        }
        return input.split(" ");
    }

    private static Map<String, Integer> processTokenizeData(String[] mainData) {
        Map<String, Integer> newData = new HashMap<>();
        newData.put("space", mainData.length-1);

        System.out.println();

        for (String data : mainData) {
            System.out.printf("Processing '%s'....\n", data);

            for (Character ch : data.toCharArray()) {
                if (Character.isAlphabetic(ch)) {
                    if (newData.containsKey("letter")) {
                        newData.put("letter", newData.get("letter") + 1);
                    } else {
                        newData.put("letter", 1);
                    }
                } else if (Character.isDigit(ch)) {
                    if (newData.containsKey("number")) {
                        newData.put("number", newData.get("number") + 1);
                    } else {
                        newData.put("number", 1);
                    }
                } else {
                    if (newData.containsKey("other")) {
                        newData.put("other", newData.get("other") + 1);
                    } else {
                        newData.put("other", 1);
                    }
                }
            }
        }
        return newData;
    }

    private static void printData(Map<String, Integer> data) {
        Set<String> keys = data.keySet();
        System.out.println("\nInfo from input...\n");
        for (String key : keys) {
            System.out.printf("%s: %d\n", key, data.get(key));
        }
    }

    public static void main(String[] args) {

        String[] data = readInputStringAndTokenize();
        Map<String, Integer> mapData = processTokenizeData(data);
        printData(mapData);

    }
}
