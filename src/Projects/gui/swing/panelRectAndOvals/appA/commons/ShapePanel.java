package Projects.gui.swing.panelRectAndOvals.appA.commons;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Objects;

public class ShapePanel extends JPanel {

    private static final int DEFAULT_SHAPE_COUNT = 10;
    private static final int DEFAULT_SHIFT_DIFF = 10;
    private static final ShapeType DEFAULT_SHAPE_TYPE = ShapeType.RECT_OVAL;

    private static final int DEFAULT_START_POS_X = 10;
    private static final int DEFAULT_START_POS_Y = 10;

    private int shapeCount;                 // number of shapes to draw
    private int shiftDiff;                  // Distance between shapes
    private final ShapeType shapeType;

    public ShapePanel() {
        this.shapeType = ShapePanel.DEFAULT_SHAPE_TYPE;
        this.shapeCount = ShapePanel.DEFAULT_SHAPE_COUNT;
        this.shiftDiff = ShapePanel.DEFAULT_SHIFT_DIFF;
    }

    /**
     * Creates a new {@link ShapePanel} {@link JPanel} that can be used to view
     * rectangles, ovals or both with <b>default</b> configurations.
     *
      * @param shapeType Shape type to draw.
     */
    public ShapePanel(ShapeType shapeType) {

        Objects.requireNonNull(shapeType);

        this.shapeType = shapeType;
        this.shapeCount = ShapePanel.DEFAULT_SHAPE_COUNT;
        this.shiftDiff = ShapePanel.DEFAULT_SHIFT_DIFF;
    }

    /**
     * Creates a new {@link ShapePanel} {@link JPanel} that can be used to view
     * rectangles, ovals or both with <b>specified</b> configurations.
     *
     * @param shiftType Shape type to draw.
     * @param shiftCnt Number of shapes of this type to draw.
     * @param shiftDiff Distance between each shape of specified type.
     */
    public ShapePanel(ShapeType shiftType, int shiftCnt, int shiftDiff) {

        Objects.requireNonNull(shiftType);
        this.shapeType = shiftType;

        this.shapeCount = shiftCnt > 0 ? shiftCnt : ShapePanel.DEFAULT_SHAPE_COUNT;
        this.shiftDiff = shiftDiff > 0 ? shiftDiff : ShapePanel.DEFAULT_SHIFT_DIFF;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        switch (this.shapeType) {
            case RECT -> this.drawRect(graphics);
            case OVAL -> this.drawOval(graphics);
            case RECT_OVAL -> {
                this.drawOval(graphics);
                this.drawRect(graphics);
            }
        }
    }

    /**
     * Draw a rectangle on this {@link JPanel} using class configurations.
     * @param graphics {@link Graphics} object to trigger drawing on panel.
     */
    private void drawRect(final Graphics graphics) {
        int shiftX = ShapePanel.DEFAULT_START_POS_X;
        int shiftY = ShapePanel.DEFAULT_START_POS_Y;

        for (int i = 0; i < this.shapeCount; i++) {
            graphics.drawRect(shiftX, shiftY, 2 * shiftX, 2 * shiftY);
            shiftX += this.shiftDiff;
            shiftY += this.shiftDiff;
        }
    }

    /**
     * Draw an oval on this {@link JPanel} using class configuratios.
     * @param graphics {@link Graphics} object to trigger drawing on panel.
     */
    private void drawOval(final Graphics graphics) {
        int shiftX = ShapePanel.DEFAULT_START_POS_X;
        int shiftY = ShapePanel.DEFAULT_START_POS_Y;

        for (int i = 0; i < this.shapeCount; i++) {
            graphics.drawOval(shiftX, shiftY, 2 * shiftX, 2 * shiftY);
            shiftX += this.shiftDiff;
            shiftY += this.shiftDiff;
        }
    }

    // SETTERS

    /**
     * Set number of shapes to draw on this panel.
     *
     * @param numberOfShapesToDraw Number of shapes to draw on panel
     * @return Reference to this panel.
     */
    public ShapePanel setNumberOfShapesToDraw(int numberOfShapesToDraw) {
        if (numberOfShapesToDraw < 0) {
            throw new IllegalArgumentException("Invalid number of shapes to draw");
        }
        this.shapeCount = numberOfShapesToDraw;
        return this;
    }

    public ShapePanel setDistanceDifferenceBetweenShapes(int distDiff) {
        if (distDiff < 0) {
            throw new IllegalArgumentException("Invalid distance between shapes");
        }
        this.shiftDiff = distDiff;
        return this;
    }


}
