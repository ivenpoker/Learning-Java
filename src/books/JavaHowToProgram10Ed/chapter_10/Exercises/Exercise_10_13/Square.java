package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_13;

public class Square implements TwoDimensionalShape {

    private int sideLength;

    public Square(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("Invalid side length of square. Must be > 0");
        this.sideLength = sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("Invalid side length of square. Must be > 0");
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return this.sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(this.getSideLength(), 2);
    }

    @Override
    public String toString() {
        return String.format("Square [sideLength: %d, area: %.2f]",
                this.getSideLength(), this.getArea());
    }

}
