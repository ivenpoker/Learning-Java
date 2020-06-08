package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy_10_2;

import java.awt.Color;

public abstract class MyBoundedShape extends MyShape {

    private boolean isSpacedFilled;

    public MyBoundedShape() {
        super();
        this.isSpacedFilled = false;
    }

    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean isSpacedFilled) {
        super(x1, y1, x2, y2, color);
        this.isSpacedFilled = isSpacedFilled;
    }

    public void setSpacedFilled(boolean isSpacedFilled) {
        this.isSpacedFilled = isSpacedFilled;
    }

    public boolean isSpacedFilled() {
        return this.isSpacedFilled;
    }

    public int getUpperLeftX() {
        return this.getX1();
    }

    public int getUpperLeftY() {
        return this.getY1();
    }

    public int getWidth() {
        return this.getX2();
    }

    public int getHeight() {
        return this.getY2();
    }

    public void setWidth(int width) {
        this.setX2(width);
    }

    public void setHeight(int height) {
        this.setY2(height);
    }
}
