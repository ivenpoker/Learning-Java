package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy_10_2;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape {

    public MyOval() {
        super();
    }

    public MyOval(int x1, int y1, int width, int height, Color color, boolean isSpaceFilled) {
        super(x1, y1, width, height, color, isSpaceFilled);
    }

    @Override
    void draw(Graphics graphics) {
        if (this.isSpacedFilled()) {
            graphics.setColor(this.getColor());
            graphics.fillOval(this.getX1(), this.getY1(), this.getWidth(), this.getHeight());
        } else {
            graphics.setColor(this.getColor());
            graphics.drawOval(this.getX1(), this.getY1(), this.getWidth(), this.getHeight());
        }
    }
}
