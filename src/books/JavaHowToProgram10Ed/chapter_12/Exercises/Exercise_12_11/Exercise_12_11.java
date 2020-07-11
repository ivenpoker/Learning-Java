package books.JavaHowToProgram10Ed.chapter_12.Exercises.Exercise_12_11;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise_12_11 {

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

        setupLookAndFeel();

        PrinterFrame printerFrame = new PrinterFrame();
        printerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printerFrame.setSize(400, 150);
        printerFrame.setVisible(true);

    }
}

class PrinterFrame extends JFrame {

    private final ButtonsPanel buttonsPanel;
    private final BoxesTextAreaRadioButtonsAndLabels boxesTextAreaRadioButtonsAndLabels;

    public PrinterFrame() {
        super("Printer");
        this.setLayout(new BorderLayout(4, 4));

        this.buttonsPanel = new ButtonsPanel();
        this.boxesTextAreaRadioButtonsAndLabels = new BoxesTextAreaRadioButtonsAndLabels();

        this.add(this.buttonsPanel, BorderLayout.EAST);
        this.add(this.boxesTextAreaRadioButtonsAndLabels, BorderLayout.CENTER);
    }
}

class BoxesTextAreaRadioButtonsAndLabels extends JPanel {

    private final String printerName = "MyPrinter";

    // Label for our UI.
    private final JLabel label1;
    private final JLabel label2;

    // Text areas for our UI.
    private final JTextArea textArea1;
    private final JTextArea textArea2;
    private final JTextArea textArea3;

    // Checkboxes for our UI.
    private final JCheckBox checkBox1;
    private final JCheckBox checkBox2;
    private final JCheckBox checkBox3;
    private final JCheckBox checkBox4;

    // JComboBox for out UI.
    private final JComboBox<String> comboBox;
    private final static String[] comboBoxItems = {"High", "Medium", "Low"};

    // Radio buttons for our UI.
    private final JRadioButton radioButton1;
    private final JRadioButton radioButton2;
    private final JRadioButton radioButton3;

    private final ButtonGroup radioGroup;


    public BoxesTextAreaRadioButtonsAndLabels() {
        this.setLayout(new BorderLayout());

        // Create labels.
        this.label1 = new JLabel(String.format("Printer: %s", this.printerName));
        this.label2 = new JLabel("Print Quality:");

        // Create text areas.
        this.textArea1 = new JTextArea(4, 3);
        this.textArea2 = new JTextArea(4, 3);
        this.textArea3 = new JTextArea(4, 3);

        this.textArea1.setEditable(false);
        this.textArea2.setEditable(false);
        this.textArea3.setEditable(false);

        // Create Check boxes
        this.checkBox1 = new JCheckBox("Image");
        this.checkBox2 = new JCheckBox("Text");
        this.checkBox3 = new JCheckBox("Code");
        this.checkBox4 = new JCheckBox("Print to file");

        this.comboBox = new JComboBox<>(comboBoxItems);

        // New sub-panel for checkboxes with unique layout
        JPanel checkBoxesPanel = new JPanel();
        checkBoxesPanel.setLayout(new GridLayout(3, 1));

        // Add checkboxes to the new sub-panel.
        checkBoxesPanel.add(this.checkBox1);
        checkBoxesPanel.add(this.checkBox2);
        checkBoxesPanel.add(this.checkBox3);

        // New sub-panel for Radio buttons with unique layout
        JPanel radioButtonsPanel = new JPanel();
        radioButtonsPanel.setLayout(new GridLayout(3, 1));

        this.radioButton1 = new JRadioButton("Selection");
        this.radioButton2 = new JRadioButton("All");
        this.radioButton3 = new JRadioButton("Applet");
        this.radioGroup = new ButtonGroup();

        this.radioGroup.add(this.radioButton1);
        this.radioGroup.add(this.radioButton2);
        this.radioGroup.add(this.radioButton3);

        radioButtonsPanel.add(this.radioButton1);
        radioButtonsPanel.add(this.radioButton2);
        radioButtonsPanel.add(this.radioButton3);


        // ############## Add components to this Panel #####################

        this.add(this.label1, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(this.textArea1);
        centerPanel.add(checkBoxesPanel);
        centerPanel.add(this.textArea2);
        centerPanel.add(radioButtonsPanel);
        centerPanel.add(this.textArea3);

        this.add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        southPanel.add(this.label2);
        southPanel.add(this.comboBox);
        southPanel.add(this.checkBox4);

        this.add(southPanel, BorderLayout.SOUTH);
    }
}

class ButtonsPanel extends JPanel {
    private final JButton okButton;
    private final JButton cancelButton;
    private final JButton setupButton;
    private final JButton helpButton;

    public ButtonsPanel() {
        this.setLayout(new GridLayout(4, 1));

        this.okButton     = new JButton("OK");
        this.cancelButton = new JButton("Cancel");
        this.setupButton  = new JButton("Setup...");
        this.helpButton   = new JButton("Help");

        // Add handler to buttons
        ButtonsHandler handler = new ButtonsHandler();

        this.okButton.addActionListener(handler);
        this.cancelButton.addActionListener(handler);
        this.setupButton.addActionListener(handler);
        this.helpButton.addActionListener(handler);

        // Add buttons to this panel
        this.add(this.okButton);
        this.add(this.cancelButton);
        this.add(this.setupButton);
        this.add(this.helpButton);
    }

    private class ButtonsHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(ButtonsPanel.this,
                    String.format("'%s' not functional yet.", evt.getActionCommand()),
                    "BUTTON_NOT_IMPLEMENTED", JOptionPane.WARNING_MESSAGE);
        }
    }
}
