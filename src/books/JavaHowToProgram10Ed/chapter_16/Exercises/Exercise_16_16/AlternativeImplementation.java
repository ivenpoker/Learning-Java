package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_16;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    private static List<String> readUserInputStr(String inputMess) {
        boolean inputValid = false;
        List<String> tokenList = new LinkedList<>();

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                String line = input.nextLine().trim();

                if (line.isEmpty()) {
                    throw new InputMismatchException("please enter some text");
                }
                String[] tokens = line.split("\\s+");
                Collections.addAll(tokenList, tokens);
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return tokenList;
    }

    public static Map<String, Integer> mapWordToCount(List<String> tokenList) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String token : tokenList) {
            if (wordMap.containsKey(token.toLowerCase())) {
                int oldCnt = wordMap.get(token);
                wordMap.put(token.toLowerCase(), oldCnt+1);
            } else {
                wordMap.put(token.toLowerCase(), 1);
            }
        }
        return wordMap;
    }

    public static Set<String> obtainDuplicateWords(Map<String, Integer> wordMap) {
        Set<String> dupSet = new HashSet<>();
        for (String word :  wordMap.keySet()) {
            if (wordMap.get(word) > 1) {
                dupSet.add(word);
            }
        }
        return dupSet;
    }

    public static void main(String[] args) {

        List<String> tokenList = readUserInputStr("Enter a sentence: ");
        Map<String, Integer> wordMap = mapWordToCount(tokenList);
        Set<String> duplicateWords = obtainDuplicateWords(wordMap);

        System.out.printf("Number of duplicates: %d%n", duplicateWords.size());
        System.out.printf("Duplicate words: %s%n", duplicateWords);
    }

}
