package books.JavaHowToProgram10Ed.chapter_5.GraphicsCaseStudy.Exercise_5_2;

import javax.swing.JPanel;
import java.awt.Graphics;

public class BarChartPanel extends JPanel {

    private int valA;
    private int valB;
    private int valC;
    private int valD;
    private int valE;

    public BarChartPanel(int valA, int valB, int valC, int valD, int valE) {
        this.valA = valA;
        this.valB = valB;
        this.valC = valC;
        this.valD = valD;
        this.valE = valE;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        int startX = 0;
        int startY = 10;

        // Drawing first barchart rectangle
        graphics.drawRect(startX, startY, 10 * this.valA, 5);

        // Create some space between rectangles
        startY += 10;

        // Drawing second barchart rectangle
        graphics.drawRect(startX, startY, 10 * this.valB, 5);

        // Create some space between rectangles
        startY += 10;

        // Drawing third barchart rectangle
        graphics.drawRect(startX, startY, 10 * this.valC, 5);

        // Create some space between rectangles
        startY += 10;

        // Drawing fourth barchart rectangle
        graphics.drawRect(startX, startY, 10 * this.valD, 5);

        // Create some space between rectangles
        startY += 10;

        // Drawing fifth barchart rectangle
        graphics.drawRect(startX, startY, 10 * this.valE, 5);
    }
}
