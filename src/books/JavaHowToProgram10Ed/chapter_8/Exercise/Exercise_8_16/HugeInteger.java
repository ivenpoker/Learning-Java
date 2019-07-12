package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_16;

import books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_13.IntegerSet;

public class HugeInteger {

    private int[] _digits;

    public HugeInteger(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid size for Huge integer");
        this._digits = new int[size];
    }

    public int charAt(int index) {
        if (!this.inRange(0, index, this._digits.length))
            throw new IllegalArgumentException("Invalid index");
        return this._digits[index];
    }

    public static HugeInteger parse(String someString) {
        HugeInteger newSet = new HugeInteger(someString.length());
        for (int i = 0; i < someString.length(); i++) {
            if (!Character.isDigit(someString.charAt(i)))
                throw new IllegalArgumentException(String.format("Invalid string. '%c' is not a digit",
                        someString.charAt(i)));
            newSet.setVal(i, Integer.parseInt("" + someString.charAt(i)));
        }
        return newSet;
    }

    public String toString() {
        String tmp = "";
        for (int digit : this._digits)
            tmp += digit;
        return tmp;
    }
//
//    public static HugeInteger sub(HugeInteger int1, HugeInteger int2) {
////        for (int i = 0; i < )
//    }

    private void setVal(int index, int val) {
        if (!this.inRange(0, index, this._digits.length))
            throw new IllegalArgumentException("Invalid index");
        this._digits[index] = val;
    }

    private boolean inRange(int low, int val, int upper) {
        return low <= val && val <= upper;
    }
}
