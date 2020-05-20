package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_18;

import java.security.SecureRandom;
import java.util.Arrays;

public class Craps {

    // Create a secure random number generator for use in method rollDice
    private  final SecureRandom randomNumbers = new SecureRandom();

    // Enum type with constants that represent the game status
    private enum Status {CONTINUE, WON, LOST}

    // Constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_ELEVEN = 11;
    private static final int BOX_CARS = 12;

    private final int numberOfGamesOfCraps;
    private final int DEFAULT_NUMBER_OF_CRAPS_GAMES = 100;
    private int[] winsTrack;
    private int[] losesTrack;

    public Craps(int maxNumberOfGames) {
        this.winsTrack = new int[maxNumberOfGames];
        this.losesTrack = new int[maxNumberOfGames];
        this.numberOfGamesOfCraps = maxNumberOfGames > 0 ? maxNumberOfGames : this.DEFAULT_NUMBER_OF_CRAPS_GAMES;
    }

    // Play game
    public void run() {

        System.out.print("Game started ... ");
        for (int i = 1; i <= this.numberOfGamesOfCraps; i++) {
            System.out.printf("\rPlaying game [#%d] | [%.0f%%]", i, ((double) i / this.numberOfGamesOfCraps) * 100);
            int myPoint = 0;
            Status gameStatus;

            int sumOfDice = this.rollDice();        // first roll of the dice

            // determine game status and point based on first roll
            switch (sumOfDice) {
                case SEVEN:
                case YO_ELEVEN:
                    gameStatus = Status.WON;
                    break;
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    gameStatus = Status.LOST;
                    break;
                default:
                    gameStatus = Status.CONTINUE;
                    myPoint = sumOfDice;
                   // System.out.printf("Point is %d%n", myPoint);
                    break;
            }

            // while game is not complete
            while (gameStatus == Status.CONTINUE) {
                sumOfDice = this.rollDice();

                // determine games status
                if (sumOfDice == myPoint) {
                    gameStatus = Status.WON;
                } else {
                    if (sumOfDice == SEVEN) {
                        gameStatus = Status.LOST;
                    }
                }
            }

            // Display won or lost message
            if (gameStatus == Status.WON) {
                this.winsTrack[i-1] += 1;
               // System.out.println("Player wins");
            } else {
                this.losesTrack[i-1] += 1;
               // System.out.println("Player loses");
            }
        }
    }

    public int[] getWinsTrack() {
        return Arrays.copyOf(this.winsTrack, this.winsTrack.length);
    }

    public int[] getLosesTrack() {
        return Arrays.copyOf(this.losesTrack, this.losesTrack.length);
    }

    private int rollDice() {
        // Pick random die values
        int die1 = 1 + this.randomNumbers.nextInt(6);       // first die roll
        int die2 = 1 + this.randomNumbers.nextInt(6);       // second die roll

        // Display results of this roll
       // System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
        return die1 + die2;
    }
}
