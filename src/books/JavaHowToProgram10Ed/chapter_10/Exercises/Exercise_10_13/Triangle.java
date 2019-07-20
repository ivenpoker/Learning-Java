package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_13;

public class Triangle implements TwoDimensionalShape {

    private int base;
    private int height;

    public Triangle(int base, int height) {
        if (base <= 0)
            throw new IllegalArgumentException("Invalid base. Must be > 0");
        if (height <= 0)
            throw new IllegalArgumentException("Invalid height. Must be > 0");
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return this.base;
    }

    public int getHeight() {
        return this.height;
    }

    public void setBase(int base) {
        if (base <= 0)
            throw new IllegalArgumentException("Invalid base. Must be > 0");
        this.base = base;
    }

    public void setHeight(int height) {
        if (height <= 0)
            throw new IllegalArgumentException("Invalid height. Must be > 0");
    }

    @Override
    public double getArea() {
        return (1.0/2) * this.getBase() * this.getHeight();
    }

    @Override
    public String toString() {
        return String.format("Triangle [Base: %d, Height: %d, Area: %.2f]",
                this.getBase(), this.getHeight(), this.getArea());
    }
}
