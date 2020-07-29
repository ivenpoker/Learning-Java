package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Exercise_14_24 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String invalidStartChars = ".!.<?@#$%^&*()_+{}|:\"/\\";
    private static final String STOP_SIGNAL = ".";
    private static final int MAX_PREDICTIONS = 3;

    private static ArrayList<String> obtainAllWordsFromUser(String inputMess) {
        boolean valid = false;
        String[] words = {};

        while (!valid) {
            try {
                System.out.print(inputMess);
                String allWords = scanner.nextLine().trim();

                if (allWords.isEmpty()) {
                    throw new IllegalArgumentException("please provide some words to work with");
                }
                words = allWords.split("\\s+");
                valid = true;

            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        ArrayList<String> allWordList = new ArrayList<>();
        for (String word : words) {
            if (!allWordList.contains(word)) {
                allWordList.add(word);
            }
        }
        return allWordList;
    }

    private static ArrayList<String> processWordsInList(ArrayList<String> wordListDB) {
        ArrayList<String> processListDB = new ArrayList<>();

        for (String currWord : wordListDB) {
            StringBuilder sb = new StringBuilder();

            // Process word to remove all invalid characters and numbers.
            for (char ch : currWord.toCharArray()) {
                if (!invalidStartChars.contains("" + ch) && !Character.isDigit(ch)) {
                    sb.append(ch);
                }
            }
            if (!sb.toString().isEmpty()) {
                processListDB.add(sb.toString());
            }
        }
        return processListDB;
    }

    private static String getUserWordToCheckSpelling(String inputMess) {
        boolean valid = false;
        String userInput = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.next().trim();

                if (userInput.isEmpty()) {
                    throw new IllegalArgumentException("please provide some input");
                }
                valid = true;
            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static void flagForGarbageCollection(ArrayList<String> listRef) {
        listRef = null;
    }

    private static int countCharMatch(String wordA, String wordB) {
        if (wordA.isEmpty() || wordB.isEmpty()) {
            return 0;
        }
        int cnt = 0;
        for (char ch : wordA.toCharArray()) {
            if (wordB.contains("" + ch)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private static HashMap<String, Double> computeMapMatchProbability(String target, ArrayList<String> wordListDB) {
        HashMap<String, Double> probMap = new HashMap<>();
        for (String word : wordListDB) {
            int maxLen = Math.max(word.length(), target.length());      // max word length between 'target' and 'word'
            int chMatchCnt = countCharMatch(word, target);              // Number of character matches between 'target' and 'word'

            // if the map doesn't already contain this word, we put the
            // word in the map and associate a probability value to which
            // it could be target word.

            if (!probMap.containsKey(word)) {

                // Put word with associated probability.
                probMap.put(word, (double) (chMatchCnt) / maxLen);
            }
        }
        return probMap;
    }

    private static ArrayList<String> getWordPredictions(HashMap<String, Double> probMap, int maxSuggestions) {

        if (maxSuggestions > probMap.keySet().size()) {
            throw new IllegalArgumentException(String.format("Invalid number of suggestions." +
                    " Max should be %d%n", maxSuggestions));
        }
        ArrayList<Prediction> predList = new ArrayList<>();
        for (String word : probMap.keySet()) {
            Prediction currPred = new Prediction(word, probMap.get(word));

            // if our prediction list doesn't yet have all requested number of predictions
            // we just add it the list of predictions
            if (!predList.contains(currPred) && predList.size() < maxSuggestions) {
                predList.add(currPred);

            } else {
                for (int i = 0, len = predList.size(); i < len; i++) {
                    Prediction suggPred = predList.get(i);
                    if (currPred.prob > suggPred.prob) {
                        predList.set(i, currPred);
                        break;
                    }
                }
            }
        }

        // We return a list of words that are the suggested predictions for the word
        ArrayList<String> suggList = new ArrayList<>();
        for (Prediction currPred : predList) {
            suggList.add(currPred.word);
        }

        return suggList;

    }

    public static void main(String[] args) {

        ArrayList<String> wordListDB = obtainAllWordsFromUser("Enter all words to consider: ");
        ArrayList<String> processedListDB = processWordsInList(wordListDB);
        flagForGarbageCollection(wordListDB);       // flag for garbage collection

        boolean progContinuity = true;

        do {
            String userSearchQuery = getUserWordToCheckSpelling("Enter your word to check spelling [enter '.' to stop]: ");
            if (!userSearchQuery.isEmpty()) {

                // if word is in 'database', we assume it is correctly spelled.
                if (processedListDB.contains(userSearchQuery)) {
                    System.out.printf("Word '%s' is correctly spelled.%n", userSearchQuery);
                } else {

                    // Compute the probability mappings for all words in 'database' against our
                    // search query.
                    HashMap<String, Double> probMap = computeMapMatchProbability(userSearchQuery, wordListDB);

                    System.out.printf("%nProbabilities ...%n%n");
                    for (String word : probMap.keySet()) {
                        System.out.printf("%10s - %.4f%n", word, probMap.get(word));
                    }
                    System.out.printf("\nSuggested words: %s%n", getWordPredictions(probMap, MAX_PREDICTIONS));
                }
            }

            if (userSearchQuery.equals(STOP_SIGNAL)) {
                progContinuity = false;
            }

        } while (progContinuity);


        // test
        System.out.println("All words read are:");
        for (String word : wordListDB) {
            System.out.println(word);
        }
    }
}

class Prediction {
    public String word;
    public double prob;

    public Prediction(String word, double prob) {
        this.word = word;
        this.prob = prob;
    }

    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(obj) || !(obj instanceof Prediction)) {
            return false;
        }
        Prediction objPred = (Prediction) obj;
        return objPred.word.equals(this.word) && objPred.prob == this.prob;
    }
}
