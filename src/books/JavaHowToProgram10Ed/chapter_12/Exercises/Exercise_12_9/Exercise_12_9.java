package books.JavaHowToProgram10Ed.chapter_12.Exercises.Exercise_12_9;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise_12_9 {

    public static void setupLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // not worth my time
            }
        }
    }

    public static void main(String[] args) {

        // setup 'Nimbus' look and feel
        setupLookAndFeel();

        CalculatorFrame calculatorFrame = new CalculatorFrame();
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setSize(200, 225);
        calculatorFrame.setVisible(true);

    }
}

class CalculatorFrame extends JFrame {

    private final InputPanel inputPanel;
    private final ButtonsPanel buttonsPanel;

    public CalculatorFrame() {
        super("Calculator");
        this.setLayout(new BorderLayout(2, 1));

        this.inputPanel = new InputPanel();
        this.buttonsPanel = new ButtonsPanel();

        this.add(this.inputPanel, BorderLayout.NORTH);
        this.add(this.buttonsPanel, BorderLayout.CENTER);
    }
}

class InputPanel extends JPanel {
    private final JTextField textField;

    public InputPanel() {
        this.setLayout(new BorderLayout(1, 1));
        this.textField = new JTextField(15);
        this.add(this.textField, BorderLayout.NORTH);
    }
}

class ButtonsPanel extends JPanel {
    private final JButton[] buttons;
    private static final int MAX_BUTTONS = 16;
    private static final int NUM_COLS = 4;
    private static final int NUM_ROWS = 4;

    private static final String[] buttonNames =
            {"7", "8", "9", "/", "4", "5", "6", "*",
             "1", "2", "3", "-", "0", ".", "=", "+"};

    public ButtonsPanel() {

        this.buttons = new JButton[ButtonsPanel.MAX_BUTTONS];
        this.setLayout(new GridLayout(ButtonsPanel.NUM_ROWS, ButtonsPanel.NUM_COLS));

        ButtonsHandler handler = new ButtonsHandler();

        for (String buttonName : ButtonsPanel.buttonNames) {
            JButton button = new JButton(buttonName);
            button.addActionListener(handler);
            this.add(button);
        }

    }

    private class ButtonsHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(ButtonsPanel.this,
                    String.format("[NOT_IMPLEMENTED]: '%s' isn't functional yet.", evt.getActionCommand()));
        }
    }
}
