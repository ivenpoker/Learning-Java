package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy_10_1;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyShape {

    private final boolean isSpaceFilled;

    public MyRectangle() {
        super();
        this.isSpaceFilled = false;
    }

    public MyRectangle(int xCord, int yCord, int width, int height, Color color, boolean isSpaceFilled) {
        super(xCord, yCord, width, height, color);
        this.isSpaceFilled = isSpaceFilled;
    }

    public boolean isSpaceFilled() {
        return this.isSpaceFilled;
    }

    @Override
    public void draw(Graphics graphics) {
        if (this.isSpaceFilled()) {
            graphics.setColor(this.getColor());
            graphics.fillRect(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        } else {
            graphics.setColor(this.getColor());
            graphics.drawRect(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        }
    }
}
