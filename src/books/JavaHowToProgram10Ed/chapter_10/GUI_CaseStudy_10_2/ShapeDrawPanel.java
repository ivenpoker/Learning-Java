package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy_10_2;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

public class ShapeDrawPanel extends JPanel {

    private static final SecureRandom randomNumbers = new SecureRandom();
    private final MyShape[] myShapes;
    private final int MAX_POINT_UPPER_BOUND = 600;
    private static final int EXIT_FAILURE = 1;

    public ShapeDrawPanel(int numOfShapes) {
        this.myShapes = new MyShape[numOfShapes];

        // Initialize 'myShapes' with random different shapes
        for (int i = 0; i < this.myShapes.length; i++) {
            this.myShapes[i] = this.randomShape();
        }
    }

    private MyShape randomShape() {
        int randChoice = randomNumbers.nextInt(3);
        MyShape randomShape = null;

        int x1 = randomNumbers.nextInt(this.MAX_POINT_UPPER_BOUND);
        int y1 = randomNumbers.nextInt(this.MAX_POINT_UPPER_BOUND);
        int x2 = randomNumbers.nextInt(this.MAX_POINT_UPPER_BOUND);
        int y2 = randomNumbers.nextInt(this.MAX_POINT_UPPER_BOUND);
        Color color = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256),
                randomNumbers.nextInt(256));

        switch (randChoice) {
            case 0: {
                randomShape = new MyLine(x1, y1, x2, y2, color);
                break;
            }
            case 1: {
                int temp = randomNumbers.nextInt(10);
                randomShape = new MyOval(x1, y1, x2, y2, color, temp % 2 == 0);
                break;
            }
            case 2: {
                int temp = randomNumbers.nextInt(10);
                randomShape = new MyRectangle(x1, y1, x2, y2, color, temp % 2 == 0);
                break;
            }
            default: {
                System.out.println("============== [SYSTEM_ERROR] ============");
                System.exit(EXIT_FAILURE);
            }
        }
        return randomShape;
    }

    public int getNumberOfLineShapes() {
        int cnt = 0;
        for (MyShape shape : this.myShapes) {
            if (shape instanceof MyLine) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public int getNumberOfOvalShapes() {
        int cnt = 0;
        for (MyShape shape : this.myShapes) {
            if (shape instanceof MyOval) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public int getNumberOfRectangleShapes() {
        int cnt = 0;
        for (MyShape shape : this.myShapes) {
            if  (shape instanceof MyRectangle) {
                cnt += 1;
            }
        }
        return cnt;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // Draw each shape polymorphically
        for (MyShape shape : this.myShapes) {
            shape.draw(graphics);
        }
    }


    @Override
    public String toString() {
        return String.format("Lines: %d | Ovals: %d | Rectangles: %d",
                this.getNumberOfLineShapes(), this.getNumberOfOvalShapes(),
                this.getNumberOfRectangleShapes());
    }
}
