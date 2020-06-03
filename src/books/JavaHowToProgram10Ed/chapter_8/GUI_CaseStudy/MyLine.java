package books.JavaHowToProgram10Ed.chapter_8.GUI_CaseStudy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class MyLine {

    private int x1;       // x-coordinate of first endpoint
    private int y1;       // y-coordinate of first endpoint
    private int x2;       // x-coordinate of second endpoint
    private int y2;       // y-coordinate of second endpoint
    private Color color;  // color of this line

    public MyLine() {
        this(0, 0, 0, 0, Color.BLACK);
    }

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    // ##################################### [SET METHODS] ################################

    public void setX1(int x1) {
        this.x1 = Math.max(x1, 0);
    }

    public void setY1(int y1) {
        this.y1 = Math.max(y1, 0);
    }

    public void setX2(int x2) {
        this.x2 = Math.max(x2, 0);
    }

    public void setY2(int y2) {
        this.y2 = Math.max(y2, 0);
    }

    public void setColor(Color newColor) {
        if (!Objects.isNull(newColor)) {
            this.color = newColor;
        }
    }

    // #################################### [GET METHODS] ################################

    public int getX1() {
        return this.x1;
    }

    public int getY1() {
        return this.y1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY2() {
        return this.y2;
    }

    public Color getColor() {
        return this.color;
    }

    // Draw the line in the specified color
    public void draw(Graphics graphics) {
        graphics.setColor(this.getColor());
        graphics.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());

    }

}
