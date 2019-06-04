package books.DataStructuresAndAlgorithms_6thEd.chapter_2;

public class App {

    public static abstract class AbstractProgression {
        protected long _current;

        public AbstractProgression() {
            this(0);
        }

        public AbstractProgression(long start) {
            this._current = start;
        }

        public long nextValue() {
            long answer = this._current;
            this.advance();
            return answer;
        }

        protected abstract void advance();

        public void printProgression(int val) {
            System.out.print(this.nextValue());
            for (int j = 1; j < val; j++)
                System.out.print(" " + this.nextValue());
            System.out.println();
        }
    }

    public static class ArithmeticProgression extends AbstractProgression {
        protected long _increment;

        public ArithmeticProgression() {
            this(1, 0);
        }

        public ArithmeticProgression(long stepSize) {
            this(stepSize, 0);
        }

        public ArithmeticProgression(long stepSize, long start) {
            super(start);
            this._increment = stepSize;
        }

        protected void advance() {
            this._current += this._increment;
        }
    }

    public static class GeometricProgression extends AbstractProgression {
        protected long _base;

        public GeometricProgression() {
            this(2, 1);
        }

        public GeometricProgression(long base) {
            this(base, 1);
        }

        public GeometricProgression(long base, long start) {
            super(start);
            this._base = base;
        }

        protected void advance() {
            this._current *= this._base;
        }
    }

    public static class FibonacciProgression extends AbstractProgression {
        protected long _prev;

        public FibonacciProgression() {
            this(0, 1);
        }

        public FibonacciProgression(long first, long second) {
            super(first);
            this._prev = second - first;
        }

        protected void advance() {
            long temp = this._prev;
            this._prev = this._current;
            this._current += temp;
        }
    }

    public static class PredatoryCreditCard extends CreditCard {
        private double _apr;

        public PredatoryCreditCard(String customer, String bank, String account,
                                   int limit, double initialBalance, double rate) {
            super(customer, bank, account, limit, initialBalance);
            this._apr = rate;
        }

        public void processMonth() {
            if (this.getBalance() > 0) {
                double monthlyFactor = Math.pow(1 + this._apr, 1.0/12);
                this.setBalance(this.getBalance() * monthlyFactor);
            }
        }

        public boolean charge(double price) {
            boolean isSuccess = super.charge(price);
            if (!isSuccess)
                this.setBalance(this.getBalance() + 5);
            return isSuccess;
        }
    }

    public interface Sellable {
        public String description();
        public int listPrice();
        public int lowestPrice();
    }

    public class Photograph implements Sellable {
        private String _description;
        private int _price;
        private boolean _color;

        public Photograph(String description, int price, boolean color) {
            this._description = description;
            this._price = price;
            this._color = color;
        }

        public String description() {
            return this._description;
        }

        public int listPrice() {
            return this._price;
        }

        public int lowestPrice() {
            return this._price / 2;
        }

        public boolean isColor() {
            return this._color;
        }
    }

    public interface Transportable {
        public int weight();
        public boolean isHazardous();
    }

    public class BoxedItem implements Sellable, Transportable {
        private String description;
        private int price;
        private int weight;
        private boolean haz;
        private int height = 0;
        private int width = 0;
        private int depth = 0;

        public BoxedItem(String description, int price, int weight, boolean hazardous) {
            this.description = description;
            this.price = price;
            this.weight = weight;
            this.haz = hazardous;
        }
        public String description() {
            return this.description;
        }

        public int listPrice() {
            return this.price;
        }

        public int lowestPrice() {
            return this.price / 2;
        }

        public int weight() {
            return this.weight;
        }

        public boolean isHazardous() {
            return this.haz;
        }

        public int insuredValue() {
            return this.price  * 2;
        }

        public void setBox(int height, int weight, int depth) {
            this.height = height;
            this.width  = width;
            this.depth  = depth;
        }
    }

    public interface Person {
        public boolean equals(Person other);
        public String getName();
        public int getAge();
    }

    public class Student implements Person {
        String _id;
        String _name;
        int _age;
        public Student(String id, String name, int age) {
            this._id = id;
            this._age = age;
            this._name = name;
        }

        protected int studyHours() {
            return this._age / 2;
        }

        public String getID() {
            return this._id;
        }

        public String getName() {
            return this._name;
        }

        public int getAge() {
            return this._age;
        }

        public boolean equals(Person other) {
            if (!(other instanceof Student)) return false;
            Student stud = (Student) other;
            return this._id.equals(stud._id);
        }

        public String toString() {
            return String.format("Student [ID: %s, Name: %s, Age: %d]",
                    this._id, this._name, this._age);
        }
    }

    public class Portfolio<T> {
        private T[] _data;

        public Portfolio(int capacity) {
            this._data = (T[]) new Object[capacity];
        }
        public T get(int index) {
            return this._data[index];
        }
        public void set(int index, T element) {
            this._data[index] = element;
        }
    }

    public static class GenericDemo {
        public static <T> void reverse(T[] data) {
            int low = 0, high = data.length-1;
            while (low < high) {
                T temp = data[low];
                data[low++] = data[high];
                data[high--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        AbstractProgression prog;
        // test ArithmeticProgression
        System.out.print("Arithmetic progression with default increment: ");
        prog = new ArithmeticProgression( );
        prog.printProgression(10);
        System.out.print("Arithmetic progression with increment 5: ");
        prog = new ArithmeticProgression(5);
        prog.printProgression(10);
        System.out.print("Arithmetic progression with start 2: ");
        prog = new ArithmeticProgression(5, 2);
        prog.printProgression(10);
        // test GeometricProgression
        System.out.print("Geometric progression with default base: ");
        prog = new GeometricProgression( );
        prog.printProgression(10);
        System.out.print("Geometric progression with base 3: ");
        prog = new GeometricProgression(3);
        prog.printProgression(10);
        // test FibonacciProgression
        System.out.print("Fibonacci progression with default start values: ");
        prog = new FibonacciProgression( );
        prog.printProgression(10);
        System.out.print("Fibonacci progression with start values 4 and 6: ");
        prog = new FibonacciProgression(4, 6);
        prog.printProgression(8);

    }
}
