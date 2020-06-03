package books.JavaHowToProgram10Ed.chapter_9.GUI_CaseStudy;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

public class CaseStudy {

    public static void main(String[] args) {

        DrawPanel panel = new DrawPanel();
        JLabel label = new JLabel(panel.toString());
        JFrame appFrame = new JFrame();

        label.setBackground(Color.CYAN);

        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.add(panel);
        appFrame.add(label, BorderLayout.SOUTH);
        appFrame.setSize(1000, 800);
        appFrame.setVisible(true);
    }

}
