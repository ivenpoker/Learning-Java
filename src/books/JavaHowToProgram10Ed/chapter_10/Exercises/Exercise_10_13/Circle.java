package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_13;

public class Circle implements TwoDimensionalShape {

    private int radius;

    public Circle(int radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Invalid radius. Must be > 0");
        this.radius = radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Invalid radius. Must be > 0");
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    @Override
    public String toString() {
        return String.format("Circle [radius: %d, area: %.2f]", this.getRadius(),
                this.getArea());
    }
}
