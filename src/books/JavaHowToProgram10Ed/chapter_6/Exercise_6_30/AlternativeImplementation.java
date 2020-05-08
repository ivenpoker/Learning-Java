package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_30;

import java.security.SecureRandom;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final int RANDOM_LOWER_BOUND = 1;
    private static final int RANDOM_UPPER_BOUND = 1000;

    private static final SecureRandom random = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);

    private enum GuessState {FOUND, NOT_FOUND}

    private static int selectNumberInRange(int lower, int upper) {
        return lower + random.nextInt(upper);
    }

    private static int obtainUserGuessedNumber(String message) {
        System.out.print(message);
        return input.nextInt();
    }

    public static void main(String[] args) {

        int gameGuess = selectNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
        GuessState userGuessState = GuessState.NOT_FOUND;
        boolean playAgain = false;

        do {
            while (userGuessState == GuessState.NOT_FOUND) {

                int userGuess = obtainUserGuessedNumber(String.format("\nGuess a number between %d and %d: ",
                        RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND));

                if (userGuess == gameGuess) {
                    System.out.println("\n==== Congratulations. You guessed the number! ====");
                    userGuessState = GuessState.FOUND;
                } else {
                    if (userGuess < gameGuess) {
                        System.out.println("Too low. Try again");
                    } else {
                        System.out.println("Too high. Try again");
                    }
                }
            }
            System.out.print("\nDo you want to play again ? [y/n]: ");
            char resp = input.next().charAt(0);

            if (resp == 'y' || resp == 'Y') {
                gameGuess = selectNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
                userGuessState = GuessState.NOT_FOUND;
                playAgain = true;
            } else {
                playAgain = false;
            }
        } while (playAgain);
    }

}
