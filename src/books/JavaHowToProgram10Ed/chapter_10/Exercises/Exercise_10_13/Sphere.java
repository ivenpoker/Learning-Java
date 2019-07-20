package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_13;

public class Sphere implements ThreeDimensionalShape {

    public int radius;

    public Sphere(int radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Invalid radius for sphere. Must be > 0");
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Invalid radius for sphere. Must be > 0");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(this.getRadius(), 2);
    }

    @Override
    public double getVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(this.getRadius(), 3);
    }

    @Override
    public String toString() {
        return String.format("Sphere [Radius: %s, Area: %.2f, Volume: %.2f]",
                this.getRadius(), this.getArea(), this.getVolume());
    }
}
