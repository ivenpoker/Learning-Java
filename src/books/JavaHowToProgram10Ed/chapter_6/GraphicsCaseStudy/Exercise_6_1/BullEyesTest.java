package books.JavaHowToProgram10Ed.chapter_6.GraphicsCaseStudy.Exercise_6_1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BullEyesTest {

    public static void main(String[] args) {
        int bullNumberOfEyes = 0;

        while (bullNumberOfEyes <= 0) {
            String numEyes = JOptionPane.showInputDialog("How many bull eyes to generate ?: ");
            bullNumberOfEyes = Integer.parseInt(numEyes);
        }

        JFrame application = new JFrame();
        BullEyesPanel panel = new BullEyesPanel(bullNumberOfEyes);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(350, 377);
        application.setVisible(true);
    }
}
