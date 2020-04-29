package books.JavaHowToProgram10Ed.chapter_5.GraphicsCaseStudy.Exercise_5_2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BarChartPanelTest {

    private static int readUserInputGUI(String message) {
        String userInputStr = JOptionPane.showInputDialog(message);
        return Integer.parseInt(userInputStr);
    }

    private static void appError(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage);
    }

    public static void main(String[] args) {

        // We read 5 input from user from the GUI.

        int maxNumOfReads = 5;

        int valA = 0;           // First user input.
        int valB = 0;           // Second user input.
        int valC = 0;           // Third user input.
        int valD = 0;           // Fourth user input.
        int valE = 0;           // Fifth user input.

        // Assuming that, user provides valid data.

        for (int i = 0; i < maxNumOfReads; i++) {
            switch (i) {
                case 0:
                    valA = BarChartPanelTest.readUserInputGUI("Enter first number:");
                    break;
                case 1:
                    valB = BarChartPanelTest.readUserInputGUI("Enter second number:");
                    break;
                case 2:
                    valC = BarChartPanelTest.readUserInputGUI("Enter third number:");
                    break;
                case 3:
                    valD = BarChartPanelTest.readUserInputGUI("Enter fourth number:");
                    break;
                case 4:
                    valE = BarChartPanelTest.readUserInputGUI("Enter fifth number:");
                    break;
                default:
                    BarChartPanelTest.appError("Oops, system error");
                    break;
            }
        }

        BarChartPanel barChartPanel = new BarChartPanel(valA, valB, valC, valD, valE);

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(barChartPanel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
    
}
