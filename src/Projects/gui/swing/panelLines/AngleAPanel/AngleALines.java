package Projects.gui.swing.panelLines.AngleAPanel;

import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * JPanel that paints a series of lines sourcing from (0, 0) of the
 * panel coordinate system.
 */
public class AngleALines extends JPanel {
    private final int MAX_NUM_OF_LINES;
    private final int CHANGE_STEP;

    public AngleALines(int maxNumLines, int linesDist) {
        assert maxNumLines > 0;
        assert linesDist >= 0;

        this.MAX_NUM_OF_LINES = maxNumLines;
        this.CHANGE_STEP = linesDist;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startWidth = this.CHANGE_STEP;
        int startHeight = this.getHeight() - this.CHANGE_STEP;

        // Draw all the lines with specific configurations
        for (int i = 0; i < this.MAX_NUM_OF_LINES; i++) {
            g.drawLine(0, 0, startWidth, startHeight);
            startWidth += this.CHANGE_STEP;
            startHeight -= this.CHANGE_STEP;
        }
    }
}
