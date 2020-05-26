package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_21;

public class TurtlePoint {

    private int rowPos;
    private int colPos;

    public TurtlePoint(int rowPos, int colPos) {
        this.rowPos = rowPos;
        this.colPos = colPos;
    }

    public int getRowPos() {
        return this.rowPos;
    }

    public int getColPos() {
        return this.colPos;
    }

    public void setRowPos(int newRowPos) {
        this.rowPos = newRowPos;
    }

    public void setColPos(int newColPos) {
        this.colPos = newColPos;
    }
}

