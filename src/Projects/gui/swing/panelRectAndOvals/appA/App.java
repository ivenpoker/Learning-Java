package Projects.gui.swing.panelRectAndOvals.appA;

import Projects.gui.swing.panelRectAndOvals.appA.commons.ShapePanel;
import Projects.gui.swing.panelRectAndOvals.appA.commons.ShapeType;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.util.Objects;

/**
 * Main Entry Point For App
 */
public class App {

    private static final int APP_WIDTH = 400;
    private static final int APP_HEIGHT = 400;
    private static final int APP_EXIT_SUCCESS = 1;

    private static final String INVALID_INPUT_MESSAGE = "Invalid input";
    private static final String NO_SHAPE_SELECT_MESSAGE = "A shape type is needed to proceed";
    private static final String SHAPE_SELECT_TYPE_MESSAGE = "Please select type of shape to draw." +
            "\n\t1. Rectangle\n\t2. Oval\n\t3. Rectangle and Oval\n";


    /**
     * Obtain the shape type from the user making use of bounds.
     * @param lowerBound Lowest input entry from shapes menu to consider.
     * @param upperBound Highest input entry from shapes type menu to consider.
     * @return A user specified shape type.
     */
    public static ShapeType getShapeTypeFromUser(int lowerBound, int upperBound, ShapeType[] shapeTypes) {
        int userRespInt = -1;
        while (!inRange(lowerBound, userRespInt, upperBound)) {
            String userResp = JOptionPane.showInputDialog(null, App.SHAPE_SELECT_TYPE_MESSAGE,
                    "Select Shape(s) Type", JOptionPane.INFORMATION_MESSAGE);

            if (Objects.isNull(userResp)) {
                JOptionPane.showMessageDialog(null, App.NO_SHAPE_SELECT_MESSAGE,
                        "", JOptionPane.WARNING_MESSAGE);
                System.exit(App.APP_EXIT_SUCCESS);
            }

            try {
                userRespInt = Integer.parseInt(userResp);
                if (!inRange(lowerBound, userRespInt, upperBound)) {
                    throw new IllegalArgumentException(App.INVALID_INPUT_MESSAGE);
                }
                return shapeTypes[userRespInt-1];

            } catch (IllegalArgumentException nFe) {
                JOptionPane.showMessageDialog(null, App.INVALID_INPUT_MESSAGE,
                        "", JOptionPane.ERROR_MESSAGE);
            }
        }
        return shapeTypes[shapeTypes.length-1];
    }

    /**
     * Determines of <code>val</code> is in the range [<code>lower</code>, <code>upper</code>].
     *
     * @param lower Lower bound to consider.
     * @param val Value to check if occurring within bounds.
     * @param upper Upper bound to consider.
     * @return <code>true</code> if <code>val</code> is in range [<code>lower</code>, <code>upper</code>]
     *               else returns <code>false</code>
     */
    private static boolean inRange(int lower, int val, int upper) {
        return lower <= val && val <= upper;
    }

    /**
     * Setup Look And Feel for this application.
     */
    public static void initLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception exc) {
            // If Nimbus is not available, fallback to cross-latform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            } catch (Exception coreExc) {
                coreExc.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        // Setup look and feel of application.
        App.initLookAndFeel();

        JFrame application = new JFrame("Demonstrating Rectangles & Ovals 🥴");

        ShapeType userShapeType = getShapeTypeFromUser(1, 3, ShapeType.values());

        application.add(new ShapePanel(userShapeType)
                            .setNumberOfShapesToDraw(10)
                            .setDistanceDifferenceBetweenShapes(10));

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(App.APP_WIDTH, App.APP_HEIGHT);
        application.setVisible(true);
    }
}
