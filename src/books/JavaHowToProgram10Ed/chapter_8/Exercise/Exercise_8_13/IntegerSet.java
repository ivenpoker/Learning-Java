// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.13 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_13;

public class IntegerSet {

    private boolean[] _set;
    private int _itemCnt;

    public IntegerSet(int range) {
        this._set = new boolean[range];
        this._itemCnt = 0;
    }

    public IntegerSet() {
        this(100);
    }

    public static IntegerSet union(IntegerSet setA, IntegerSet setB) {
        int rangeA = setA._set.length;
        int rangeB = setB._set.length;
        int rangeC = rangeA < rangeB ? rangeB : rangeA;

        int loopRange = rangeA < rangeB ? rangeA : rangeB;
        IntegerSet setC = new IntegerSet(rangeC);

        for (int i = 0; i < loopRange; i++) {
            if (setA._set[i] || setB._set[i])
                setC.insertElement(i);
        }
        return setC;
    }

    public static IntegerSet intersection(IntegerSet setA, IntegerSet setB) {
        int rangeA = setA._set.length;
        int rangeB = setB._set.length;
        int rangeC = rangeA < rangeB ? rangeB : rangeA;

        int loopRange = rangeA < rangeB ? rangeA : rangeB;
        IntegerSet setC = new IntegerSet(rangeC);

        for (int i = 0; i < loopRange; i++) {
            if (setA._set[i] && setB._set[i])
                setC.insertElement(i);
        }
        return setC;
    }

    public void insertElement(int index) {
        if (!this.inRange(0, index, this._set.length-1))
            throw new IllegalArgumentException("Invalid index to insert");
        this._set[index] = true;
        this._itemCnt++;
    }

    public void deleteElement(int index) {
        if (!this.inRange(0, index, this._set.length-1))
            throw new IllegalArgumentException("Invalid index to delete");
        this._set[index] = false;
        this._itemCnt--;

    }

    private boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    public String toString() {
        if (_itemCnt == 0) {
            return "---";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this._set.length; i++)
                if (this._set[i])
                    sb.append(String.format(" %02d ", i));
            return sb.toString().trim();
        }
    }

    public boolean isEqualTo(IntegerSet setB) {
        if (this._set.length != setB._set.length)
            return false;
        for (int i = 0; i < this._set.length; i++)
            if (this._set[i] != setB._set[i])
                return false;
        return true;
    }

    public int getSize() {
        return this._set.length;
    }

}
