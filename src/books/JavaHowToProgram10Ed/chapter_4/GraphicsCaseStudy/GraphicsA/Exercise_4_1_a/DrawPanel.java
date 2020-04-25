package books.JavaHowToProgram10Ed.chapter_4.GraphicsCaseStudy.GraphicsA.Exercise_4_1_a;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        int MAX_NUM_LINES = 20;

        int width = 0;                          // base point, width value to be used.
        int height = getHeight();               // obtain the height of the current panel
        int mainDiff = getWidth() / 20;         // computation used to separate lines, using width of current panel


        // Drawing upper left lines

        int upperLeftNumOfLines = MAX_NUM_LINES;
        while (upperLeftNumOfLines > 0) {
            graphics.drawLine(0, 0, width, height);         // draw line based on current height and width
            width += mainDiff;                                      // set new width difference
            height -= mainDiff;                                     // set new height difference
            upperLeftNumOfLines -= 1;
        }

        // Drawing upper right lines

        width = getWidth();
        height = getHeight();

        int upperRightNumOfLines = MAX_NUM_LINES;
        while (upperRightNumOfLines > 0) {
            graphics.drawLine(getWidth(), 0, width, height);
            width -= mainDiff;
            height -= mainDiff;
            upperRightNumOfLines -= 1;
        }

        // Drawing lower left lines

        width = 0;
        height = 0;

        int lowerLeftLines = MAX_NUM_LINES;
        while (lowerLeftLines > 0) {
            graphics.drawLine(0, getHeight(), width, height);
            width += mainDiff;
            height += mainDiff;
            lowerLeftLines -= 1;
        }

        // Drawing lower right lines

        width = getWidth();
        height = 0;

        int lowerRightLines = MAX_NUM_LINES;
        while (lowerRightLines > 0) {
            graphics.drawLine(getWidth(), getHeight(), width, height);
            width -= mainDiff;
            height += mainDiff;
            lowerRightLines -= 1;
        }

    }


}
