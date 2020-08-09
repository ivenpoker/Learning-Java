package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class AlternativeImplementation {

    private static Scanner input = new Scanner(System.in);

    // Obtain data from user and returns a string tokens (words)

    private static List<String> readUserStringAsWordTokens(String inputMess) {
        boolean inputValid = false;
        List<String> userStringTokens = new ArrayList<>();

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                String inputLine = input.nextLine().trim();

                if (inputLine.isEmpty()) {
                    throw new InputMismatchException("please enter some input");
                }
                String[] tokens = inputLine.split("\\s+");
                Collections.addAll(userStringTokens, tokens);
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userStringTokens;
    }

    // Process a list to tokens (words) to obtain a map of characters and the
    // number of times they occur.

    private static Map<Character, Integer> processWordTokens(List<String> tokens) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : tokens) {
            for (char ch : word.toCharArray()) {
                if (map.containsKey(ch)) {
                    int tmpCnt = map.get(ch);
                    map.put(ch, tmpCnt + 1);
                } else {
                    map.put(ch, 1);
                }
            }
        }
        return map;
    }

    // Display the map to the console.

    private static void displayMap(Map<Character, Integer> mainMap) {
        for (Character key : mainMap.keySet()) {
            System.out.printf("%4s:%6d%n", key, mainMap.get(key));
        }
    }

    public static void main(String[] args) {

        List<String> allUserInputWords = readUserStringAsWordTokens("Enter some text: ");
        Map<Character, Integer> charMap = processWordTokens(allUserInputWords);
        displayMap(charMap);

    }

}
