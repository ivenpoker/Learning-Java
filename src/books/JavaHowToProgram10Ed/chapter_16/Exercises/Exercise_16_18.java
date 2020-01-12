package books.JavaHowToProgram10Ed.chapter_16.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 16.18 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : September 15, 2019                                         #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exercise_16_18 {

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static SecureRandom random = new SecureRandom();

    private static void fillListWithCharacters(List<Character> charList, int maxChars) {
        for (int i = 0; i < maxChars; i++)
            charList.add(alphabet.charAt(random.nextInt(alphabet.length())));
    }

    private static void printCharacterList(List<Character> charList, String initialMessage) {
        System.out.print(initialMessage);
        for (int i = 0; i < charList.size(); i++)
            System.err.printf("%c%s", charList.get(i), i == charList.size()-1 ? "" : " ");
        System.out.println();
    }

    private static List<Character> newListInReverseOrder(List<Character> charList) {
        List<Character> newList = new LinkedList<>();
        ListIterator listIterator = charList.listIterator(charList.size());

        while (listIterator.hasPrevious())
            newList.add((Character) listIterator.previous());

        Collections.sort(newList, Collections.reverseOrder());

        return newList;
    }

    public static void main(String[] args) {

        List<Character> charList = new LinkedList<>();
        fillListWithCharacters(charList, 10);

        printCharacterList(charList, "Initial list: ");

        List<Character> charListCopy = newListInReverseOrder(charList);

        printCharacterList(charListCopy, "New reversed list: ");
    }

}
