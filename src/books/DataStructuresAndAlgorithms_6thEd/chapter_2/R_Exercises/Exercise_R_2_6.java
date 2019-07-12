// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-2.6 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 4/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_2.R_Exercises;

public class Exercise_R_2_6 {

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

    public static class FibonacciProgression extends AbstractProgression {
        protected long _prev;

        public FibonacciProgression() {
            this(0, 1);
        }

        public FibonacciProgression(long first, long second) {
            super(first);
            this._prev = second - first;
        }

        protected void advance() {
            long temp = this._prev;
            this._prev = this._current;
            this._current += temp;
        }
    }

    public static void main(String[] args) {
        AbstractProgression fibProgression = new FibonacciProgression(2, 2);

        // we call the 'nextValue()' six (6) times, since
        // we already have the first 2.

        int n = 6;
        while (n-- >= 0)
            fibProgression.nextValue();
        long val = fibProgression.nextValue();

        System.out.printf("The 8th fibonacci number [start: 2 2]: %d\n", val);
        fibProgression = new FibonacciProgression(2, 2);

        System.out.print("First 10 fibonacci numbers [start: 2 2]: ");
        fibProgression.printProgression(10);
        System.out.println();
    }
}
