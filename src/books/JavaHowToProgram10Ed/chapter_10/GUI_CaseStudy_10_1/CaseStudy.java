package books.JavaHowToProgram10Ed.chapter_10.GUI_CaseStudy_10_1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class CaseStudy {

    private static int obtainUserNumberOfShapes() {
        String message = "How many shapes to draw ?";
        int userNumInt = 0;
        boolean appended = false;
        while (true) {
            try {
                String userNumStr = JOptionPane.showInputDialog(message);
                if (userNumStr == null) {
                    break;
                }
                userNumInt = Integer.parseInt(userNumStr);
                if (userNumInt > 0) {
                    break;
                }
            } catch (NumberFormatException nFe) {
                if (!appended) {
                    message = "[MUST BE INTEGER > 0] " + message;
                    appended = true;
                }
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
