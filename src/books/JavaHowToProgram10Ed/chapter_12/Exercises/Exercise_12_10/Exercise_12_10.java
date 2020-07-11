package books.JavaHowToProgram10Ed.chapter_12.Exercises.Exercise_12_10;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Exercise_12_10 {

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

        // setup look and feel for application.
        setupLookAndFeel();

        ColorSetFrame colorSetFrame = new ColorSetFrame();
        colorSetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorSetFrame.setSize(300, 110);
        colorSetFrame.setVisible(true);
    }
}

class ColorSetFrame extends JFrame {
    private final ButtonsPanel buttonsPanel;
    private final CheckBoxPanel checkBoxPanel;
    private final ComboBoxPanel comboBoxPanel;

    public ColorSetFrame() {

        super("ColorSet");

        this.buttonsPanel  = new ButtonsPanel();
        this.checkBoxPanel = new CheckBoxPanel();
        this.comboBoxPanel = new ComboBoxPanel();

        this.setLayout(new BorderLayout());

        this.add(this.comboBoxPanel, BorderLayout.NORTH);
        this.add(this.checkBoxPanel, BorderLayout.CENTER);
        this.add(this.buttonsPanel, BorderLayout.SOUTH);

    }
}

class ComboBoxPanel extends JPanel {
    private final JComboBox<String> colorComboBox;
    private final String[] colors = {"red", "orange", "blue", "white", "green", "voilet", "brown", "skyblue"};

    public ComboBoxPanel() {
        this.setLayout(new BorderLayout());

        // Set all colors to uppercase names
        for (int i = 0; i < this.colors.length; i++) {
            this.colors[i] = this.colors[i].toUpperCase();
        }

        this.colorComboBox = new JComboBox<>(colors);
        this.colorComboBox.setMaximumRowCount(5);

        this.colorComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                // For the moment nothing is implemented
            }
        });

        this.add(this.colorComboBox, BorderLayout.NORTH);
    }
}

class CheckBoxPanel extends JPanel {
    private final JCheckBox backgroundCheckBox;
    private final JCheckBox foregroundCheckBox;

    public CheckBoxPanel() {
        this.backgroundCheckBox = new JCheckBox("Background");
        this.foregroundCheckBox = new JCheckBox("Foreground");
        this.setLayout(new FlowLayout());

        // Attach default event handler
        CheckBoxHandler handler = new CheckBoxHandler();

        this.backgroundCheckBox.addItemListener(handler);
        this.foregroundCheckBox.addItemListener(handler);

        this.add(this.backgroundCheckBox);
        this.add(this.foregroundCheckBox);
    }

    private class CheckBoxHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evt) {
            String boxStr = "";
            if (CheckBoxPanel.this.backgroundCheckBox.isSelected() &&
                    CheckBoxPanel.this.foregroundCheckBox.isSelected()) {
                boxStr = CheckBoxPanel.this.backgroundCheckBox.getActionCommand();
                boxStr += " and " + CheckBoxPanel.this.foregroundCheckBox.getActionCommand();

            } else if (CheckBoxPanel.this.backgroundCheckBox.isSelected()) {
                boxStr = CheckBoxPanel.this.backgroundCheckBox.getActionCommand();

            } else if (CheckBoxPanel.this.foregroundCheckBox.isSelected()) {
                boxStr = CheckBoxPanel.this.foregroundCheckBox.getActionCommand();
            }

//            if (!boxStr.isEmpty()) {
//                JOptionPane.showMessageDialog(CheckBoxPanel.this,
//                        String.format("'%s' is not functional.", boxStr),  "[NOT_IMPLEMENTED]",
//                        JOptionPane.WARNING_MESSAGE);
//            }
        }
    }
}

class ButtonsPanel extends JPanel {
    private final JButton okButton;
    private final JButton cancelButton;

    public ButtonsPanel() {
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");

        // set layout for buttons to be added
        this.setLayout(new FlowLayout());

        // Attach default buttons handler
        ButtonsHandler handler = new ButtonsHandler();

        this.okButton.addActionListener(handler);
        this.cancelButton.addActionListener(handler);

        // add buttons to panel with layout settings
        this.add(this.okButton);
        this.add(this.cancelButton);
    }

    private class ButtonsHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(ButtonsPanel.this,
                    String.format("'%s' is not functional.", evt.getActionCommand()),
                    "[NOT_IMPLEMENTED]", JOptionPane.WARNING_MESSAGE);
        }
    }
}
