package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_13;

public class Tetrahedron implements ThreeDimensionalShape {

    private int sideLength;

    public Tetrahedron(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("Invalid side length of Tetrahedron. Must be > 0");
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return this.sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("Invalid side length of Tetrahedron. Must be > 0");
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * Math.pow(this.getSideLength(), 2);
    }

    @Override
    public double getVolume() {
        return Math.pow(this.getSideLength(), 3) / (6 * Math.sqrt(2));
    }

    @Override
    public String toString() {
        return String.format("Tetrahedron [Length: %d, Area: %.2f, %.2f]",
                this.getSideLength(), this.getArea(), this.getVolume());
    }
}
