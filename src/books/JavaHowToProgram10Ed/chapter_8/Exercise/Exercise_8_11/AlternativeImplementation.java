package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_11;

public class AlternativeImplementation {

    public static void main(String[] args) {

        Complex complexA = new Complex();
        Complex complexB = new Complex(2, 1);
        Complex complexC = new Complex(-1, 4);

        System.out.printf("%10s: %s%n", "Complex A", complexA);
        System.out.printf("%10s: %s%n", "Complex B", complexB);
        System.out.printf("%10s: %s%n", "Complex C", complexC);

        System.out.printf("%10s: %s%n", "Complex (A + B)", complexA.add(complexB));
        System.out.printf("%10s: %s%n", "Complex (B + C)", complexB.add(complexC));
        System.out.printf("%10s: %s%n", "Complex (C - B)", complexC.subtract(complexB));
    }
}

class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        this(0.0, 0.0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // ###################### [GETTERS METHOD] #####################

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    // ###################### [SETTERS METHOD] #####################

    public void setReal(double newReal) {
        this.real = newReal;
    }

    public void setImaginary(double newImaginary) {
        this.imaginary = newImaginary;
    }

    // ###################### [OTHER METHODS] ######################

    public Complex add(Complex another) {
        return new Complex(this.real + another.real, this.imaginary + another.imaginary);
    }

    public Complex subtract(Complex another) {
        return new Complex(this.real - another.real, this.imaginary - another.imaginary);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.real, this.imaginary);
    }
}
