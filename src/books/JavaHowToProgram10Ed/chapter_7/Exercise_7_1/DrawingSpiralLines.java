package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_1;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

public class DrawingSpiralLines extends JPanel {

    private enum LineDirections {GO_LEFT, GO_RIGHT, GO_UP, GO_DOWN}
    private final int DEFAULT_NUMBER_OF_SPIRALS = 15;

    private LineDirections currentDirection;
    private final int numberOfLineSpirals;
    private final SecureRandom random = new SecureRandom();

    public DrawingSpiralLines() {
        this.numberOfLineSpirals = this.DEFAULT_NUMBER_OF_SPIRALS;
        this.currentDirection = LineDirections.GO_DOWN;
    }

    public DrawingSpiralLines(int numberOfLineSpirals) {
        this.currentDirection = LineDirections.GO_DOWN;
        this.numberOfLineSpirals = numberOfLineSpirals > 0 ? numberOfLineSpirals : this.DEFAULT_NUMBER_OF_SPIRALS;
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        int width = this.getWidth();
        int height = this.getHeight();

        int lineStartX = width / 2;
        int lineStartY = height / 2;

        int linesDrawn = 0;

        int lineLength = 10;
        int numberOfLineSpirals = this.numberOfLineSpirals;

        // We get a random color for our lines

        int red   = random.nextInt(255);
        int green = random.nextInt(255);
        int blue  = random.nextInt(255);

        graphics.setColor(new Color(red, green, blue));

        while (numberOfLineSpirals > 0) {
            switch (this.currentDirection) {
                case GO_DOWN:
                    graphics.drawLine(lineStartX, lineStartY, lineStartX, lineStartY + lineLength);
                    lineStartY += lineLength;
                    linesDrawn += 1;

                    this.currentDirection = LineDirections.GO_LEFT;
                    break;

                case GO_LEFT:
                    graphics.drawLine(lineStartX, lineStartY, lineStartX - lineLength, lineStartY);
                    lineStartX -= lineLength;
                    linesDrawn += 1;

                    this.currentDirection = LineDirections.GO_UP;
                    break;

                case GO_UP:
                    graphics.drawLine(lineStartX, lineStartY, lineStartX, lineStartY - lineLength);
                    lineStartY -= lineLength;
                    linesDrawn += 1;

                    this.currentDirection = LineDirections.GO_RIGHT;
                    break;

                case GO_RIGHT:
                    graphics.drawLine(lineStartX, lineStartY, lineStartX + lineLength, lineStartY);
                    lineStartX += lineLength;
                    linesDrawn += 1;

                    this.currentDirection = LineDirections.GO_DOWN;
                    break;
            }
            if (linesDrawn % 2 == 0 && linesDrawn != 0) {
                lineLength += 10;
            }
            numberOfLineSpirals -= 1;
        }
    }

}
