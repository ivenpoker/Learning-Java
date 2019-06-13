// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.21 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 11/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercises;

import java.util.Scanner;

public class Exercise_7_21 {

    public static class TurtleGraphics {
        private class PenPos {
            private int _xCord;
            private int _yCord;

            public PenPos(int xCord, int yCord) {
                this._xCord = xCord;
                this._yCord = yCord;
            }
            int getX() {
                return this._xCord;
            }
            int getY() {
                return this._yCord;
            }
            void setX(int newCordX) {
                this._xCord = newCordX;
            }
            void setY(int newCordY) {
                this._yCord = newCordY;
            }
        }

        private final int _boardRow;
        private final int _boardCol;
        private int[][] _board;
        private PenPos _penPos;
        private char _fillChar;

        private enum PenStatus {PEN_DOWN, PEN_UP}
        private PenStatus _penStatus;

        public static enum Command {PEN_UP, PEN_DOWN, TURN_RIGHT, TURN_LEFT, TURN_UP, TURN_DOWN,
                                     MOVE_FORWARD_10_SPACES, DISPLAY_BOARD, END_OF_DATA};

        public TurtleGraphics(int row, int col, char filChar) {
            this._boardRow  = row;
            this._boardCol  = col;
            this._board     = new int[row][col];
            this._penPos    = new PenPos(0, 0);
            this._penStatus = PenStatus.PEN_UP;              // the pen is currently up!
            this._fillChar  = filChar;
        }

        public void runCommand(Command command) {
            switch (command) {
                case PEN_DOWN:
                    if (this._penStatus == PenStatus.PEN_UP)
                        this._penStatus = PenStatus.PEN_DOWN;
                    break;
                case PEN_UP:
                    if (this._penStatus == PenStatus.PEN_DOWN)
                        this._penStatus = PenStatus.PEN_UP;
                    break;
                case TURN_UP: this.turnUp(); break;
                case TURN_DOWN: this.turnDown(); break;
                case TURN_RIGHT: this.turnRight(); break;
                case TURN_LEFT : this.turnLeft(); break;
                case MOVE_FORWARD_10_SPACES: this.moveForward(10); break;
                case DISPLAY_BOARD: this.displayBoard(); break;
                case END_OF_DATA: handleEndData(); break;

            }
        }

        private void turnUp() {
           if (this._penPos.getX()-1 >= 0) {
               if (this._penStatus == PenStatus.PEN_DOWN)
                   this._board[this._penPos.getX()][this._penPos.getY()] = 1;
               this._penPos.setX(this._penPos.getX()-1);
           }
           // At this point the value we've got an invalid move.
        }

        private void turnDown() {
            if (this._penPos.getX() + 1 < this._boardRow) {
                if (this._penStatus == PenStatus.PEN_DOWN)
                    this._board[this._penPos.getX()][this._penPos.getY()] = 1;
                this._penPos.setX(this._penPos.getX() + 1);
            }
        }
        private void turnRight() {
            if (this._penPos.getY() + 1 < this._boardCol) {
                if (this._penStatus == PenStatus.PEN_DOWN) {
                    this._board[this._penPos.getX()][this._penPos.getY()] = 1; // 1 for a pen down
                }
                this._penPos.setY(this._penPos.getY() + 1);
            }
        }

        private void turnLeft() {
            if (this._penPos.getY() - 1 >= 0) {
                if (this._penStatus == PenStatus.PEN_DOWN)
                    this._board[this._penPos.getX()][this._penPos.getY()] = 1; // 1 for a pen down
                this._penPos.setY(this._penPos.getY()-1);
            }
        }

        private void moveForward(int moveCnt) {
            if (moveCnt >= 0) {
                if (this._penPos.getY() + moveCnt < this._boardCol) {
                    if (this._penStatus == PenStatus.PEN_DOWN) {
                        for (int i = 0; i < moveCnt; i++)
                            this._board[this._penPos.getX()][this._penPos.getY() + i] = 1; // 1 for a pen down
                    }
                    this._penPos.setY(this._penPos.getY() + moveCnt);
                }
                // At this point, we get an illegal move. Requested number of moves
                // is greater than board size.
            }
            // At this point, we have a negative move which is invalid.
        }

        private void displayBoard() {
            for (int i = 0; i < this._board.length; i++) {
                for (int j = 0; j < this._board[i].length; j++)
                    System.out.printf("%c%s", (this.isCurrentPos(i,j) ? 'X' :
                            (this._board[i][j] == 0 ? '.' : this._fillChar)), (j == this._board[i].length-1) ? "\n" : " ");
            }
            System.out.printf("\nPosition: [%d, %d] -- [Pen status: %s]\n",
                    this._penPos.getX(), this._penPos.getY(), (this._penStatus == PenStatus.PEN_DOWN) ? "DOWN" : "UP");
        }

        private boolean isCurrentPos(int i, int j) {
            return this._penPos.getX() == i && this._penPos.getY() == j;
        }

        private void handleEndData() {
            // some code here...
        }


    }

    public static void main(String[] args) {
        TurtleGraphics graphics = new TurtleGraphics(20, 20, '#');
        boolean programContinue = true;

        System.out.println("[++++++ TURTLE GRAPHICS PROGRAM ++++++]");
        while (programContinue) {
           int userChoice =  displayMenu();
           switch (userChoice) {
               case 1: graphics.runCommand(TurtleGraphics.Command.PEN_UP); break;
               case 2: graphics.runCommand(TurtleGraphics.Command.PEN_DOWN); break;
               case 3: graphics.runCommand(TurtleGraphics.Command.TURN_RIGHT); break;
               case 4: graphics.runCommand(TurtleGraphics.Command.TURN_LEFT); break;
               case 5: graphics.runCommand(TurtleGraphics.Command.TURN_UP); break;
               case 6: graphics.runCommand(TurtleGraphics.Command.TURN_DOWN); break;
               case 7: graphics.runCommand(TurtleGraphics.Command.MOVE_FORWARD_10_SPACES); break;
               case 8: graphics.runCommand(TurtleGraphics.Command.DISPLAY_BOARD); break;
               case 9: break; // not yet implemented
               case 10:
               default:
                   programContinue = false;
           }
        }
        graphics.displayBoard();
    }

    private static int displayMenu() {
        System.out.println("\n--------- COMMAND MENU --------------");
        System.out.println("\t1.  Pen Up");
        System.out.println("\t2.  Pen Down");
        System.out.println("\t3.  Turn Right");
        System.out.println("\t4.  Turn Left");
        System.out.println("\t5.  Turn Up");
        System.out.println("\t6.  Turn Down");
        System.out.println("\t7.  Move forward 10 spaces");
        System.out.println("\t8.  Display Board");
        System.out.println("\t9.  End of data");
        System.out.println("\t10. End program");
        System.out.println("--------------------------------------");
        System.out.print("\tEnter your choice: ");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        while (choice < 1 || choice > 10) {
            System.out.print("\n\tEnter VALID choice: ");
            choice = input.nextInt();
        }
        System.out.println("--------------------------------------");
        return choice;
    }
}
