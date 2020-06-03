package books.JavaHowToProgram10Ed.chapter_8.GUI_CaseStudy;

import javax.swing.JFrame;

public class CaseStudy {

    public static void main(String[] args) {

        DrawPanel panel = new DrawPanel();

        JFrame appFrame = new JFrame();
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.add(panel);
        appFrame.setSize(1000, 800);
        appFrame.setVisible(true);
    }

}
