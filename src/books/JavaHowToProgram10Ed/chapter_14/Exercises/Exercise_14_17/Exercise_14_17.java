package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Exercise_14_17 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserInputString(String inputMess) {
        boolean valid = false;
        String userInputText = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInputText = scanner.nextLine().trim();

                if (userInputText.isEmpty()) {
                    throw new IllegalArgumentException("please enter some input");
                }
                valid = true;

            } catch (IllegalStateException iSe) {
                System.out.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

                // clear input stream.
                scanner.nextLine();

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
                scanner.nextLine();             // clear input stream.
            }
        }
        return userInputText;
    }


    public static void main(String[] args) {

        String mainInputText = obtainUserInputString("Enter some text: ");
        String[] allCombs = Combinations.getCombinations(mainInputText);

        System.out.printf("All combinations: %s%n", Arrays.toString(allCombs));

        // Filter all combinations to posses just those whose length is 3
        Object[] results = Stream.of(allCombs).filter((comb) -> comb.length() == 3).toArray();

        System.out.printf("Results of length 3: %s%n", Arrays.toString(results));
    }
}

class Combinations {
    public static String[] getCombinations(final String input) {
        final List<String> combinations = new ArrayList<>();
        getCombinations(input.toCharArray(), combinations, 0, "");
        return combinations.toArray(new String[0]);
    }

    private static void getCombinations(final char[] input, final List<String> combinations, final int index, final String combination) {
        if (index == input.length) {
            combinations.add(combination);
            return;
        }
        getCombinations(input, combinations, index + 1, combination + String.valueOf(input[index]));
        getCombinations(input, combinations, index + 1, combination);
    }

}