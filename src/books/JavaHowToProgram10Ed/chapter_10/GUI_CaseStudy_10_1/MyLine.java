package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy_10_1;

import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {

    public MyLine() {
        super();
    }

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(this.getColor());
        graphics.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());
    }
}
