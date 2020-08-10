package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_18;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;

public class AlternativeImplementation {

    private static final String MAIN_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final int MAX_CHARS = 10;
    private static final SecureRandom random = new SecureRandom();

    private static LinkedList<Character> createCharList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid specified number of chars");
        }
        LinkedList<Character> charList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            charList.add(MAIN_CHARS.charAt(random.nextInt(MAIN_CHARS.length())));
        }
        return charList;
    }

    private static LinkedList<Character> makeCopyThenReverse(LinkedList<Character> mainList) {
        LinkedList<Character> copy = new LinkedList<>(mainList);
        Collections.reverse(copy);

        return copy;
    }

    public static void main(String[] args) {
        LinkedList<Character> randCharList = createCharList(MAX_CHARS);
        System.out.printf("Random character list: %s%n", randCharList);

        LinkedList<Character> copyList = makeCopyThenReverse(randCharList);
        System.out.printf("Copy and reversed list: %s%n", copyList);
    }

}
