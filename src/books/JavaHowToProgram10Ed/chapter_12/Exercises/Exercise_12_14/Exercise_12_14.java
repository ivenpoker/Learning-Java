package books.JavaHowToProgram10Ed.chapter_12.Exercises.Exercise_12_14;

import javax.swing.JButton;
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
import java.security.SecureRandom;

public class Exercise_12_14 {

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

        // setup cross platform look and feel for our application
        setupLookAndFeel();

        GuessNumberGameFrame guessNumberGameFrame = new GuessNumberGameFrame();
        guessNumberGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessNumberGameFrame.setSize(450, 200);
        guessNumberGameFrame.setVisible(true);
    }
}

class GuessNumberGameFrame extends JFrame {

    private final JPanel northPanel;
    private final JPanel centerPanel;
    private final JPanel southPanel;
    private final JPanel westPanel;
    private final JPanel eastPanel;

    private final JLabel gameInfoLabel;
    private final JLabel authorInfoLabel;

    private final JTextField userInputField;
    private final JButton makeNewGuessBtn;

    private static final SecureRandom random = new SecureRandom();
    private final static  int LOWER_BOUND = 0;
    private final static int UPPER_BOUND = 5;

    private final Color defaultColor;

    private int guess;

    public GuessNumberGameFrame() {
        super("Guess The Number Game");
        this.setLayout(new BorderLayout(5, 5));

        // Panels labels setup.
        this.northPanel  = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.southPanel  = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.westPanel   = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.eastPanel   = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.defaultColor = this.northPanel.getBackground();

        this.guess = this.makeRandomGuess();

        // Setup for game label
        this.gameInfoLabel = new JLabel(String.format("Computer has guessed a number in [%d, %d]. Find it!",
                                                        LOWER_BOUND, UPPER_BOUND));
        this.gameInfoLabel.setForeground(Color.WHITE);
        this.gameInfoLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        this.authorInfoLabel = new JLabel("github: @ivenpoker");
        this.authorInfoLabel.setForeground(Color.WHITE);
        this.authorInfoLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        // Input field setup
        this.userInputField = new JTextField(25);
        this.addInputFieldListener();
        this.centerPanel.add(this.userInputField);

        // Make guess button setup
        this.makeNewGuessBtn = new JButton("Make a guess");
        this.makeNewGuessBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        this.makeNewGuessBtn.setEnabled(false);
        this.addButtonListener();

        this.centerPanel.add(this.makeNewGuessBtn);


        // Setup for major background colors
        this.northPanel.setBackground(Color.DARK_GRAY);
        this.southPanel.setBackground(Color.DARK_GRAY);

        // Add labels to panels
        this.northPanel.add(this.gameInfoLabel);
        this.southPanel.add(this.authorInfoLabel);


        this.add(this.northPanel, BorderLayout.NORTH);
        this.add(this.centerPanel, BorderLayout.CENTER);
        this.add(this.southPanel, BorderLayout.SOUTH);
        this.add(this.westPanel, BorderLayout.WEST);
        this.add(this.eastPanel, BorderLayout.EAST);
    }

    private int makeRandomGuess() {
        return LOWER_BOUND + random.nextInt(UPPER_BOUND);
    }

    private void alertUserGuessSuccess() {
        Color successColor = new Color(216, 255, 106);
        this.centerPanel.setBackground(successColor);
        this.eastPanel.setBackground(successColor);
        this.westPanel.setBackground(successColor);

    }

    private void alertUserGuessFailure() {
        Color failureColor = new Color(250, 107, 102);
        this.centerPanel.setBackground(failureColor);
        this.eastPanel.setBackground(failureColor);
        this.westPanel.setBackground(failureColor);
    }

    private void resetAlerts() {
        this.centerPanel.setBackground(this.defaultColor);
        this.eastPanel.setBackground(this.defaultColor);
        this.westPanel.setBackground(this.defaultColor);
    }

    private void addInputFieldListener() {
        this.userInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String userInput = evt.getActionCommand();

                if (userInput.isEmpty()) {
                    JOptionPane.showMessageDialog(GuessNumberGameFrame.this,
                            "Please enter your guessed number", "Invalid input", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int userInputInt = Integer.parseInt(userInput);
                        if (userInputInt == GuessNumberGameFrame.this.guess) {
                            // Reveal a UI success
                            GuessNumberGameFrame.this.alertUserGuessSuccess();

                            GuessNumberGameFrame.this.gameInfoLabel.setText("Youpi!!, you've found it!");
                            GuessNumberGameFrame.this.makeNewGuessBtn.setEnabled(true);
                            GuessNumberGameFrame.this.userInputField.setEnabled(false);
                        } else {

                            if (userInputInt < GuessNumberGameFrame.this.guess) {
                                GuessNumberGameFrame.this.gameInfoLabel.setText("Oops, too low!");
                            } else {
                                GuessNumberGameFrame.this.gameInfoLabel.setText("Oops, too high!");
                            }
                            GuessNumberGameFrame.this.alertUserGuessFailure();
                        }

                    } catch (NumberFormatException nFe) {
                        JOptionPane.showMessageDialog(GuessNumberGameFrame.this,
                                "Please your guess must be a number", "Invalid input", JOptionPane.WARNING_MESSAGE);
                    }
                 }
            }
        });
    }

    private void addButtonListener() {
        this.makeNewGuessBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // make a new guess
                GuessNumberGameFrame.this.guess = GuessNumberGameFrame.this.makeRandomGuess();

                // disable the button
                GuessNumberGameFrame.this.makeNewGuessBtn.setEnabled(false);

                // Reset UI success/failure view
                GuessNumberGameFrame.this.resetAlerts();

                // Enable and clear user input field
                GuessNumberGameFrame.this.userInputField.setEnabled(true);

                // alert user about new guess made
                GuessNumberGameFrame.this.gameInfoLabel.setText(
                        String.format("New guess made in the range [%d, %d]. Find it!",
                                GuessNumberGameFrame.LOWER_BOUND, GuessNumberGameFrame.UPPER_BOUND));
            }
        });
    }
}
