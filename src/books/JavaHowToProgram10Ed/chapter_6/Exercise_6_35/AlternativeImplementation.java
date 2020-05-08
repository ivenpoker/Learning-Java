package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_35;

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
                    System.out.println("\nVery good!\n");
                } else {
                    System.out.println("\nNo. Please try again.\n");
                }
            }
            question = getNewQuestion();
            qState = QuestionState.NOT_SOLVED;
        } while (true);

    }
}
