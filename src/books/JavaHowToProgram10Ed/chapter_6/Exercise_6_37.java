// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.37 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 09/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

import java.security.SecureRandom;
import java.util.Scanner;

public class Exercise_6_37 {
    private static final SecureRandom random = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);
    private static int maxInt = 10;
    private static final int maxQuestions = 10;
    private static enum State {CORRECT, INCORRECT, CONTINUE};
    private static final double passPercentage = 75;
    private static int level = 0;

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
        int numCorrect = 0;
        int numIncorrect = 0;
        int numQuestions = maxQuestions;
        Multiplicands mult = new Multiplicands(0, 0);
        setMultiplicands(mult);
        State caiState = State.CONTINUE;

        while (true) {
            System.out.printf("\n\t\t[=== LEVEL: %d ==]\n\n", level);
            do {
                System.out.printf("[%d left] %s", numQuestions, generateQuestion(mult));
                double userResp = input.nextInt();
                if (userResp == (mult.getA() * mult.getB())) {
                    numCorrect++;
                    System.out.printf("\n\t%s\n\n", getResponse());
                } else {
                    numIncorrect++;
                    System.out.println("\n\tAnswer is incorrect.\n");
                }
                setMultiplicands(mult);
            } while (numQuestions-- > 0); // 'caiState' is not modified intentionally.

            double correctPercent = ((double) numCorrect / maxQuestions) * 100;
            double incorrectPercent = ((double) numIncorrect / maxQuestions) * 100;

            System.out.printf("Statistic correct  : %%%.1f\nStatistic incorrect: %%%.1f\n",
                    correctPercent, incorrectPercent);

            if (correctPercent >= passPercentage) {
                System.out.print("\n\tCongratulations, you are ready to go to next level!\n");
                maxInt *= 10;
                level += 1;
            } else {
                System.out.print("\n\tPlease ask your teacher for extra help.\n");
            }
            numQuestions = maxQuestions;
            numCorrect = 0;
            numIncorrect = 0;

        }
    }

    public static String getResponse() {
        switch (1 + random.nextInt(4)) {
            case 1: return "Very good!";
            case 2: return "Excellent!";
            case 3: return "Nice work!";
            case 4: return "Keep up the good work!";
            default:
                return "";
        }
    }
}
