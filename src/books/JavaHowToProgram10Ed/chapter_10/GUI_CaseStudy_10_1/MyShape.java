package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy_10_1;

import java.awt.Color;
import java.awt.Graphics;

abstract public class MyShape {

    private int x1;         // x-coordinate of first endpoint
    private int y1;         // y-coordinate of first endpoint
    private int x2;         // x-coordinate of second endpoint
    private int y2;         // y-coordinate of second endpoint
    private Color color;    // color of this shape

    public MyShape() {
        this(0, 0, 0, 0, Color.BLACK);
    }

    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    // ###################### [SET METHODS] #######################

    public final void setX1(int x1) {
        this.x1 = Math.max(x1, 0);
    }

    public final void setY1(int y1) {
        this.y1 = Math.max(y1, 0);
    }

    public final void setX2(int x2) {
        this.x2 = Math.max(x2, 0);
    }

    public final void setY2(int y2) {
        this.y2 = Math.max(y2, 0);
    }

    public final void setColor(Color newColor) {
        this.color = newColor;
    }

    // ###################### [GET METHODS] ########################

    public final int getX1() {
        return this.x1;
    }

    public final int getY1() {
        return this.y1;
    }

    public final int getX2() {
        return this.x2;
    }

    public final int getY2() {
        return this.y2;
    }

    public final Color getColor() {
        return this.color;
    }

    // Any class inheriting this class must specify how to
    // draw this shape

    abstract void draw(Graphics graphics);
}
