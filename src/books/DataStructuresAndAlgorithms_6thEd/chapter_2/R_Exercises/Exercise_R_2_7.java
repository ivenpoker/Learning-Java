// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-2.7 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 4/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_2.R_Exercises;

public class Exercise_R_2_7 {

    public static abstract class AbstractProgression {
        protected long _current;

        public AbstractProgression() {
            this(0);
        }

        public AbstractProgression(long start) {
            this._current = start;
        }

        public long nextValue() {
            long answer = this._current;
            this.advance();
            return answer;
        }

        protected abstract void advance();

        public void printProgression(int val) {
            System.out.print(this.nextValue());
            for (int j = 1; j < val; j++)
                System.out.print(" " + this.nextValue());
            System.out.println();
        }
    }

    public static class ArithmeticProgression extends AbstractProgression {
        protected long _increment;

        public ArithmeticProgression() {
            this(1, 0);
        }

        public ArithmeticProgression(long stepSize) {
            this(stepSize, 0);
        }

        public ArithmeticProgression(long stepSize, long start) {
            super(start);
            this._increment = stepSize;
        }

        protected void advance() {
            this._current += this._increment;
        }
    }

    public static void main(String[] args) {
        System.out.printf("Max integer value: %d\n", Integer.MAX_VALUE);

        int cnt = 0;                    // assuming increment starts are 0.
        int val = Integer.MAX_VALUE;
        while (val > 0) {
            cnt++;
            val -= 128;
        }
        System.out.printf("Number of 128's before overflow: %d\n", cnt);
    }
}
