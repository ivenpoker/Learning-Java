package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_17;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise_8_17 {

    private static Scanner input = new Scanner(System.in);
    private static final int EXIT_FAILURE = 1;

    private static void handleGameError(String errorMsg) {

        // Handling of game error here for now, is by displaying
        // a message to the user and terminating the application
        // at once.

        System.out.println(errorMsg);
        System.exit(EXIT_FAILURE);

    }

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        boolean keepPlaying = true;

        // Default player is O
        TicTacToe.BoardItem currPlayer = TicTacToe.BoardItem.O;
        TicTacToe.BoardItem winPlayer = TicTacToe.BoardItem.EMPTY;


        do {
            System.out.printf("\n%s\n", game);
            System.out.println("================================");

            switch (currPlayer) {
                case X: {
                    System.out.print("[X] Enter position [as: x y]: ");
                    int row = input.nextInt();
                    int col = input.nextInt();

                    while (!game.isRowValid(row) || !game.isColValid(col)) {
                        System.out.print("[X] Enter position [as: x y]: ");
                        row = input.nextInt();
                        col = input.nextInt();
                    }
                    if (game.makeMove(currPlayer, row, col)) {
                        winPlayer = currPlayer;
                        keepPlaying = false;
                    }
                    currPlayer = TicTacToe.BoardItem.O;
                    break;
                }

                case O: {
                    System.out.print("[O] Enter position [as: x y]: ");
                    int row = input.nextInt();
                    int col = input.nextInt();

                    while (!game.isRowValid(row) || !game.isColValid(col)) {
                        System.out.print("[X] Enter position [as: x y]: ");
                        row = input.nextInt();
                        col = input.nextInt();
                    }
                    if (game.makeMove(currPlayer, row, col)) {
                        winPlayer = TicTacToe.BoardItem.O;
                        keepPlaying = false;
                    }
                    currPlayer = TicTacToe.BoardItem.X;
                    break;
                }
                default:
                    handleGameError("============ [SYSTEM_ERROR] ===========");
                    break;
            }
            if (winPlayer != TicTacToe.BoardItem.EMPTY || game.isGameDraw()) {
                keepPlaying = false;
            }
        } while (keepPlaying);

        System.out.printf("\n%s\n", game);
        switch (winPlayer) {
            case EMPTY:
                System.out.printf("Game is a tie%n");
                break;
            case X:
                System.out.printf("Player X won!%n");
                break;
            case O:
                System.out.printf("Player O won!%n");
                break;
            default:
                handleGameError("============ [SYSTEM_ERROR] ===========");

        }
    }

}

class TicTacToe {

    public enum BoardItem {X, O, EMPTY}
    private static final int GAME_BOARD_SIZE = 3;

    private final BoardItem[][] board;

    public TicTacToe() {

        this.board = new BoardItem[TicTacToe.GAME_BOARD_SIZE][TicTacToe.GAME_BOARD_SIZE];
        for (BoardItem[] boardItems : this.board) {
            Arrays.fill(boardItems, BoardItem.EMPTY);
        }

    }

    public boolean makeMove(BoardItem player, int row, int col) {

        if (player == BoardItem.EMPTY) {
            throw new IllegalArgumentException("Invalid player");
        }

        // Check if the row index is valid.
        if (!this.isRowValid(row)) {
            throw new IllegalArgumentException("Invalid row specified");
        }

        // Check if the column index is valid.
        if (!this.isColValid(col)) {
            throw new IllegalArgumentException("Invalid  column specified");
        }

        // Check if the specified is available (is EMPTY)
        if (this.board[row][col] != BoardItem.EMPTY) {
            String message;
            if (this.board[row][col] == BoardItem.X) {
                message = String.format("Player X already played there [at (%d, %d)]", row, col);
            } else {
                message = String.format("Player O already played there [at (%d, %d)]", row, col);
            }
            throw new IllegalArgumentException(message);
        }

        // Indices are valid and position to play is available
        this.board[row][col] = player;

        return this.isWin(player);
    }

    public boolean isGameDraw() {
        if (!this.isWin(BoardItem.X) && !this.isWin(BoardItem.O)) {
            // since both players didn't win, we check to see if board is full
            boolean isBoardFull = true;
            for (BoardItem[] itemRow : this.board) {
                boolean cont = true;
                for (BoardItem boardItem : itemRow) {
                    if (boardItem == BoardItem.EMPTY) {
                        isBoardFull = false;
                        cont = false;
                        break;
                    }
                }
                if (!cont) {
                    break;
                }
            }
            return isBoardFull;
        }
        return false;
    }

    public boolean isWin(BoardItem player) {
        if (player == BoardItem.EMPTY) {
            throw new IllegalArgumentException("Invalid player specified");
        }
        // Check rows to see if player wins
        for (BoardItem[] itemRow : this.board) {
            int tmpCnt = 0;
            for (BoardItem boardItem : itemRow) {
                if (boardItem == player) {
                    tmpCnt += 1;
                }
            }
            // If number of occurrences of players code
            // equals the length of board, then players wins
            if (tmpCnt == this.board.length) {
                return true;
            }
        }

        // At this point no row as found in which player won,
        // we now try ALL columns to see if we can find a success.

        for (int i = 0; i < this.board.length; i++) {
            int tmpCnt = 0;
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[j][i] == player) {
                    tmpCnt += 1;
                }
            }
            if (tmpCnt == this.board.length) {
                return true;
            }
        }

        // At this point no row or column on board revealed that
        // user won, so we check diagonals.

        // Making sure our code runs only for square boards (future proofing)

        if (this.board.length == this.board[0].length) {

            // Left diagonal check
            int tmpCnt = 0;
            for (int i = 0; i < this.board.length; i++) {
                if (this.board[i][i] == player) {
                    tmpCnt += 1;
                }
            }
            if (tmpCnt == this.board.length) {
                return true;
            }

            // Right diagonal check
            tmpCnt = 0;
            for (int i = this.board.length-1; i >= 0; i--) {
                if (this.board[i][i] == player) {
                    tmpCnt += 1;
                }
            }
            return tmpCnt == this.board.length;
        }

        // If all else fails, player didn't win.
        return false;
    }

    public boolean isRowValid(int row) {
        return row >= 0 && row < this.board.length;
    }

    public boolean isColValid(int col) {
        return col >= 0 && col < this.board[0].length;
    }

    @Override
    public String toString() {
        String uiStr = "";
        for (BoardItem[] itemRow : this.board) {
            for (int i = 0; i < itemRow.length; i++) {
                BoardItem item = itemRow[i];
                String itemEquiv = item == BoardItem.O ? "O" : (item == BoardItem.X ? "X" : "E");
                if (i == itemRow.length-1) {
                    uiStr += String.format(" %s", itemEquiv);
                } else {
                    uiStr += String.format(" %s |", itemEquiv);
                }
            }
            uiStr += "\n";
        }
        return uiStr;
    }

}
