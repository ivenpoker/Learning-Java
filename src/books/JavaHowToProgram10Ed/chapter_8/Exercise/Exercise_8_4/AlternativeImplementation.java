package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_4;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltRectangle rect1 = new AltRectangle();                         // defaults => (width = 1, length = 1)
        AltRectangle rect2 = new AltRectangle(3.0f, 10.0f);

        System.out.printf("Rect 1: %s%n", rect1);
        System.out.printf("Rect 2: %s%n", rect2);

        System.out.println("================================");
        System.out.printf("Area 1: %.1f | Perimeter: %.2f%n", rect1.area(), rect1.perimeter());
        System.out.printf("Area 2: %.1f | Perimeter: %.2f%n", rect2.area(), rect2.perimeter());
    }
}

// A class with name 'Rectangle' has package access, had to rename it to 'AltRectangle'
// to avoid conflicts with the other 'Rectangle' in this folder.

class AltRectangle {

    private float width;
    private float length;

    public AltRectangle() {
        this(1.0f, 1.0f);
    }

    public AltRectangle(float width, float length) {
        this.width = width;
        this.length = length;
    }

    public void setWidth(float newWidth) {
        if (this.inBounds(0.0f, newWidth, 20.0f)) {
            this.width = newWidth;
        }
    }

    public void setLength(float newLength) {
        if (this.inBounds(0.0f, newLength, 20.0f)) {
            this.length = newLength;
        }
    }

    public float getWidth() {
        return this.width;
    }

    public float getLength() {
        return this.length;
    }

    private boolean inBounds(float low, float val, float high) {
        return low <= val && val <= high;
    }

    public float perimeter() {
        return 2.0f * (this.getLength() + this.getWidth());
    }

    public float area() {
        return this.getLength() * this.getWidth();
    }

    @Override
    public String toString() {
        return String.format("[%.1f, %.1f]", this.getWidth(), this.getLength());
    }
}