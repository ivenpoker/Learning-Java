package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_13;

public class App {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];

        shapes[0] = new Square(12);
        shapes[1] = new Triangle(12, 20);
        shapes[2] = new Circle(8);

        // Three dimensional shapes

        shapes[3] = new Cube(6);
        shapes[4] = new Sphere(3);
        shapes[5] = new Tetrahedron(7);

        // Print text object (String representation of object)

        for (Shape shape : shapes)
            System.out.println(shape);

        System.out.println("----------------------------------------");

        for (Shape shape : shapes) {
            if (shape instanceof TwoDimensionalShape) {
                System.out.printf("[2DS] --> Area: %.2f\n", shape.getArea());
            } else {    // three dimensional shape
                System.out.printf("[3DS] --> Area: %.2f | Volume: %.2f\n",
                        shape.getArea(), ((ThreeDimensionalShape) shape).getVolume());
            }
        }
    }
}
