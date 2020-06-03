package books.JavaHowToProgram10Ed.chapter_8.GUI_CaseStudy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class MyRectangle {

    private int xCord;      // starting x-coordinate
    private int yCord;      // starting y-coordinate
    private int width;      // width for rectangle
    private int height;     // height for rectangle
    private Color color;    // Rectangle border color
    private boolean isShapeFilled;

    public MyRectangle() {
        this(0, 0, 0, 0, Color.BLACK, false);
    }

    public MyRectangle(int xCord, int yCord, int width, int height, Color color, boolean isShapeFilled) {
        this.setXCord(xCord);
        this.setYCord(yCord);
        this.setWidth(width);
        this.setHeight(height);
        this.setColor(color);
        this.setShapeFilled(isShapeFilled);
    }

    // ##################################### [SET METHODS] #################################
    
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

    public void setShapeFilled(boolean isShapeFilled) {
        this.isShapeFilled = isShapeFilled;
    }

    // ##################################### [GET METHODS] ################################

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

    public boolean isShapeFilled() {
        return this.isShapeFilled;
    }

    public int getUpperLeftX() {
        return this.xCord;
    }

    public int getUpperLeftY() {
        return this.yCord;
    }
    
    public void draw(Graphics graphics) {

        if (this.isShapeFilled()) {
            graphics.setColor(this.getColor());
            graphics.fillRect(this.getXCord(), this.getYCord(), this.getWidth(), this.getHeight());
        } else {
            graphics.setColor(this.getColor());
            graphics.drawRect(this.getXCord(), this.getYCord(), this.getWidth(), this.getHeight());
        }
    }

}
