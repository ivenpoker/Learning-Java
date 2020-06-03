package books.JavaHowToProgram10Ed.chapter_9.GUI_CaseStudy;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

public class DrawPanel extends JPanel {

    private static final SecureRandom randomNumbers = new SecureRandom();
    private final MyLine[] myLines;
    private final MyRectangle[] myRectangle;
    private final MyOval[] myOvals;

    public DrawPanel() {
        this.myLines        = new MyLine[1 + randomNumbers.nextInt(6)];
        this.myRectangle    = new MyRectangle[1 + randomNumbers.nextInt(6)];
        this.myOvals        = new MyOval[1 + randomNumbers.nextInt(6)];

        // Create lines
        for (int cnt = 0; cnt < this.myLines.length; cnt++) {
            int x1 = randomNumbers.nextInt(600);
            int y1 = randomNumbers.nextInt(600);
            int x2 = randomNumbers.nextInt(600);
            int y2 = randomNumbers.nextInt(600);
            Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256),
                    randomNumbers.nextInt(256));
            this.myLines[cnt] = new MyLine(x1, y1, x2, y2, color);
        }

        // Create rectangles
        for (int cnt = 0; cnt < this.myRectangle.length; cnt++) {
            int x = randomNumbers.nextInt(600);
            int y = randomNumbers.nextInt(600);
            int width = randomNumbers.nextInt(600);
            int height = randomNumbers.nextInt(600);
            Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256),
                    randomNumbers.nextInt(256));
            int tmp = randomNumbers.nextInt(2);
            this.myRectangle[cnt] = new MyRectangle(x, y, width, height, color, tmp % 2 == 0);
        }

        // Create Ovals
        for (int cnt = 0; cnt < this.myOvals.length; cnt++) {
            int x = randomNumbers.nextInt(600);
            int y = randomNumbers.nextInt(600);
            int width = randomNumbers.nextInt(600);
            int height = randomNumbers.nextInt(600);
            Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256),
                    randomNumbers.nextInt(256));
            int tmp = randomNumbers.nextInt(2);
            this.myOvals[cnt] = new MyOval(x, y, width, height, color, tmp % 2 == 0);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // Draw lines
        for (MyLine line : this.myLines) {
            line.draw(graphics);
        }

        // Draw rectangles
        for (MyRectangle rect : this.myRectangle) {
            rect.draw(graphics);
        }

        // Draw ovals
        for (MyOval oval : this.myOvals) {
            oval.draw(graphics);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Lines: %d | ", this.myLines.length));
        sb.append(String.format("Ovals: %d | ", this.myOvals.length));
        sb.append(String.format("Rectangles: %d", this.myRectangle.length));

        return sb.toString();
    }
}
