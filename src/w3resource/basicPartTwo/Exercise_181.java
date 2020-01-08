package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Finds the length of last word of a given string. The string contains #
// #                     upper/lower-case alphabets and empty space characters ''.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : January 08, 2019                                                     #
// #                                                                                          #
// ############################################################################################

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_181 {

    private static Scanner scanner = new Scanner(System.in);

    private static List<String> readUserWord(String inputMessage) {
        List<String> userWords = new LinkedList<>();
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMessage);
                String[] supposedWords = scanner.nextLine().trim().split(" ");
                for (String word : supposedWords) {
                    word = word.trim();
                    if (word.length() > 0) {
                        userWords.add(word);
                    }
                }
                cont = false;
            } catch (Exception exc) {
                System.err.println(String.format("[INPUT_ERROR]: %s\n", exc.getMessage()));
            }
        }
        return userWords;
    }

    private static Integer getLastWordLength(List<String> someWords) {
        List<Integer> wordLengths = someWords.stream()
                .map(String::length)
                .collect(Collectors.toList());
        return wordLengths.get(wordLengths.size()-1);
    }

    public static void main(String[] args) {
        List<String> mainWords = readUserWord("Enter a sentence: ");
        System.out.printf("Length of the last word of the above string: %d\n", getLastWordLength(mainWords));
    }
}
