package books.JavaHowToProgram10Ed.chapter_9.GUI_CaseStudy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class MyOval {

    private int xCord;            // x-coordinate to create 'invisible' rectangle
    private int yCord;            // y-coordinate to create 'invisible' rectangle
    private int width;            // width for 'invisible' rectangle
    private int height;           // height for 'invisible' rectangle
    private Color color;          // outline color for oval
    private boolean isSpaceFilled;

    public MyOval() {
        this(0, 0, 0, 0, Color.BLACK, false);
    }

    public MyOval(int xCord, int yCord, int width, int height, Color color, boolean isSpaceFilled) {
        this.setXCord(xCord);
        this.setYCord(yCord);
        this.setWidth(width);
        this.setHeight(height);
        this.setColor(color);
        this.setSpaceFilled(isSpaceFilled);
    }

    // ############################## [SET METHODS] ##################################

    public void setXCord(int newXCord) {
        this.xCord = Math.max(newXCord, 0);
    }

    public void setYCord(int newYCord) {
        this.yCord = Math.max(newYCord, 0);
    }

    public void setWidth(int newWidth) {
        this.width = Math.max(newWidth, 0);
    }

    public void setHeight(int newHeight) {
        this.height = Math.max(newHeight, 0);
    }

    public void setColor(Color newColor) {
        if (!Objects.isNull(newColor)) {
            this.color = newColor;
        }
    }

    public void setSpaceFilled(boolean isSpaceFilled) {
        this.isSpaceFilled = isSpaceFilled;
    }

    // ############################# [GET METHODS] ##################################

    public int getXCord() {
        return this.xCord;
    }

    public int getYCord() {
        return this.yCord;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean getSpaceFilled() {
        return this.isSpaceFilled;
    }

    public int getUpperLeftX() {
        return this.xCord;
    }

    public int getUpperLeftY() {
        return this.yCord;
    }

    public void draw(Graphics graphics) {

        if (this.getSpaceFilled()) {
            graphics.setColor(this.getColor());
            graphics.fillOval(this.getXCord(), this.getYCord(), this.getWidth(), this.getHeight());
        } else {
            graphics.setColor(this.getColor());
            graphics.drawOval(this.getXCord(), this.getYCord(), this.getWidth(), this.getHeight());
        }
    }

}
