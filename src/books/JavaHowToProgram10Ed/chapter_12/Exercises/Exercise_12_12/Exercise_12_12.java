package books.JavaHowToProgram10Ed.chapter_12.Exercises.Exercise_12_12;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise_12_12 {

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

        // Setup cross platform look and feel.
        setupLookAndFeel();

        TemperatureConverterFrame tempFrame = new TemperatureConverterFrame();
        tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tempFrame.setSize(300, 150);
        tempFrame.setVisible(true);

    }
}

class TemperatureConverterFrame extends JFrame {
    private final JLabel temperatureLabel;
    private final JTextField textField;
    private final JButton convertButton;

    public TemperatureConverterFrame() {

        super("Fahrenheit temperature converter");
        this.setLayout(new BorderLayout());

        this.temperatureLabel = new JLabel("Please enter fahrenheit temperature");
        this.textField        = new JTextField(20);
        this.convertButton    = new JButton("Convert");

        this.convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String inputFieldText = TemperatureConverterFrame.this.textField.getText();
                if (inputFieldText.isEmpty()) {
                    JOptionPane.showMessageDialog(TemperatureConverterFrame.this,
                            "Please enter temperature", "No input",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    TemperatureConverterFrame.this.handlerUserInput(inputFieldText);
                }
            }
        });

        // Wrap temperature label inside a panel before adding to frame
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        northPanel.add(this.temperatureLabel);

        this.add(northPanel, BorderLayout.NORTH);

        // Wrap text field inside a panel before adding to frame
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        centerPanel.add(this.textField);

        this.add(centerPanel, BorderLayout.CENTER);

        // Wrap convert button inside a panel before adding to frame
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        southPanel.add(this.convertButton);

        this.add(southPanel, BorderLayout.SOUTH);
    }

    private void handlerUserInput(String inputFieldText) {
        try {
            double userTemp = Double.parseDouble(inputFieldText);
            double fahrenheitEquiv = convertToCelsius(userTemp);

            this.temperatureLabel.setText(
                    String.format("Fahrenheit equivalent: %.5f", fahrenheitEquiv));

        } catch (NumberFormatException nFe) {
            JOptionPane.showMessageDialog(TemperatureConverterFrame.this,
                    "Invalid input. Must be integer or decimal number.",
                    "Invalid input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static double convertToCelsius(double fahrenheitTemp) {
        return ((5.0/9.0) * (fahrenheitTemp - 32));
    }

}


