// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.29 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_29;

import java.security.SecureRandom;
import java.util.Scanner;

public class Exercise_6_29 {

    private static SecureRandom random = new SecureRandom();
    private static enum Coin {HEAD, TAIL};

    private static Coin flip() {
        return (random.nextInt(2) == 0 ? Coin.HEAD : Coin.TAIL);
    }

    private static void toss() {
        int headCount = 0;
        int tailCount = 0;

        for (int i = 0; i < 6_000_000; i++) {
            switch (flip()) {
                case HEAD: headCount++; break;
                case TAIL: tailCount++; break;
                default:
                    System.out.print("[ERROR]");
                    break;
            }
        }
        System.out.printf("\tAfter %d simulations: [HEADS: %d, TAILS: %d]\n",
                6_000_000, headCount, tailCount);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.print("\n\t[==== COIN TOSSING PROGRAM ====]\n\n");
            System.out.print("\t1. Toss coin 6 million times\n");
            System.out.print("\t2. Quit program\n");
            System.out.print("\t-----------------------------------------\n");
            System.out.print("\tEnter your choice: ");

            choice = input.nextInt();
            System.out.print("\t-----------------------------------------\n");
            if (choice == 1) {
                toss();
                System.out.print("\t-----------------------------------------\n");
            } else if (choice == 2){
            } else {
                System.out.print("\tInvalid choice\n");
            }
        } while (choice != 2);
    }
}
