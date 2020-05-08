package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_39;

import java.security.SecureRandom;
import java.util.Scanner;

public class Exercise_6_39 {

    private static final SecureRandom random = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);
    private static final int NUMBER_OF_QUESTIONS = 5;
    private static final double PASS_PERCENTAGE = 75.0;
    private static final int EXIT_FAILURE = 1;

    private enum MenuOption {ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, RANDOM_MIXTURE, EXIT_PROGRAM}

    private static class MultQuestion {

        public final int operandA;
        public final int operandB;
        public final int answer;
        public final MenuOption operationChosen;

        public MultQuestion(int operandA, int operandB, MenuOption operationChosen) {
            this.operandA = operandA;
            this.operandB = operandB;
            this.operationChosen = operationChosen;
            switch (operationChosen) {
                case ADDITION:
                    this.answer = this.operandA + this.operandB;
                    break;
                case SUBTRACTION:
                    this.answer = this.operandA - this.operandB;
                    break;
                case MULTIPLICATION:
                    this.answer = this.operandA * this.operandB;
                    break;
                case DIVISION:
                    this.answer = this.operandA / this.operandB;
                    break;
                case RANDOM_MIXTURE:
                default:
                    this.answer = -1;
                    System.err.println("[INTERNAL-PROGRAM-ERROR]: Invalid operation chosen");
                    System.exit(EXIT_FAILURE);
                    break;
            }
        }

        public String getQuestionString() {
            String operationStr = "";
            switch (this.operationChosen) {
                case ADDITION:
                    operationStr = "added to";
                    break;
                case SUBTRACTION:
                    operationStr = "subtracted from";
                    break;
                case MULTIPLICATION:
                    operationStr = "multiplied by";
                    break;
                case DIVISION:
                    operationStr = "divided by";
            }
            return String.format("How much is %d %s %d ?: " ,
                    this.operandA, operationStr, this.operandB);
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

    private static MultQuestion getNewQuestion(int userLevel, MenuOption operationChosen) {
        int valA = ((int) (Math.pow(10, userLevel)) / 10) + (random.nextInt((int) Math.pow(10, userLevel)) - 1);
        int valB = ((int) (Math.pow(10, userLevel)) / 10) + (random.nextInt((int) Math.pow(10, userLevel)) - 1);
        return new MultQuestion(valA, valB, operationChosen);
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

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private static MenuOption displayAppMenu() {
        System.out.println("\n============== [PROGRAM MENU] ===============");
        System.out.println("1. Addition problems");
        System.out.println("2. Subtraction problems");
        System.out.println("3. Multiplication problems");
        System.out.println("4. Division problems");
        System.out.println("5. Random from above options");
        System.out.println("6. Exit program");
        System.out.println("================================================");
        System.out.print("Enter your choice: ");
        int userChoice = input.nextInt();

        while (!inRange(1, userChoice, 6)) {
            System.out.print("Enter a valid choice [1 ... 5]: ");
            userChoice = input.nextInt();
        }
        System.out.println("================================================");
        switch (userChoice) {
            case 1: return MenuOption.ADDITION;
            case 2: return MenuOption.SUBTRACTION;
            case 3: return MenuOption.MULTIPLICATION;
            case 4: return MenuOption.DIVISION;
            case 6: return MenuOption.EXIT_PROGRAM;
            case 5:
            default:
                int randomChoice = 1 + random.nextInt(4);
                switch (randomChoice) {
                    case 1: return MenuOption.ADDITION;
                    case 2: return MenuOption.SUBTRACTION;
                    case 3: return MenuOption.MULTIPLICATION;
                    case 4:
                    default:
                        return MenuOption.DIVISION;
                }
        }
    }

    public static void main(String[] args) {

        int numQuestions = NUMBER_OF_QUESTIONS;
        int solvedCnt = 0;
        int userLevel = getUserDifficultyLevel();

        do {
            MenuOption operationChosen = displayAppMenu();
            if (operationChosen == MenuOption.EXIT_PROGRAM) {
                break;
            }
            MultQuestion question = getNewQuestion(userLevel, operationChosen);
            while (true) {
                System.out.printf("[%02d left] %s",numQuestions,  question.getQuestionString());
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

                    break;
                } else {
                    question = getNewQuestion(userLevel, operationChosen);
                }
            }
        } while (true);
    }
}
