package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DrawingSpiralLinesTest {

    private static int obtainUserNumberOfSpiral(String message) {
        String numberOfSpirals = JOptionPane.showInputDialog(message);
        return Integer.parseInt(numberOfSpirals);
    }

    public static void main(String[] args) {

        int numberOfSpirals = obtainUserNumberOfSpiral("How many spirals to draw ?");

        JFrame application = new JFrame("Spiral Lines");
        DrawingSpiralLines spiralLines = new DrawingSpiralLines(numberOfSpirals);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(spiralLines);
        application.setSize(600, 600);
        application.setVisible(true);

    }
}
