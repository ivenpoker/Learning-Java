package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_21;

import java.util.ArrayList;

public class TurtleGraphics {

    private final int DEFAULT_FLOOR_SIZE = 20;
    private final int MOVE_NUMBER_OF_SPACES = 10;
    public enum TurtleCommand {PEN_UP, PEN_DOWN, TURN_RIGHT, TURN_LEFT, TURN_UP,
                                 TURN_DOWN, MOVE_10_SPACES, DISPLAY_FLOOR, END_OF_DATA};
    private enum TurtleDirection {LEFT, RIGHT, UP, DOWN}

    private boolean isPenDown;
    private final int[][] floor;
    private final TurtlePoint currentPoint;
    private TurtleDirection currentDirection;
    private final ArrayList<TurtlePoint> pointsHistory;

    public TurtleGraphics(int floorSize) {
        if (floorSize < 0) {
            this.floor = new int[this.DEFAULT_FLOOR_SIZE][this.DEFAULT_FLOOR_SIZE];
        } else {
            this.floor = new int[floorSize][floorSize];
        }
        this.isPenDown = false;
        this.currentPoint = new TurtlePoint(0, 0);
        this.currentDirection = TurtleDirection.RIGHT;
        this.pointsHistory = new ArrayList<>();
    }

    private boolean inBounds(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private void updateHistory(TurtlePoint somePoint) {
        this.pointsHistory.add(new TurtlePoint(somePoint.getRowPos(), somePoint.getColPos()));
    }

    private boolean moveXSpaces() {
        switch (this.currentDirection) {
            case UP:
                if (this.currentPoint.getRowPos() - this.MOVE_NUMBER_OF_SPACES >= 0) {
                    this.updateHistory(this.currentPoint);
                    int currPosRow = this.currentPoint.getRowPos();
                    int currPosCol = this.currentPoint.getColPos();

                    if (this.isPenDown) {

                        // This iteration isn't optimal

                        for (int i = 0; i < this.floor.length; i++) {
                            for (int j = 0; j < this.floor[i].length; j++) {
                                if (this.inBounds(currPosRow-10, i, currPosRow) && (j == currPosCol)) {
                                    this.floor[i][j] = 1;
                                }
                            }
                        }
                    }
                    this.currentPoint.setRowPos(currPosRow - this.MOVE_NUMBER_OF_SPACES);
                } else {
                    return false;
                }
                break;

            case DOWN:

                // if there is space to move downwards
                if (this.currentPoint.getRowPos() + 10 < this.floor.length) {
                    this.updateHistory(this.currentPoint);
                    int currPosRow = this.currentPoint.getRowPos();
                    int currPosCol = this.currentPoint.getColPos();

                    if (this.isPenDown) {

                        // this iteration isn't optimal

                        for (int i = 0; i < this.floor.length; i++) {
                            for (int j = 0; j < this.floor[i].length; j++) {
                                if (this.inBounds(currPosRow, i, currPosRow + 10) && (j == currPosCol)) {
                                    this.floor[i][j] = 1;
                                }
                            }
                        }
                    }
                    this.currentPoint.setRowPos(currPosRow + this.MOVE_NUMBER_OF_SPACES);

                } else {
                    // No space to move 10 steps downwards
                    return false;
                }
                break;

            case LEFT:

                // if there is space to move to the left

                if (this.currentPoint.getColPos() - this.MOVE_NUMBER_OF_SPACES >= 0) {
                    this.updateHistory(this.currentPoint);
                    int currPosRow = this.currentPoint.getRowPos();
                    int currPosCol = this.currentPoint.getColPos();

                    if (this.isPenDown) {

                        // this iteration isn't optimal

                        for (int i = 0; i < this.floor.length; i++) {
                            for (int j = 0; j < this.floor[i].length; j++) {
                                if (this.inBounds(0, j, currPosCol) && (i == currPosRow)) {
                                    this.floor[i][j] = 1;
                                }
                            }
                        }
                    }
                    this.currentPoint.setColPos(currPosCol - this.MOVE_NUMBER_OF_SPACES);
                } else {
                    // No space to move 10 spaces to the left
                    return false;
                }
                break;

            case RIGHT:

                // if there is space to move to the right. Since the turtle's 'floor'
                // will have an equal width (number of columns all through) we can
                // just use the length ANY row (array) as the length of the 'floor'
                // width

                if (this.currentPoint.getColPos() + this.MOVE_NUMBER_OF_SPACES < this.floor[0].length) {
                    this.updateHistory(this.currentPoint);
                    int currPosRow = this.currentPoint.getRowPos();
                    int currPosCol = this.currentPoint.getColPos();

                    if (this.isPenDown) {

                        // This iteration isn't optimal

                        for (int i = 0; i < this.floor.length; i++) {
                            for (int j = 0; j < this.floor[i].length; j++) {
                                if (this.inBounds(currPosCol, j, this.floor[0].length) && (i == currPosRow)) {
                                    this.floor[i][j] = 1;
                                }
                            }
                        }
                    }
                    this.currentPoint.setColPos(currPosCol + this.MOVE_NUMBER_OF_SPACES);
                } else {
                    // No space to move 10 spaces to the left.
                    return false;
                }
                break;
        }
        return true;
    }

    public boolean executeCommand(TurtleCommand turtleCommand) {
        switch (turtleCommand) {
            case PEN_UP:
                this.isPenDown = false;
                break;

            case PEN_DOWN:
                this.isPenDown = true;
                break;

            case TURN_LEFT:
                this.currentDirection = TurtleDirection.LEFT;
                break;

            case TURN_RIGHT:
                this.currentDirection = TurtleDirection.RIGHT;
                break;

            case TURN_UP:
                this.currentDirection = TurtleDirection.UP;
                break;

            case TURN_DOWN:
                this.currentDirection = TurtleDirection.DOWN;
                break;

            case DISPLAY_FLOOR:
                System.out.println(this);   // implicitly call this class 'toString'

            case MOVE_10_SPACES:
                return this.moveXSpaces();

            case END_OF_DATA:
                break;

            default:
                System.out.println("%n%n\t\t================= [SYSTEM_ERROR: INVALID COMMAND] ==============%n%n");
                break;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        char charType;
        sb.append("\n=======================================\n");
        sb.append("\t\t\t[TURTLE FLOOR]");
        sb.append("\n=======================================\n");
        for (int i = 0; i < this.floor.length; i++) {
            for (int j = 0; j < this.floor[i].length; j++) {
                if (i == this.currentPoint.getRowPos() && j == this.currentPoint.getColPos()) {
                    charType = 'X';
                } else if (this.floor[i][j] == 0) {
                    charType = '.';
                } else {
                    charType = '#';
                }
                sb.append(String.format("%c%s", charType, j == this.floor[i].length-1 ? "" : " "));
            }
            sb.append("\n");
        }
        int currRowPos = this.currentPoint.getRowPos();
        int currColPos = this.currentPoint.getColPos();

        sb.append("\n=======================================\n");
        sb.append(String.format("Position: [%d, %d] | Pen status: [%s]", currRowPos, currColPos,
                                    this.isPenDown ? "PEN_DOWN" : "PEN_UP"));
        sb.append("\n=======================================\n");
        return sb.toString();
    }
}
