package books.JavaHowToProgram10Ed.chapter_6.GraphicsCaseStudy.Exercise_6_2;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

public class RandomShapesPanel extends JPanel {

    private final int numOfShapes;
    private static final SecureRandom random = new SecureRandom();
    private enum ShapeType {OVAL, RECTANGLE}

    public RandomShapesPanel(int numOfShapes) {
        if (numOfShapes < 0) {
            this.numOfShapes = 10;
        } else {
            this.numOfShapes = numOfShapes;
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < this.numOfShapes; i++) {

            // Random color RGB values
            int red = 10 + 20 * random.nextInt(10);
            int green = 10 + 20 *random.nextInt(10);
            int blue = 10 + 20 * random.nextInt( 10);

            // set current graphics color
            graphics.setColor(new Color(red, green, blue));

            // Rectangle OR Oval specifications.
            int startX = random.nextInt(width);                             // shape start point X based on random value on width scale
            int startY = random.nextInt(height);                            // shape start point Y based on random value on height scale
            int rectWidth = 20 + random.nextInt(width - 20);         // rectangles width starts at a minimum of 20 till panel's width - 20
            int rectHeight = 20 + random.nextInt(height - 20);       // rectangles height starts at a minimum of 20 till panel's height - 20

            // Random shape
            ShapeType currentShape = (random.nextInt(2) == 0) ? ShapeType.OVAL : ShapeType.RECTANGLE;

            switch (currentShape) {
                case OVAL:
                    graphics.fillOval(startX, startY, rectWidth, rectHeight);
                    break;

                case RECTANGLE:
                    graphics.fillRect(startX, startY, rectWidth, rectHeight);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "[SYSTEM_ERROR]: Invalid application state");
                    break;
            }
        }

    }
}
