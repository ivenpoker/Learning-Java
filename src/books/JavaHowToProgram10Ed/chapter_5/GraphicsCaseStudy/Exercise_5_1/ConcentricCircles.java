package books.JavaHowToProgram10Ed.chapter_5.GraphicsCaseStudy.Exercise_5_1;

import javax.swing.*;
import java.awt.*;

public class ConcentricCircles extends JPanel {

    private int numOfCircles;

    public ConcentricCircles(int numOfCircles) {
        if (numOfCircles < 0) {             // validating number of circles
            this.numOfCircles = 12;         // if we had an invalid specified number of circles, we set it the default of 12
        } else {
            this.numOfCircles = numOfCircles;   // Else, accept user's specified number of circles.
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // All computations to draw the concentric circles are based on the current
        // windows height and width. This is done to make sure if the window is resized,
        // the circles are drawn accordingly.

        int width = getWidth();             // track current panel's width
        int height = getHeight();           // track current panel's height

        int rectPtX = (width / 2) - 10;     // First point X's to be used to draw oval (rectangle start X-coordinate)
        int rectPtY = (height / 2) - 10;    // Second point Y's to be used to draw oval (rectangle start Y-coordinate)

        int prevDiameter = 20;              // Diameter to the incremented by 20 for each new oval.

        // Draw 'numOfCircles' ovals in this panel

        for (int i = 0; i < this.numOfCircles; i++) {
            graphics.drawOval(rectPtX, rectPtY, prevDiameter, prevDiameter);
            rectPtX -= 10;
            rectPtY -= 10;
            prevDiameter += 20;
        }
    }
}
