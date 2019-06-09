// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.35 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 09/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.util.Scanner;
import java.security.SecureRandom;

public class Exercise_6_35 {

    private static final SecureRandom random = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);
    private static final int maxInt = 10;
    private static enum State {CORRECT, INCORRECT, CONTINUE};

    private static class Multiplicands {
        private int _valA;
        private int _valB;

        public Multiplicands(int valA, int valB) {
            this._valA = valA;
            this._valB = valB;
        }
        public int getA() { return this._valA; }
        public int getB() { return this._valB; }
        public void setA(int newA) { this._valA = newA; }
        public void setB(int newB) { this._valB = newB; }
    }

    private static void setMultiplicands(Multiplicands mult) {
        mult.setA(1 + random.nextInt(maxInt));
        mult.setB(1 + random.nextInt(maxInt));
    }

    private static String generateQuestion(Multiplicands mult) {
        return "How much is " + mult.getA() + " times " + mult.getB() +" ?: ";
    }


    public static void main(String[] args) {
        Multiplicands mult = new Multiplicands(0, 0);
        setMultiplicands(mult);
        State caiState = State.CONTINUE;

        do {
            System.out.printf("%s", generateQuestion(mult));
            double userResp = input.nextInt();
            if (userResp == (mult.getA() * mult.getB())) {
                System.out.println("\n\tVery good!\n");
                setMultiplicands(mult);
            } else {
                System.out.println("\n\tNo. Please try again.\n");
            }
        } while (caiState == State.CONTINUE);
    }
}
