// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.33 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 09/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_33;

import java.security.SecureRandom;
import java.util.Scanner;

public class Exercise_6_33 {

    private static final SecureRandom randomNumbers = new SecureRandom();
    private enum Status {CONTINUE, WON, LOST};

    private static final int SNAKE_EYES  = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_ELEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int myPoint = 0;
        Status gamesStatus;
        double bankBalance = 1000;

        System.out.print("Enter a wager: ");
        double wager = input.nextDouble();

        while (wager < bankBalance) {
            System.out.printf("Enter wager ( <= %.1f ): ", bankBalance);
            wager = input.nextDouble();
        }
        System.out.println();

        int sumOfDice = rollDice();
        switch (sumOfDice) {
            case SEVEN:
            case YO_ELEVEN:
                gamesStatus = Status.WON;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gamesStatus = Status.CONTINUE;
                break;
            default:
                gamesStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                System.out.printf("\nPoint is %d%n\n", myPoint);
                break;
        }
        while (gamesStatus == Status.CONTINUE) {
            sumOfDice = rollDice();
            if (sumOfDice == myPoint) {
                gamesStatus = Status.WON;
            } else {
                if (sumOfDice == SEVEN) {
                    gamesStatus = Status.LOST;
                } else {
                    chatter();
                }
            }
        }
        if (gamesStatus == Status.WON) {
            bankBalance += wager;
            System.out.printf("\nPlayer wins! New bank balance: $%.1f\n", bankBalance);
        } else {
            bankBalance -= wager;
            System.out.printf("\nPlayer loses! New bank balance: $%.1f\n", bankBalance);
            if (bankBalance == 0) {
                System.out.print("\nSorry you're busted!\n");
            }
        }
    }

    public static void chatter() {
        switch (1 + randomNumbers.nextInt(3)) {
            case 1:
                System.out.print("\nOh, you're going for broke, huh?\n\n");
                break;
            case 2:
                System.out.print("\nAw c'mon, take a chance!\n\n");
                break;
            case 3:
                System.out.print("\nYou're up big. Now's the time to cash in your chips!\n\n");
                break;
            default:
                break;
        }
    }

    public static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);

        int sum  = die1 + die2;
        System.out.printf("Player rolled %d + %d = %d%n",
                die1, die2, sum);

        return sum;
    }
}
