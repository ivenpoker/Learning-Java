package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_12;

import java.util.HashMap;
import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner scanner = new Scanner(System.in);

    private static String readUserInput(String inputMess) {
        boolean isValid = false;
        String userInput = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.isEmpty()) {
                    throw new IllegalArgumentException("please enter some text");
                }
                isValid = true;

            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());

            } catch (IllegalStateException iSe) {
                System.out.print("[re-opening_scanner] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[done]");

                scanner.nextLine();                 // clear input stream.

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
                scanner.nextLine();                 // clear input stream
            }
        }
        return userInput;
    }

    private static int findNumberOfOccurrencesOfChar(char ch, String mainStr) {
        int cnt = 0;
        int idx = mainStr.indexOf(ch);

        while (idx >= 0) {
            cnt += 1;
            idx = mainStr.indexOf(ch, idx+1);
        }
        return cnt;
    }

    private static HashMap<Character, Integer> processData(String mainData) {
        HashMap<Character, Integer> dataMap = new HashMap<>();
        for (char ch : mainData.toCharArray()) {
            if (!dataMap.containsKey(Character.toLowerCase(ch))) {
                int chCnt = findNumberOfOccurrencesOfChar(ch, mainData);
                dataMap.put(ch, chCnt);
            }
        }
        return dataMap;
    }

    private static void printDataMap(HashMap<Character, Integer> dataSource) {
        for (Character key : dataSource.keySet()) {
            System.out.printf("%c: %d%n", key, dataSource.get(key));
        }
    }

    public static void main(String[] args) {

        String userMainStr = readUserInput("Enter a line of text: ");
        HashMap<Character, Integer> processedDataMap = processData(userMainStr);

        printDataMap(processedDataMap);
    }
}
