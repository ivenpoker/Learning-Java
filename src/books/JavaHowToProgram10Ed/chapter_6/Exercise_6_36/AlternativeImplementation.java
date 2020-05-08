package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_36;

import java.security.SecureRandom;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final SecureRandom random = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);

    private enum QuestionState {SOLVED, NOT_SOLVED}

    private static class MultQuestion {

        public final int operandA;
        public final int operandB;
        public final int answer;

        public MultQuestion(int operandA, int operandB) {
            this.operandA = operandA;
            this.operandB = operandB;
            this.answer = operandA * operandB;
        }
    }

    private static String getRandomCorrectAnswerResponse() {
        switch (random.nextInt(4)) {
            case 0: return "Very good!";
            case 1: return "Excellent";
            case 2: return "Nice work!";
            case 3: return "Keep up the good work!";
            default: return "Excellent work there!";
        }
    }

    private static String getRandomIncorrectAnswerResponse() {
        switch (random.nextInt(4)) {
            case 0: return "No. Please try again.";
            case 1: return "Wrong. Try once more";
            case 2: return "Don't give up!";
            case 3: return "Keep trying";
            default: return "Oops, that ain't right!";
        }
    }

    private static MultQuestion getNewQuestion() {
        int valA = random.nextInt(10);
        int valB = random.nextInt(10);
        return new MultQuestion(valA, valB);
    }

    public static void main(String[] args) {

        MultQuestion question = getNewQuestion();
        QuestionState qState = QuestionState.NOT_SOLVED;

        do {
            while (qState == QuestionState.NOT_SOLVED) {
                System.out.printf("How much is %d times %d ?: ", question.operandA, question.operandB);
                int userResp = input.nextInt();

                if (userResp == question.answer) {
                    qState = QuestionState.SOLVED;
                    System.out.printf("\n%s\n\n", getRandomCorrectAnswerResponse());
                } else {
                    System.out.printf("\n%s\n\n", getRandomIncorrectAnswerResponse());
                }
            }
            question = getNewQuestion();
            qState = QuestionState.NOT_SOLVED;
        } while (true);

    }
}
