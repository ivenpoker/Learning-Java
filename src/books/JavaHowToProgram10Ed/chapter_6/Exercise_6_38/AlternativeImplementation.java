package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_38;

import java.security.SecureRandom;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final SecureRandom random = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);
    private static final int NUMBER_OF_QUESTIONS = 5;
    private static final double PASS_PERCENTAGE = 75.0;

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

    private static MultQuestion getNewQuestion(int userLevel) {
        int valA = ((int) (Math.pow(10, userLevel)) / 10) + (random.nextInt((int) Math.pow(10, userLevel)) - 1);
        int valB = ((int) (Math.pow(10, userLevel)) / 10) + (random.nextInt((int) Math.pow(10, userLevel)) - 1);
        return new MultQuestion(valA, valB);
    }

    private static int getUserDifficultyLevel() {
        System.out.print("Enter level you want start test: ");
        int userLevel = input.nextInt();
        while (userLevel <= 0) {
            System.out.print("Enter level you want start test [must be > 0]: ");
            userLevel = input.nextInt();
        }
        return userLevel;
    }

    public static void main(String[] args) {

        int numQuestions = NUMBER_OF_QUESTIONS;
        int solvedCnt = 0;

        int userLevel = getUserDifficultyLevel();

        MultQuestion question = getNewQuestion(userLevel);


        while (true) {
            System.out.printf("[%02d left] How much is %d times %d ?: ",numQuestions,  question.operandA, question.operandB);
            int userResp = input.nextInt();

            if (userResp == question.answer) {
                solvedCnt += 1;
                System.out.printf("\n%s\n\n", getRandomCorrectAnswerResponse());
            } else {
                System.out.printf("\n%s\n\n", getRandomIncorrectAnswerResponse());
            }
            numQuestions -= 1;
            if (numQuestions == 0) {
                // compute percentage
                double perc = ((double)solvedCnt / NUMBER_OF_QUESTIONS) * 100;
                if (perc >= PASS_PERCENTAGE) {
                    System.out.printf("Congratulations (%.2f%% passed), you are ready to go to the next level\n\n", perc);
                } else {
                    System.out.printf("Please ask your teacher for extra help (%.2f%% passed)\n\n", perc);
                }

                // we now reset program for another person
                numQuestions = NUMBER_OF_QUESTIONS;
                solvedCnt = 0;
                userLevel = getUserDifficultyLevel();
            } else {
                question = getNewQuestion(userLevel);
            }
        }



    }
    
}
