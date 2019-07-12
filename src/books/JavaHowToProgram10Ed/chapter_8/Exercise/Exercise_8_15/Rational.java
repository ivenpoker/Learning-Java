// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.15 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_15;

public class Rational {

    private int _denom;
    private int _numer;

    public Rational(int denominator, int numerator) {
        this.simplifyAndSet(denominator, numerator);
    }

    public Rational() {
        this.simplifyAndSet(1, 1);
    }

    private void simplifyAndSet(int valA, int valB) {
        int gcdVal = Rational.gcd(valA, valB);
        this._numer = valA / gcdVal;
        this._denom = valB / gcdVal;
    }

    public static Rational add(Rational ratA, Rational ratB) {
        return new Rational((ratA._numer * ratB._denom + ratB._numer * ratA._denom),
                ratA._denom * ratB._denom);
    }

    public static Rational sub(Rational ratA, Rational ratB) {
        return new Rational((ratA._numer * ratB._denom - ratB._numer * ratA._denom),
                ratA._denom * ratB._denom);
    }

    public static Rational mul(Rational ratA, Rational ratB) {
        return new Rational(ratA._numer * ratB._numer, ratA._denom * ratB._denom);
    }

    public static Rational div(Rational ratA, Rational ratB) {
        return Rational.mul(ratA, new Rational(ratB._denom, ratB._numer));
    }

    public String toString() {
        return String.format("%d/%d", this._numer, this._denom);
    }

    public String toFloatString() {
        return String.format("%.2f/%.2f", (float) this._numer, (float) this._denom);
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

}
