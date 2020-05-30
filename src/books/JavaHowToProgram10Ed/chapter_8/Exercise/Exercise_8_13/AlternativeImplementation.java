package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_13;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltIntegerSet setA = new AltIntegerSet();
        System.out.printf("%20s: %s%n", "Set A", setA);

        // Reveal all even numbers in set.
        for (int i = 0; i < AltIntegerSet.MAX_SET_SIZE; i += 2) {
            setA.insertElement(i);
        }
        System.out.printf("%20s: %s%n", "Modified Set A", setA);
        System.out.println();

        AltIntegerSet setB = new AltIntegerSet();
        System.out.printf("%20s: %s%n", "Set B", setB);

        // Reveal all odd numbers in set
        for (int i = 1; i < AltIntegerSet.MAX_SET_SIZE; i += 2) {
            setB.insertElement(i);
        }
        System.out.printf("%20s: %s%n", "Modified Set B", setB);
        System.out.println();

        // Find the union of A and B
        AltIntegerSet unionAB = AltIntegerSet.union(setA, setB);
        System.out.printf("%20s: %s%n", "Union A and B", unionAB);

        // Find the intersection of A and B (should be an all empty set)
        AltIntegerSet intersectAB = AltIntegerSet.intersection(setA, setB);
        System.out.printf("%20s: %s%n", "Intersect A and B", intersectAB);
    }

}

class AltIntegerSet {

    private boolean[] set;
    public static final int MAX_SET_SIZE = 100;

    public AltIntegerSet() {
        this.set = new boolean[MAX_SET_SIZE];
    }

    public void validateIndex(int idx) {
        if (!this.inBounds(0, idx, MAX_SET_SIZE)) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified index (%d). Must be in range [%d, %d]",
                            idx, 0, MAX_SET_SIZE));
        }
    }

    public void insertElement(int k) {
        this.validateIndex(k);
        this.set[k] = true;
    }

    public void deleteElement(int k) {
        this.validateIndex(k);
        this.set[k] = false;
    }

    public boolean inBounds(int low, int val, int high) {
        return low <= val && val <= high;
    }

    public static AltIntegerSet union(AltIntegerSet setA, AltIntegerSet setB) {
        AltIntegerSet setC = new AltIntegerSet();
        for (int i = 0; i < MAX_SET_SIZE; i++) {
            if (setA.set[i] || setB.set[i]) {
                setC.set[i] = true;
            }
        }
        return setC;
    }

    public static AltIntegerSet intersection(AltIntegerSet setA, AltIntegerSet setB) {
        AltIntegerSet setC = new AltIntegerSet();
        for (int i = 0; i < MAX_SET_SIZE; i++) {
            if (setA.set[i] && setB.set[i]) {
                setC.set[i] = true;
            }
        }
        return setC;
    }

    @Override
    public String toString() {
        String results = "[";
        for (int i = 0; i < MAX_SET_SIZE; i++) {
            if (this.set[i]) {
                results += String.format("%d ", i);
            } else {
                results += "- ";
            }
        }
        results += "]";
        return results;
    }
}


















































