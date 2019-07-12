// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C-3.19 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 23/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.C_Exercises;

import java.util.LinkedList;
import java.util.List;

public class Exercise_C_3_19 {

    public static class GameEntry {
        private String name;
        private int score;

        public GameEntry(String name, int score) {
            this.name  = name;
            this.score = score;
        }
        public String getName() {
            return this.name;
        }
        public int getScore() {
            return this.score;
        }
        public String toString() {
            return "(" + this.name + ", " + this.score + ")";
        }
    }

    public static class ScoreBoard {
        private int numEntries = 0;
//        private GameEntry[] board;
//
//        public ScoreBoard(int capacity) {
//            this.board = new GameEntry[capacity];
//        }
//
//        public void add(GameEntry entry) {
//            int newScore = entry.getScore();
//            if (this.numEntries < this.board.length || newScore > this.board[numEntries-1].getScore()) {
//                if (this.numEntries < this.board.length)
//                    this.numEntries++;
//                int j = numEntries-1;
//                while (j > 0 && this.board[j-1].getScore() < newScore) {
//                    this.board[j] = this.board[j-1];
//                    j--;
//                }
//                this.board[j] = entry;
//            }
//        }
//
//        public GameEntry remove(int ind) throws IndexOutOfBoundsException {
//            if (ind < 0 || ind >= numEntries)
//                throw new IndexOutOfBoundsException("Invalid index: " + ind);
//            GameEntry temp = this.board[ind];
//
//            for (int j = ind; j < this.numEntries-1; j++)
//                this.board[j] = this.board[j+1];
//            this.board[numEntries-1] = null;
//            this.numEntries--;
//            return temp;
//        }
        private List<GameEntry> board;
        private int capacity;

        public ScoreBoard(int capacity) {
            this.capacity = capacity;
            this.board = new LinkedList<>();            // we could have used the Chapter own list classes (or API)
        }

        public void add(GameEntry newEntry) throws IllegalStateException {
            if (this.numEntries < this.capacity) {
                this.board.add(newEntry);               // we could have used the 'addFirst' method for the chapter LIST API
                this.numEntries++;
            } else {
                throw new IllegalStateException("Cannot add to list. Limit reached!");
            }
        }

        public void remove(int ind) throws IndexOutOfBoundsException {
            if (ind < 0 || ind > this.numEntries)
                throw new IndexOutOfBoundsException("Invalid index: " + ind);
            this.board.remove(ind);     // we could have use the functionalities from the API itself.
        }

    }
}
