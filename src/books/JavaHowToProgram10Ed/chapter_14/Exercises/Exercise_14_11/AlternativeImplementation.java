package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserInputText(String inputMess) {
        boolean isValid = false;
        String userInputData = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userInputData = scanner.nextLine().trim();

                if (userInputData.isEmpty()) {
                    throw new IllegalArgumentException("Please enter string input");
                }
                isValid = true;
            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening_scanner] ... ");
                scanner = new Scanner(System.in);

                System.err.println("[done]");
                scanner.nextLine();                 // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
            }
        }
        return userInputData;
    }

    public static void main(String[] args) {

        String mainStrData = obtainUserInputText("Enter a sample sentence: ");
        char searchChar = '.';
        boolean obtainedSearchChar = false;

        while (!obtainedSearchChar) {
            try {
                String tmp = obtainUserInputText("Enter search character: ");
                if (tmp.length() != 1) {
                    throw new IllegalArgumentException("Please enter a single character");
                }
                searchChar = tmp.charAt(0);
                obtainedSearchChar = true;
            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());
            }
        }

        ArrayList<Integer> indices = new ArrayList<>();
        int idx = mainStrData.indexOf(searchChar);

        while (idx >= 0) {
            indices.add(idx);
            idx =  mainStrData.indexOf(searchChar, idx+1);
        }

        System.out.printf("Number occurrences of '%c': %d | At indices: %s%n", searchChar, indices.size(),
                Arrays.toString(indices.toArray(new Integer[0])));

    }

}
