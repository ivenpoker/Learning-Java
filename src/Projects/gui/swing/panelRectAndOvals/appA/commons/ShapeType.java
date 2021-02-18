package Projects.gui.swing.panelRectAndOvals.appA.commons;

/**
 * Depicts types of Shapes that can be drawn.
 */
public enum ShapeType {
    RECT("line"),
    OVAL("oval"),
    RECT_OVAL("lineOval");

    final String shapeType;

    ShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public String toString() {
        return this.shapeType;
    }
}
