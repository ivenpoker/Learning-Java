package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_5;

import java.security.SecureRandom;

public class AlternativeImplementation {

    private static final SecureRandom random = new SecureRandom();

    private static final String[] articles = {"the", "a", "one", "some", "any"};
    private static final String[] nouns = {"boy", "girl", "dog", "town", "car"};
    private static final String[] verbs = {"drove", "jumped", "ran", "walked", "skipped"};
    private static final String[] preposition = {"to", "from", "over", "under", "on"};

    private static final int MAX_SENTENCES_COUNT = 20;

    private static String[] createSentences(int maxNumOfSentences) {
        if (maxNumOfSentences <= 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified number of sentences to create (%d). Must be > 0",
                            maxNumOfSentences));
        }
        String[] sentences = new String[maxNumOfSentences];
        for (int i = 0; i < maxNumOfSentences; i++) {

            // Create a random sentence
            StringBuilder tmpSb = new StringBuilder();

            // random 'article' value added to sentence
            tmpSb.append(articles[random.nextInt(articles.length)]);
            tmpSb.append(" ");

            // random 'noun' value added to sentence
            tmpSb.append(nouns[random.nextInt(nouns.length)]);
            tmpSb.append(" ");

            // random 'verb' value added to sentence
            tmpSb.append(verbs[random.nextInt(verbs.length)]);
            tmpSb.append(" ");

            // random 'preposition' value added to sentence
            tmpSb.append(preposition[random.nextInt(preposition.length)]);

            // Capitalize first word in the sentence
            tmpSb.setCharAt(0, Character.toUpperCase(tmpSb.charAt(0)));

            // Add a period at the end
            tmpSb.append(".");

            // keep track of new sentence
            sentences[i] = tmpSb.toString();
        }
        return sentences;
    }

    private static void displaySentences(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            System.out.printf("Sentence #%02d: %s%n", (i+1), sentences[i]);
        }
    }

    public static void main(String[] args) {

        String[] sentences = createSentences(MAX_SENTENCES_COUNT);
        displaySentences(sentences);

    }
}
