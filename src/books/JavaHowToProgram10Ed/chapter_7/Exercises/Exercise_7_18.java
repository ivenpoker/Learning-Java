// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.18 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 11/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercises;

import java.security.SecureRandom;

public class Exercise_7_18 {
    private static final SecureRandom random = new SecureRandom();
    private enum Status {CONTINUE, WON, LOST};

    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_ELEVEN = 11;
    private static final int BOX_CARS = 12;

    private static final int MAX_NUM_RUNS = 1_000_000;

    public static void main(String[] args) {
        int times = MAX_NUM_RUNS;
        while (times-- > 0) {
            int myPoint = 0;
            Status gamesStatus;

            int sumOfDice = rollDice();

            switch (sumOfDice) {
                case SEVEN:
                case YO_ELEVEN:
                    gamesStatus = Status.WON;
                    break;
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    gamesStatus = Status.LOST;
                    break;
                default:
                    gamesStatus = Status.CONTINUE;
                    myPoint = sumOfDice;
                    System.out.printf("Point is %d%n", myPoint);
                    break;
            }
            while (gamesStatus == Status.CONTINUE) {
                sumOfDice = rollDice();
                if (sumOfDice == myPoint)
                    gamesStatus = Status.WON;
                else
                if (sumOfDice == SEVEN)
                    gamesStatus = Status.LOST;
            }
            if (gamesStatus == Status.WON)
                System.out.print("Player wins");
            else
                System.out.print("Player loses");
        }
    }

    public static int rollDice() {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        int sum = die1 + die2;

        System.out.printf("Player rolled %d + %d = %d%n",
                die1, die2, sum);
        return sum;
    }

}
