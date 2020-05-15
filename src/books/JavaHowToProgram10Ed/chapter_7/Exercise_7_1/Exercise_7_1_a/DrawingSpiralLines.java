package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_1.Exercise_7_1_a;

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

        int width = this.getWidth();                                // Obtain panel's width
        int height = this.getHeight();                              // Obtain panel's height

        int lineStartX = width / 2;                                 // Starting X co-ordinate for first line is at panel's middle width
        int lineStartY = height / 2;                                // Starting Y co-ordinate for second line is at panel's middle height

        int linesDrawn = 0;                                         // Default number of lines drawn

        int lineLength = 10;                                        // First line's default length.
        int numberOfLineSpirals = this.numberOfLineSpirals;         // Number of lines to draw.

        // We get a random color for our lines

        int red   = random.nextInt(256);                     // Random red (R in RGB) value in range [0, 225]
        int green = random.nextInt(256);                     // Random green (G in RGB) value in range [0, 225]
        int blue  = random.nextInt(256);                     // Random blue (B in RGB) value in range [0, 225]

        graphics.setColor(new Color(red, green, blue));             // Set the color

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

            // We only increase the lengths of the lines after
            // drawing two lines in the panel

            if (linesDrawn % 2 == 0 && linesDrawn != 0) {
                lineLength += 10;
            }

            // Reduce number of spirals specified by user of class.
            // This is to avoid infinite recursion (drawing infinite number
            // of lines) on the panel.

            numberOfLineSpirals -= 1;
        }
    }

}
