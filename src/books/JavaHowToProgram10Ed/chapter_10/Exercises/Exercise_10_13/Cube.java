package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_13;

public class Cube implements ThreeDimensionalShape {

    private int edgeLength;

    public Cube(int edgeLength) {
        if (edgeLength <= 0)
            throw new IllegalArgumentException("Invalid edge length. Must be > 0");
        this.edgeLength = edgeLength;
    }

    public int getEdgeLength() {
        return this.edgeLength;
    }

    public void setEdgeLength(int edgeLength) {
        if (edgeLength <= 0)
            throw new IllegalArgumentException("Invalid edge length. Must be > 0");
        this.edgeLength = edgeLength;
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(this.getEdgeLength(), 2);
    }

    @Override
    public double getVolume() {
        return Math.pow(this.getEdgeLength(), 3);
    }

    @Override
    public String toString() {
        return String.format("Cube [Edge: %d, Area: %.2f, Volume: %.2f]",
                this.getEdgeLength(), this.getArea(), this.getVolume());
    }
}
