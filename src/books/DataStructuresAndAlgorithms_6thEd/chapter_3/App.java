package books.DataStructuresAndAlgorithms_6thEd.chapter_3;

public class App {

    private class GameEntry {
        public String _name;
        private int _score;

        public GameEntry(String name, int score) {
            this._name = name;
            this._score = score;
        }

        public String getName() {
            return this._name;
        }

        public int getScore() {
            return this._score;
        }

        public String toString() {
            return "(" + this._name + ", " + this._score + ")";
        }
    }

    public class ScoreBoard {
        private int _numEntries = 0;
        private GameEntry[] _board;

        public ScoreBoard(int capacity) {
            this._board = new GameEntry[capacity];
        }

        public void add(GameEntry entry) {
            int newScore = entry.getScore();
            if (this._numEntries < this._board.length ||
                    newScore > this._board[_numEntries-1].getScore()) {
                if (this._numEntries < this._board.length)
                    this._numEntries++;
                int j = this._numEntries - 1;
                while (j > 0 && this._board[j-1].getScore() < newScore) {
                    this._board[j] = this._board[j - 1];
                    j--;
                }
                this._board[j] = entry;
            }
        }
        public GameEntry remove(int ind) throws IndexOutOfBoundsException {
            if (ind < 0 || ind >= this._numEntries)
                throw new IndexOutOfBoundsException("Invalid index: " + ind);
            GameEntry temp = this._board[ind];
            for (int j = ind; j < this._numEntries-1; j++)
                this._board[j] = this._board[j+1];
            this._board[this._numEntries-1] = null;
            this._numEntries--;

            return temp;
        }
    }

    public static void main(String[] args) {
//        CaesarCipher cipher = new CaesarCipher(3);
//        System.out.println("Encryption code = " + new String(cipher._encoder));
//        System.out.println("Decryption code = " + new String(cipher._decoder));
//
//        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
//        String coded   = cipher.encrypt(message);
//
//        System.out.println("Secret: " + coded);
//        String answer = cipher.decrypt(coded);
//        System.out.println("Message: " + answer);

        TicTacToe game = new TicTacToe();

        game.putMark(1,1);  game.putMark(0,2);
        game.putMark(2,2);  game.putMark(0,0);
        game.putMark(0,1);  game.putMark(2,1);
        game.putMark(1,2);  game.putMark(1,0);
        game.putMark(2,0);

        System.out.println(game);
        int winningPlayer = game.winner();

        String[] outcome = {"O wins", "Tie", "X wins"};
        System.out.println();
        System.out.println(outcome[1 + winningPlayer]);

    }

    public static class CaesarCipher {
        protected char[] _encoder = new char[26];
        protected char[] _decoder = new char[26];

        public CaesarCipher(int rotation) {
            for (int k = 0; k < 26; k++) {
                this._encoder[k] = (char) ('A' + (k + rotation) % 26);
                this._decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
            }
        }

        public String encrypt(String message) {
            return this.transform(message, this._encoder);
        }
        public String decrypt(String secret) {
            return this.transform(secret, this._decoder);
        }
        private String transform(String original, char[] code) {
            char[] msg = original.toCharArray();
            for (int k = 0; k < msg.length; k++) {
                if (Character.isUpperCase(msg[k])) {
                    int j = msg[k] - 'A';
                    msg[k] = code[j];
                }
            }
            return new String(msg);
        }
    }

    public static class TicTacToe {
        public static final int X = 1, O = -1;
        public static final int EMPTY = 0;
        public int _board[][] = new int[3][3];
        private int _player;

        public TicTacToe() {
            this.clearBoard();
        }

        public void clearBoard() {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    this._board[i][j] = EMPTY;
            this._player = X;
        }

        public void putMark(int i, int j) throws IllegalArgumentException {
            if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
                throw new IllegalArgumentException("Invalid board position");
            if (this._board[i][j] != EMPTY)
                throw new IllegalArgumentException("Board position occupied");
            this._board[i][j] = this._player;
            this._player = - this._player;
        }

        public boolean isWin(int mark) {
            return ((this._board[0][0] + this._board[0][1] + this._board[0][2] == mark * 3)
                || (this._board[1][0] + this._board[1][1] + this._board[1][2] == mark * 3)
                || (this._board[2][0] + this._board[2][1] + this._board[2][2] == mark * 3)
                || (this._board[0][0] + this._board[1][0] + this._board[2][0] == mark * 3)
                || (this._board[0][1] + this._board[1][1] + this._board[2][1] == mark * 3)
                || (this._board[0][2] + this._board[1][2] + this._board[2][2] == mark * 3)
                || (this._board[0][0] + this._board[1][1] + this._board[2][2] == mark * 3)
                || (this._board[2][0] + this._board[1][1] + this._board[0][2] == mark * 3));
        }

        public int winner() {
            if (this.isWin(X)) return X;
            if (this.isWin(O)) return O;

            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    switch (this._board[i][j]) {
                        case X:         sb.append("X"); break;
                        case O:         sb.append("O"); break;
                        case EMPTY:     sb.append(" "); break;
                    }
                    if (j < 2) sb.append("|");
                }
                if (i < 2) sb.append("\n-----\n");
            }
            return sb.toString();
        }
    }

}












































