package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_20;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class AlternativeImplementation {

    private static Scanner input = new Scanner(System.in);

    private static List<String> readTokensFromUser(String inputMess) {
        boolean inputValid = false;
        List<String> tokenList = new LinkedList<>();

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                String userText = input.nextLine().trim();

                if (userText.isEmpty()) {
                    throw new InputMismatchException("please enter some string input.");
                }
                String[] tokens = userText.split("\\s+");
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

    public static void main(String[] args) {

        List<String> tokenList = readTokensFromUser("Enter some text: ");
        TreeSet<String> tokenTreeSet = new TreeSet<>(tokenList);

        System.out.printf("Tree set data: %s%n", tokenTreeSet);

    }
}
