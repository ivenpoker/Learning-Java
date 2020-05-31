package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_15;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltRational ratA = new AltRational(2,4);
        AltRational ratB = new AltRational(3,4);
        AltRational ratC = new AltRational(10, 15);

        System.out.printf("Rat A: %s%n", ratA);
        System.out.printf("Rat A: %s%n", ratB);
        System.out.printf("Rat A: %s%n", ratC);

        System.out.println("===================");
        System.out.printf("Rat A + B: %s%n", AltRational.add(ratA, ratB));
        System.out.printf("Rat B + C: %s%n", AltRational.add(ratB, ratC));

        System.out.println("===================");
        System.out.printf("Rat A - B: %s%n", AltRational.sub(ratA, ratB));
        System.out.printf("Rat B - C: %s%n", AltRational.sub(ratB, ratC));

        System.out.println("===================");
        System.out.printf("Rat A * B: %s%n", AltRational.mul(ratA, ratB));
        System.out.printf("Rat B * C: %s%n", AltRational.mul(ratB, ratC));

        System.out.println("===================");
        System.out.printf("Rat A / B: %s%n", AltRational.div(ratA, ratB));
        System.out.printf("Rat B / C: %s%n", AltRational.div(ratB, ratC));

    }

}

class AltRational {

    private int numerator;
    private int denominator;

    public AltRational() {
        // Defaults to 0/1 -> 0
        this(0, 1);
    }

    public AltRational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid denominator (%d) specified.", denominator));
        }
        int gcdVal = AltRational.gcd(numerator, denominator);
        this.numerator = numerator / gcdVal;
        this.denominator = denominator / gcdVal;
    }

    public static AltRational add(AltRational ratA, AltRational ratB) {
        int newDen = ratA.denominator * ratB.denominator;
        int newNum = (ratA.numerator * ratB.denominator) + (ratB.numerator * ratA.denominator);
        return new AltRational(newDen, newNum);
    }

    public static AltRational sub(AltRational ratA, AltRational ratB) {
        int newDen = ratA.denominator * ratB.denominator;
        int newNum = (ratA.numerator * ratB.denominator) - (ratB.numerator * ratA.denominator);
        return new AltRational(newDen, newNum);
    }

    public static AltRational mul(AltRational ratA, AltRational ratB) {
        return new AltRational((ratA.numerator * ratB.numerator), (ratA.denominator * ratB.denominator));
    }

    public static AltRational div(AltRational ratA, AltRational ratB) {
        AltRational revRatB = new AltRational(ratB.denominator, ratB.denominator);
        return AltRational.mul(ratA, revRatB);
    }
    private static int gcd(int u, int v) {
        int tmp;
        while (u > 0) {
            if (u < v) {
                tmp = u;
                u = v;
                v = tmp;
            }
            u = u-v;
        }
        return v;
    }

    @Override
    public String toString() {
        return String.format("%.1f/%.1f", (float) this.numerator, (float) this.denominator);
    }

}
