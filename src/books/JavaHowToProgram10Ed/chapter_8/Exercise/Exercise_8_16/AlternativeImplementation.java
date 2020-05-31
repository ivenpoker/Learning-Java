package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_16;

public class AlternativeImplementation {

    public static void main(String[] args) {
        
        HugeInteger hugeA = new HugeInteger();

        System.out.println("=============== [ADDITION TEST] ================");

        String test = "6234568377";
        hugeA.parse(test);
        System.out.printf("%12s: %20s%n", "Huge A", hugeA);

        HugeInteger hugeB = new HugeInteger();
        hugeB.parse(test);
        System.out.printf("%12s: %20s%n", "Huge B", hugeB);

        HugeInteger sumAB = hugeA.add(hugeB);
        System.out.printf("%12s: %20s%n", "Sum A and B", sumAB);
        System.out.println();


        System.out.println("============== [SUBTRACTION TEST] ==============");
        // ##################### TESTING FOR SUBTRACTION ########################

        String subC = "7";
        String subD = "20";

        HugeInteger hugeC = new HugeInteger();
        hugeC.parse(subC);

        HugeInteger hugeD = new HugeInteger();
        hugeD.parse(subD);

        System.out.printf("%12s: %20s%n", "Huge C", hugeC);
        System.out.printf("%12s: %20s%n", "Huge D", hugeD);
        System.out.printf("%12s: %20s%n", "Diff (C - D)", hugeC.sub(hugeD));
        System.out.println();

        System.out.println("============= [NEGATION TEST] =================");
        String negA = "123";
        String negB = "-8342";

        HugeInteger hugeE = new HugeInteger();
        hugeE.parse(negA);

        HugeInteger hugeF = new HugeInteger();
        hugeF.parse(negB);

        System.out.printf("%12s: %20s%n", "Huge E", hugeE);
        System.out.printf("%12s: %20s%n", "Huge F", hugeF);
        System.out.printf("%12s: %20s%n", "Huge E (neg)", HugeInteger.negate(hugeE));
        System.out.printf("%12s: %20s%n", "Huge F (neg)", HugeInteger.negate(hugeF));
    }

}

class HugeInteger {
    private static final int MAX_DIGITS_SIZE = 10;
    private int[] digits;

    public HugeInteger() {
        this.digits = new int[HugeInteger.MAX_DIGITS_SIZE];
    }

    public void parse(String digitsStr) {

        boolean isNegative = false;
        if (digitsStr.length() > 1) {
            if (digitsStr.charAt(0) == '-' && Character.isDigit(digitsStr.charAt(1))) {
                isNegative = true;
            }
        }

        DigitCnt digitData = this.numDigits(digitsStr);
        int startIdx = this.digits.length - digitData.numDigits;

        for (int i = startIdx, j = 0; i < this.digits.length; i++) {
            if (isNegative && i == startIdx) {
                this.digits[i] = - Integer.parseInt(digitData.digitsStr.charAt(j++) + "");
            } else {
                this.digits[i] = Integer.parseInt(digitData.digitsStr.charAt(j++) + "");
            }
        }
    }

    public HugeInteger sub(HugeInteger another) {
        HugeInteger hugeDiff = new HugeInteger();
        if (this.isLessThan(another)) {
            HugeInteger newDiff =  another.sub(this);
            return HugeInteger.negate(newDiff);
        }
        for (int i = this.digits.length-1; i >= 0; i--) {
            int diff = this.digits[i] - another.digits[i];
            if (diff < 0) {
                int tmpThisDigit = 0;
                if (i > 0) {
                    if (this.digits[i-1] > 0) {
                        tmpThisDigit = 10 + this.digits[i];     // add 10 to 'this' current digit
                        diff = tmpThisDigit - another.digits[i];    // find new difference between numbers
                        this.digits[i-1] -= 1;
                    }
                }

                // update the next digit (if any) to reflect 'borrow' state
//                if (i > 0) {
//                    this.digits[i-1] -= 1;
//                }

            }
            hugeDiff.digits[i] = diff;
        }
        return hugeDiff;
    }

    public HugeInteger add(HugeInteger another) {

        if (this.isNegative() && !another.isNegative()) {           // for '-a + b'
            return another.sub(this);                               // same as 'b - a'
        } else if (!this.isNegative() && another.isNegative()) {    // for 'a + (-b)'
            return this.sub(another);
        }

        HugeInteger hugeSum = new HugeInteger();
        int carry = 0;
        for (int i = this.digits.length-1; i >= 0; i--) {
            int sum = (this.digits[i] + another.digits[i]) + carry;
            if (sum >= 10) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry = 0;
            }
            hugeSum.digits[i] = sum;
        }
        if (carry > 0) {
            HugeInteger extendedHuge = new HugeInteger();
            extendedHuge.digits = new int[MAX_DIGITS_SIZE + 1];
            extendedHuge.digits[0] = carry;
            System.arraycopy(hugeSum.digits, 0, extendedHuge.digits, 1, extendedHuge.digits.length - 1);
            return extendedHuge;
        }
        return hugeSum;
    }

    private boolean isEqualTo(HugeInteger another) {
        for (int i = 0; i < this.digits.length; i++) {
            if (another.digits[i] != this.digits[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotEqualTo(HugeInteger another) {
        return !this.isEqualTo(another);
    }

    public boolean isGreaterThan(HugeInteger another) {
        for (int i = 0; i < this.digits.length; i++) {
            if (this.digits[i] > another.digits[i]) {
                return true;
            } else if (this.digits[i] < another.digits[i]) {
                return false;
            }
        }
        // At this point they should be same
        return false;
    }

    public boolean isLessThan(HugeInteger another) {
        for (int i = 0; i < this.digits.length; i++) {
            if (this.digits[i] < another.digits[i]) {
                return true;
            } else if (this.digits[i] > another.digits[i]) {
                return false;
            }
        }
        return false;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger another) {
        return !this.isLessThan(another);
    }

    public boolean isLessThanOrEqualTo(HugeInteger another) {
        return !this.isGreaterThan(another);
    }

    public boolean isZero() {
        for (int digit : this.digits) {
            if (digit != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isNegative() {
        for (int digit : this.digits) {
            if (digit < 0) {
                return true;
            } else if (digit > 0) {
                return false;
            }
        }
        return false;
    }

    public static HugeInteger negate(HugeInteger another) {
        HugeInteger hugeNeg = new HugeInteger();
        for (int i = 0; i < another.digits.length; i++) {
            if (another.digits[i] != 0) {
                hugeNeg.digits[i] = -another.digits[i];
                for (int j = i+1; j < another.digits.length; j++) {
                    hugeNeg.digits[j] = another.digits[j];
                }
                break;
            }
        }
        return hugeNeg;
    }

    private DigitCnt numDigits(String someStr) {
        int cntChar = 0;
        String digitStr = "";
        for (char ch : someStr.toCharArray()) {
            if (Character.isDigit(ch)) {
                cntChar += 1;
                digitStr += ch;
            }
        }
        return new DigitCnt(digitStr, cntChar);
    }


    @Override
    public String toString() {
        String digitsResult = "[";
        for (int i = 0; i < this.digits.length; i++) {
            if (i == this.digits.length-1) {
                digitsResult += String.format("%2d ]", this.digits[i]);
            } else {
                digitsResult += String.format("%2d, ", this.digits[i]);
            }
        }
        return digitsResult;
    }
}

class DigitCnt {
    public int numDigits;
    public String digitsStr;

    public DigitCnt(String someStr, int numDigits) {
        this.numDigits = numDigits;
        this.digitsStr = someStr;
    }
}