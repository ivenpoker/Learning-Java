package books.JavaHowToProgram10Ed.chapter_12.Exercises.Exercise_12_13;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Exercise_12_13 {

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

        TemperatureConvertersFrame tempFrame = new TemperatureConvertersFrame();
        tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tempFrame.setSize(500, 180);
        tempFrame.setVisible(true);

    }
}

class TemperatureConvertersFrame extends JFrame {
    private final JLabel temperatureLabel;
    private final JLabel infoLabel;
    private final JTextField textField;
    private final JButton convertButton;
    private final JComboBox<String> comboBox;
    private final static String[] conversionNames = {"To Celsius", "To Kelvin"};

    private enum ConversionType {TO_CELSIUS, TO_KELVIN}

    private ConversionType conversionType;

    public TemperatureConvertersFrame() {
        super("Temperature converter");
        this.setLayout(new BorderLayout());

        this.infoLabel        = new JLabel("github: @ivenpoker");
        this.infoLabel.setForeground(Color.WHITE);
        this.infoLabel.setFont(new Font("Monospace", Font.BOLD, 12));

        this.temperatureLabel = new JLabel("Please select target unit and enter fahrenheit temperature");
        this.textField        = new JTextField(20);
        this.convertButton    = new JButton("Convert temperature");
        this.comboBox         = new JComboBox<>(conversionNames);

        // Default conversion type.
        this.conversionType = ConversionType.TO_CELSIUS;

        // Event listener when new temperature unit is selected.
        this.comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                // determine whether item was selected
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    String conversionName = TemperatureConvertersFrame.conversionNames[
                                TemperatureConvertersFrame.this.comboBox.getSelectedIndex()
                            ];
                    // if a celsius temperature was selected
                    if (conversionName.equals(TemperatureConvertersFrame.conversionNames[0])) {
                        TemperatureConvertersFrame.this.conversionType = ConversionType.TO_CELSIUS;

                    } else if (conversionName.equals(TemperatureConvertersFrame.conversionNames[1])) {
                        // if a kelvin temperature was selected
                        TemperatureConvertersFrame.this.conversionType = ConversionType.TO_KELVIN;
                    }
                }
            }
        });

        // Event listener when convert button is pressed.
        this.convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                String inputFieldText = TemperatureConvertersFrame.this.textField.getText();
                if (inputFieldText.isEmpty()) {
                    JOptionPane.showMessageDialog(TemperatureConvertersFrame.this,
                            "Please enter a temperature", "No input", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Let's try converting user input to a double. Any failure, we alert
                    // the user of the failure.
                    try {
                        double tempVal = Double.parseDouble(inputFieldText);
                        double convertedVal = TemperatureConvertersFrame.convertToSpecifiedTemperatureUnit(tempVal,
                                                        TemperatureConvertersFrame.this.conversionType);

                        ConversionType convType = TemperatureConvertersFrame.this.conversionType;
                        String txt = "";
                        if (convType.equals(ConversionType.TO_CELSIUS)) {
                            txt = "to celsius";
                        } else {
                            txt = "to kelvin";
                        }
                        TemperatureConvertersFrame.this.temperatureLabel.setText(
                                String.format("Specified fahrenheit temperature %s: %.5f", txt, convertedVal)
                        );

                    } catch (NumberFormatException nFe) {
                        JOptionPane.showMessageDialog(TemperatureConvertersFrame.this,
                                "Invalid input. Must be an integer or decimal number.", "Invalid input",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Wrap temperature label inside a panel before adding to frame.
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        northPanel.add(this.temperatureLabel);

        this.add(northPanel, BorderLayout.NORTH);


        // Wrap temperature input field and combo box inside a panel before adding to frame.
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        centerPanel.add(this.comboBox);
        centerPanel.add(this.textField);
        centerPanel.add(this.convertButton);

        this.add(centerPanel, BorderLayout.CENTER);

        // Wrap convert button inside panel before inserting into the UI.
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        southPanel.add(this.infoLabel);
//        southPanel.setBackground(new Color(0, 0, 0));
        southPanel.setBackground(Color.DARK_GRAY);


        this.add(southPanel, BorderLayout.SOUTH);
    }

    private static double convertToSpecifiedTemperatureUnit(double tempVal, ConversionType conversionType) {
        double convTemp = 0.0;
        switch (conversionType) {
            case TO_CELSIUS:
                convTemp =  convertToCelsius(tempVal);
                break;
            case TO_KELVIN:
                convTemp = 273.15 + convertToCelsius(tempVal);
                break;
        }
        return convTemp;
    }

    private static double convertToCelsius(double fahrenheitTemp) {
        return ((5.0/9.0) * (fahrenheitTemp - 32));
    }
}
