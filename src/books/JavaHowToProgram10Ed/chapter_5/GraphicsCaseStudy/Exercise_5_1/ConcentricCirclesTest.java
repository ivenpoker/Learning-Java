package books.JavaHowToProgram10Ed.chapter_5.GraphicsCaseStudy.Exercise_5_1;

import javax.swing.*;

public class ConcentricCirclesTest {

    public static void main(String[] args) {

        int numOfCircles;

        do {
            String userNumOfCircles = JOptionPane.showInputDialog("Enter number of circles to draw:");
            numOfCircles = Integer.parseInt(userNumOfCircles);
        } while (numOfCircles <= 0);

        ConcentricCircles circlesPanel = new ConcentricCircles(numOfCircles);

        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(circlesPanel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
}
