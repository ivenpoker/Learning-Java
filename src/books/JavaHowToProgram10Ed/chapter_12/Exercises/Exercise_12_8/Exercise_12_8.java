package books.JavaHowToProgram10Ed.chapter_12.Exercises.Exercise_12_8;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Exercise_12_8 {

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

        // Setup look an feel to 'Nimbus' cross platform
        setupLookAndFeel();

        // Display our frame
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 125);
        mainFrame.setVisible(true);
    }

}

class MainFrame extends JFrame {
    private final CheckBoxesPanel checkBoxesPanel;
    private final InputsPanel inputsPanel;
    private final ButtonsPanel buttonsPanel;

    private final JPanel frameMainPanel;

    public MainFrame() {
        super("Align");
        this.setLayout(new BorderLayout(2, 2));
        this.frameMainPanel = new JPanel();

        this.checkBoxesPanel = new CheckBoxesPanel();
        this.inputsPanel = new InputsPanel();
        this.buttonsPanel = new ButtonsPanel();

        this.frameMainPanel.setLayout(new FlowLayout());
        this.frameMainPanel.add(this.checkBoxesPanel, FlowLayout.LEFT);
        this.frameMainPanel.add(this.inputsPanel, FlowLayout.CENTER);
        this.frameMainPanel.add(this.buttonsPanel, FlowLayout.RIGHT);

        this.add(this.frameMainPanel, BorderLayout.CENTER);
    }
}

class CheckBoxesPanel extends JPanel {
    private final JCheckBox checkBox1;
    private final JCheckBox checkBox2;

    public CheckBoxesPanel() {
        this.setLayout(new GridLayout(2, 1));

        this.checkBox1 = new JCheckBox("Snap to Grid");
        this.checkBox2 = new JCheckBox("Show Grid");

        this.add(this.checkBox1);
        this.add(this.checkBox2);
    }
}

class InputsPanel extends JPanel {
    private final JTextField xField;
    private final JTextField yField;
    private final JLabel xLabel;
    private final JLabel yLabel;

    public InputsPanel() {
        this.xField = new JTextField("8", 2);
        this.yField = new JTextField("8", 2);

        this.xLabel = new JLabel("X:");
        this.yLabel = new JLabel("Y:");

        this.setLayout(new GridLayout(2, 1, 3, 3));

        this.add(this.xLabel);
        this.add(this.xField);

        this.add(this.yLabel);
        this.add(this.yField);
    }
}

class ButtonsPanel extends JPanel {
    private final JButton okButton;
    private final JButton cancelButton;
    private final JButton helpButton;

    public ButtonsPanel() {
        this.setLayout(new GridLayout(3, 1));

        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.helpButton = new JButton("Help");

        this.add(this.okButton);
        this.add(this.cancelButton);
        this.add(this.helpButton);
    }
}