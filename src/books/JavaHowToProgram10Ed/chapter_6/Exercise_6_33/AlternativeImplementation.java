package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_33;

import java.security.SecureRandom;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);
    private enum Status {CONTINUE, WON, LOST}

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_ELEVEN = 11;
    private static final int BOX_CARS = 12;

    public static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);

        int sum = die1 + die2;

        // display results of this roll
        System.out.printf("[%55s] | Player rolled %d + %d = %d%n", chatter(), die1, die2, sum);

        return sum;
    }

    public static double obtainUserWager(String message) {
        System.out.print(message);
        return input.nextDouble();
    }

    public static String chatter() {
        switch (randomNumbers.nextInt(3)) {
            case 0: return "Oh, you're going for broke, huh?";
            case 1: return "Aw c'mon, take a chance!";
            case 2: return "You're up big. Now's the time to cash in your chips!";
            default: return "Oops, game source code is messed up!";
        }
    }

    public static void main(String[] args) {

        int myPoint = 0;                // point if no win or loss on first role
        Status gameStatus;              // can contain CONTINUE, WON or LOST

        double bankBalance = 1000;
        double userWager = obtainUserWager("Enter a wager: ");

        while (userWager < bankBalance) {
            userWager = obtainUserWager(String.format("Enter a wager [> %.2f]: ", bankBalance));
        }


        int sumOfDice = rollDice();

        switch (sumOfDice) {
            case SEVEN:
            case YO_ELEVEN:
                gameStatus = Status.WON ;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                System.out.printf("%nPoint is: %d%n%n", myPoint);
                break;
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice();

            // determine game status
            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
            } else {
                if (sumOfDice == SEVEN) {
                    gameStatus = Status.LOST;
                }
            }
        }

        if (gameStatus == Status.WON) {
            bankBalance += userWager;
            System.out.printf("Player wins. New bank balance: $%.2f%n", bankBalance);
        } else {
            bankBalance -= userWager;
            System.out.printf("Player loses. %s%n", (bankBalance <= 0.0) ? "Sorry. You busted!" : "");
        }
    }
}
