package books.JavaHowToProgram10Ed.chapter_6.GraphicsCaseStudy.Exercise_6_1;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

public class BullEyesPanel extends JPanel {

    private int numOfCircles;
    private static final SecureRandom random = new SecureRandom();

    public BullEyesPanel(int numOfCircles) {
        if (numOfCircles < 0) {                     // Validating number of circles for bull's eyes
            this.numOfCircles = 12;                 // If we had an invalid specified number of circles, we default to 12
        } else {
            this.numOfCircles = numOfCircles;       // Else, accept user's specified number of circles.
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // All computations to draw the bull's eyes are based on the current
        // windows height and width. Ths is done to make sure if the window is
        // resized the circles are drawn accordingly.

        int diameter = getWidth();                 // track current panel's width
//
//        int rectPtX = (width / 2) - 10;         // First point X's to be used to draw oval (rectangle start X-coordinate)
//        int rectPtY = (height / 2) - 10;        // Second point Y's to be used to draw oval (rectangle start Y-coordinate)
//
//        int prevDiameter = 20;                  // Diameter to the

        // Draw 'numOfCircles' ovals in this panel

//        for (int i = 0; i < this.numOfCircles; i++) {
//
//            int red = 10 + 20 * random.nextInt(10);
//            int green = 10 + 20 *random.nextInt(10);
//            int blue = 10 + 20 * random.nextInt( 10);
//
//            graphics.setColor(new Color(red, green, blue));
//            graphics.fillOval(rectPtX, rectPtY, prevDiameter, prevDiameter);
//            rectPtX -= 10;
//            rectPtY -= 10;
//            prevDiameter += 20;
//        }

        int rectPtX = 0;
        int rectPtY = 0;

        for (int i = 0; i < this.numOfCircles; i++) {
            int red = 10 + 20 * random.nextInt(10);
            int green = 10 + 20 *random.nextInt(10);
            int blue = 10 + 20 * random.nextInt( 10);

            graphics.setColor(new Color(red, green, blue));
            graphics.fillOval(rectPtX, rectPtY, diameter, diameter);

            rectPtX += 10;
            rectPtY += 10;

            diameter -= 20;
        }
    }
}
