package books.JavaHowToProgram10Ed.chapter_6.GraphicsCaseStudy.Exercise_6_2;

import javax.swing.JFrame;

public class RandomShapesPanelTest {

    public static void main(String[] args) {
        RandomShapesPanel shapesPanel = new RandomShapesPanel(10);
        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(shapesPanel);
        application.setSize(400, 400);
        application.setVisible(true);
    }
}
