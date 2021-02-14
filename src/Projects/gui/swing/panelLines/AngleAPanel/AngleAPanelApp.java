package Projects.gui.swing.panelLines.AngleAPanel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Objects;

/**
 * Class (Run-Class) that contains the code to show a series of lines
 * (Angle-A lines - Lines originating from top left corner of the {@link JPanel} in the {@link JFrame})
 */
public class AngleAPanelApp {

    private static final int EXIT_SUCCESS = 0;
    private static final int MIN_LINE_COUNT = 2;
    private static final String INTRO_STR =
            "\t\tWelcome to the Angle A Panel Application.\n\n" +
            "Application displays specific number of lines from origin \nwith specified spacing between each lines.\n" +
            "\nTo continue, you'll need to provide ...\n\n1. Number of lines to draw.\n2. Spaces between each line.";

    /**
     * Retrieves integer input from the user, taking into consideration a minimum value as lower bound.
     *
     * @param inputMess {@link String} input message to show to user.
     * @param minValue Lower bound for possible values that can be entered by the user.
     * @throws IllegalStateException if data is less than a minimum value
     *                               (<code>minValue</code>)
     * @throws NumberFormatException If user provided data is not a parsable <code>int</cod>
     * @return Integer input from user.
     */
    private static int obtainUserIntInput(String inputMess, int minValue)
            throws IllegalStateException, NumberFormatException {

        Objects.requireNonNull(inputMess);
        String userInput = JOptionPane.showInputDialog(inputMess);

        if (Objects.isNull(userInput)) {
            System.exit(AngleAPanelApp.EXIT_SUCCESS);
        }

        int userInt = Integer.parseInt(userInput);
        if (userInt < minValue) {
            throw new IllegalStateException("Invalid data obtained");
        }
        return userInt;
    }

    /**
     * Obtains number of lines specified from the user to be drawn in the panel,
     * handling possible errors.
     * @return Number of lines to draw in the panel, specified by user.
     */
    private static int getNumberOfLinesFromUser() {
        int numLines = 0;
        while (numLines < AngleAPanelApp.MIN_LINE_COUNT) {
            try {
                numLines = obtainUserIntInput(String.format("Enter number of lines to generate (minimum of %s)",
                        AngleAPanelApp.MIN_LINE_COUNT), AngleAPanelApp.MIN_LINE_COUNT);

            } catch (NumberFormatException nFe) {
                JOptionPane.showMessageDialog(null, "Invalid number of lines. Must be an integer",
                        "Invalid input", JOptionPane.WARNING_MESSAGE);

            } catch (IllegalStateException iSe) {
                JOptionPane.showMessageDialog(null, String.format("Minimum number of lines is %d",
                        AngleAPanelApp.MIN_LINE_COUNT), "Invalid input", JOptionPane.WARNING_MESSAGE);
            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        return numLines;
    }

    /**
     * Gets the minimum distance between two lines. This the value that determines how far
     * two lines are from each other.
     * @return
     */
    private static int getMinimumDistanceFromUser() {
        int minDistance = -1;
        while (minDistance < 0) {
            try {
                minDistance = AngleAPanelApp.obtainUserIntInput("Enter distance between" +
                        " lines as integer (e.g 5)", 0);
            } catch (IllegalStateException iSe) {
                JOptionPane.showMessageDialog(null, "Invalid OR no input. Must be integer",
                        "Invalid OR No input", JOptionPane.WARNING_MESSAGE);

            } catch (NumberFormatException nFe) {
                JOptionPane.showMessageDialog(null, "Invalid input. Must be a valid integer value",
                        "Invalid input", JOptionPane.WARNING_MESSAGE);

            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "UNKNOWN ERROR OCCURRED",
                        "System Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, AngleAPanelApp.INTRO_STR, "Welcome",
                JOptionPane.INFORMATION_MESSAGE);

        int numOfLines = getNumberOfLinesFromUser();
        int minimumDistanceBetweenLines = AngleAPanelApp.getMinimumDistanceFromUser();

        // New frame to attach/add a PanelA object to it.
        JFrame application = new JFrame("Angle A Lines");

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(new AngleALines(numOfLines, minimumDistanceBetweenLines));
        application.setSize(250, 250);
        application.setVisible(true);

    }
}
