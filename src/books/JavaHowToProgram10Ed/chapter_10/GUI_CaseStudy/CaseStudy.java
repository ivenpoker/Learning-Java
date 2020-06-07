package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class CaseStudy {

    private static int obtainUserNumberOfShapes() {
        StringBuilder message = new StringBuilder("How many shapes to draw ?");
        String userNumStr = JOptionPane.showInputDialog(message.toString());
        int userNumInt = 0;
        while (true) {
            try {
                userNumInt = Integer.parseInt(userNumStr);
                if (userNumInt > 0) {
                    break;
                }
            } catch (NumberFormatException nFe) {
                message.append("[MUST BE INTEGER > 0] ");
            }
        }
        return userNumInt;
    }

    public static void main(String[] args) {

        int userSpecifiedNumOfShapes = obtainUserNumberOfShapes();
        ShapeDrawPanel shapeDrawPanel = new ShapeDrawPanel(userSpecifiedNumOfShapes);

        JLabel label = new JLabel(shapeDrawPanel.toString());

        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(shapeDrawPanel);
        application.add(label, BorderLayout.SOUTH);
        application.setSize(800, 800);
        application.setVisible(true);
    }
}
