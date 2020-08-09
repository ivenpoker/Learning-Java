package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AlternativeImplementation {

    private static Scanner input = new Scanner(System.in);

    private static List<String> readFirstNamesFromUser(String inputMess) {
        boolean inputValid = false;
        List<String> firstNamesList = new ArrayList<>();

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                String line = input.nextLine().trim();

                if (line.isEmpty()) {
                    throw new InputMismatchException("please enter some input");
                }
                String[] tokens = line.split("\\s+");
                Collections.addAll(firstNamesList, tokens);
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return firstNamesList;
    }

    private static Set<String> eliminateDuplicateNames(List<String> namesList) {
        return new HashSet<>(namesList);
    }

    private static void displayNames(String message, Collection<String> names) {
        System.out.print(message);
        for (String name : names) {
            System.out.printf("%s ", name);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<String> firstNamesList = readFirstNamesFromUser("Enter all first names: ");
        displayNames("Names read: ", firstNamesList);

        Set<String> uniqueFirstNames = eliminateDuplicateNames(firstNamesList);
        displayNames("Unique names: ", uniqueFirstNames);

    }

}
