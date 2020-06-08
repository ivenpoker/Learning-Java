package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy_10_2;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape {

    public MyRectangle() {
        super();
    }

    public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean isSpaceFilled) {
        super(x1, y1, x2, y2, color, isSpaceFilled);
    }

    @Override
    void draw(Graphics graphics) {
        if (this.isSpacedFilled()) {
            graphics.setColor(this.getColor());
            graphics.fillRect(this.getX1(), this.getY1(), this.getWidth(), this.getHeight());
        } else {
            graphics.setColor(this.getColor());
            graphics.drawRect(this.getX1(), this.getY1(), this.getWidth(), this.getHeight());
        }
    }
}
