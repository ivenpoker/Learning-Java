// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.30 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 09/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.security.SecureRandom;
import java.util.Scanner;

public class Exercise_6_30 {

    private static SecureRandom random = new SecureRandom();
    private enum State {CONTINUE, WIN, PLAY, EXIT_GAME}
    private static int computerGuess;

    private static void setGuess() {
        computerGuess = 1 + random.nextInt(1000);
    }

    private static int getGuess() {
        return computerGuess;
    }

    private static boolean isGuessValid(int someGuess) {
        return computerGuess == someGuess;
    }

    public static void main(String[] args) {
        State gameState = State.PLAY;
        Scanner input = new Scanner(System.in);
        setGuess();

        while (gameState != State.EXIT_GAME) {
            System.out.print("\n[== Computer has GUESSED ==]\n\n");
            gameState = State.CONTINUE;
            do {
                System.out.print("Enter your guess of the number: ");
                int userGuess = input.nextInt();
                if (!isGuessValid(userGuess)) {
                    if (userGuess < getGuess()) {
                        System.out.println("Oops! Guess to LOW. Try again.");
                    } else {
                        System.out.println("Oops! Guess to HIGH. Try again.");
                    }
                } else {
                    gameState = State.WIN;
                }
            } while (gameState == State.CONTINUE);

            System.out.print("\n\t\tYou win!\n\n\tWant to play again ? (y/n): ");
            char tmp = input.next().charAt(0);
            if (tmp == 'n' || tmp == 'N')
                gameState = State.EXIT_GAME;
        }

    }
}
