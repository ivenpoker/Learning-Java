package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise_14_18 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserInputString(String inputMess) {
        boolean valid = false;
        String userInput = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.isEmpty()) {
                    throw new IllegalArgumentException("please enter some input text");
                }
                valid = true;
            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

                // clear input stream.
                scanner.nextLine();
            }
        }
        return userInput;
    }


    public static void main(String[] args) {

        String mainUserInput = obtainUserInputString("Enter some line of text: ");

        System.out.println();
        StringManipulations.printLine('=', StringManipulations.NUM_CHAR_PER_LINE);

        // Print all characters and their frequencies
        StringManipulations.printStringCharStats(mainUserInput);

        StringManipulations.printLine('=', StringManipulations.NUM_CHAR_PER_LINE);

        // Print all lengths with the number of words with that length and the words
        StringManipulations.printWordLengthStats(mainUserInput);

        StringManipulations.printLine('=', StringManipulations.NUM_CHAR_PER_LINE);

        // Print all words and the number of times they occur in string
        StringManipulations.printAllWordsAndTheirOccurrences(mainUserInput);
    }
}

class StringManipulations {

    public static int NUM_CHAR_PER_LINE = 55;
    public static final String specialChars = "`'";

    private static int numWordInWords(String keyWord, String[] words) {
        int cnt = 0;
        for (String word : words) {
            if (word.equals(keyWord)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static void printLine(char ch, int maxTimes) {
        for (int i = 0; i < maxTimes; i++) {
            System.out.printf("%c", ch);
        }
        System.out.println();
    }

    private static int specialWordLength(String supposedWord) {
        int cnt = 0;

        // word is made up of only valid alphabetic
        // characters.
        for (char ch : supposedWord.toCharArray()) {
            if (Character.isLetter(ch) || specialChars.contains("" + ch)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static HashMap<Integer, ArrayList<String>> generateAllWordLengthMappings(String mainLineOfText) {
        HashMap<Integer, ArrayList<String>> lengthToWordsMap = new HashMap<>();
        String[] allWords = mainLineOfText.split("\\s+");

        for (String word : allWords) {
            int wordLen = specialWordLength(word);

            // if we already have this length registered.
            if (lengthToWordsMap.containsKey(wordLen)) {

                // Retrieve the old list the contains it's words
                ArrayList<String> lenList = lengthToWordsMap.get(wordLen);

                // Add a new word to it.
                lenList.add(word);

                // Put back the list int the map using the 'wordLen' as the key.
                lengthToWordsMap.put(wordLen, lenList);
            } else {

                // Create a new list of specific length of words
                ArrayList<String> newLenList = new ArrayList<>();

                // Add word to that list
                newLenList.add(word);

                // Add the specific length and the list of words
                // to our map.
                lengthToWordsMap.put(wordLen, newLenList);
            }
        }
        return lengthToWordsMap;
    }

    public static HashMap<String, Integer> findAllWordsAndTheirOccurrences(String mainText) {
        String[] words = mainText.split("\\s+");
        HashMap<String, Integer> wordsAndCounts = new HashMap<>();

        for (String word : words) {
            // if we've never encountered this 'word' before, we start processing it by
            // finding the number of times the word occurs in the string and storing it
            // inside the map.
            if (!wordsAndCounts.containsKey(word)) {
                int wordCnt = numWordInWords(word, words);
                wordsAndCounts.put(word, wordCnt);
            }
        }
        return wordsAndCounts;
    }

    public static HashMap<Character, Integer> findAllCharOccurrences(String mainText) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : mainText.toCharArray()) {

            // we work only with letters or with
            if (Character.isAlphabetic(ch) || specialChars.contains("" + ch)) {
                if (freqMap.containsKey(ch)) {
                    int oldCnt = freqMap.get(ch);
                    freqMap.put(ch, oldCnt + 1);
                } else {
                    freqMap.put(ch, 1);
                }
            }
        }
        return freqMap;
    }

    public static void printWordLengthStats(String mainStr) {
        HashMap<Integer, ArrayList<String>> lengthToWordMap = generateAllWordLengthMappings(mainStr);
        System.out.printf("%-20s%-25s%-30s%n", "Word length", "Occurrences", "All words");

        printLine('-', NUM_CHAR_PER_LINE);

        for (Integer key : lengthToWordMap.keySet()) {
            ArrayList<String> wordsForKey = lengthToWordMap.get(key);
            System.out.printf("%-20s%-25s%-30s%n", key, wordsForKey.size(),
                    Arrays.toString(wordsForKey.toArray(new String[0])));
        }
    }

    public static void printStringCharStats(String mainStr) {
        HashMap<Character, Integer> charsFreqMap = findAllCharOccurrences(mainStr);
        System.out.printf("%-10s%-10s%n", "Character", "Frequency");

        for (Character key : charsFreqMap.keySet()) {
            System.out.printf("%-10s%-10s%n", key, charsFreqMap.get(key));
        }
        System.out.println();
    }

    public static void printAllWordsAndTheirOccurrences(String mainStr) {
        HashMap<String, Integer> wordsAndTheirOccurrences = findAllWordsAndTheirOccurrences(mainStr);
        String[] mainWords = mainStr.split("\\s+");

        System.out.printf("%-20s%-20s%n", "Word", "Number of occurrences");

        printLine('-', NUM_CHAR_PER_LINE);

        for (String word : mainWords) {
            System.out.printf("%-20s%-20s%n", word, wordsAndTheirOccurrences.get(word));
        }
        System.out.println();
    }
}

