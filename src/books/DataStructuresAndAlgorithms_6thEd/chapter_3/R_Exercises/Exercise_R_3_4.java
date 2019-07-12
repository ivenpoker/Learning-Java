// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.4 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 15/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.R_Exercises;

public class Exercise_R_3_4 {

    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;
    private int _board[][] = new int[3][3];
    private int _player;

    public static class TicTacToe {

    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                this._board[i][j] = EMPTY;
        this._player = X;
    }

    public void putMark(int i, int j) throws IllegalArgumentException, IllegalStateException {
        if (this.isWin(X) || this.isWin(O))
            throw new IllegalArgumentException("Game has already been won. Can't make a move");
        if (!this.inRange(0, i, 2) || !this.inRange(0, j, 2))
            throw new IllegalArgumentException("Invalid board position");
        if (this._board[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position occupied");
        this._board[i][j] = this._player;
        this._player = - this._player;
    }

    private boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
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
        return 0;  // tie
    }

}
