package books.JavaHowToProgram10Ed.chapter_7;

import java.security.SecureRandom;

public class App {

    public static class Card {

        private final String _face;
        private final String _suit;

        public Card(String cardFace, String cardSuit) {
            this._face = cardFace;
            this._suit = cardSuit;
        }

        public String toString() {
            return this._face + " of " + this._suit;
        }
    }

    public static class GradeBook {
        private String _courseName;
        private int[]  _grades;

        public GradeBook(String _courseName, int[] _grades) {
            this._courseName = _courseName;
            this._grades = _grades;
        }

        public void setCourseName(String courseName) {
            this._courseName = courseName;
        }

        public String getCourseName() {
            return this._courseName;
        }

        public void processGrades() {
            outputGrades();
            System.out.printf("%nClasses average is: %.2f%n", getAverage());
            System.out.printf("Lowest grade is %d%nHighest grade id: %n%n",
                    getMinimum(), getMaximum());
            outputBarChart();
        }

        public int getMinimum() {
            int lowGrade = this._grades[0];
            for (int grade : this._grades)
                if (grade < lowGrade)
                    lowGrade = grade;
            return lowGrade;
        }

        public int getMaximum() {
            int highGrade = this._grades[0];
            for (int grade : this._grades)
                if (grade > highGrade)
                    highGrade = grade;
            return highGrade;
        }

        public double getAverage() {
            int total = 0;

            for (int grade : this._grades)
                total += grade;
            return (double) total / this._grades.length;
        }

        public void outputBarChart() {
            System.out.printf("Grade distribution: ");
            int[] frequency = new int[11];

            for (int grade : this._grades)
                ++frequency[grade / 10];

            for (int count = 0; count < frequency.length; count++) {
                if (count == 10)
                    System.out.printf("%5d: ", 100);
                else
                    System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);

                for (int stars = 0; stars < frequency[count]; stars++)
                    System.out.print("*");
                System.out.println();
            }
        }

        public void outputGrades() {
            System.out.printf("The grades are: %n%n");
            for (int stud = 0; stud < this._grades.length; stud++)
                System.out.printf("Student %2d: %3d%n",
                        stud + 1, this._grades[stud]);
        }
    }

    public static class DeckOfCards {
        private Card[] _deck;
        private int _currentCard;
        private static final int NUMBER_OF_CARDS = 52;
        public static final SecureRandom random = new SecureRandom();

        public DeckOfCards() {
            String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
                    "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
            String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

            this._deck = new Card[DeckOfCards.NUMBER_OF_CARDS];
            this._currentCard = 0;

            for (int count = 0; count < this._deck.length; count++)
                this._deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }

        public void shuffle() {
            this._currentCard = 0;
            for (int first = 0; first < this._deck.length; first++) {
                int second = random.nextInt(DeckOfCards.NUMBER_OF_CARDS);
                Card temp = this._deck[first];
                this._deck[first] = this._deck[second];
                this._deck[second] = temp;
            }
        }

        public Card dealCard() {
            if (this._currentCard < this._deck.length)
                return this._deck[this._currentCard++];
            else
                return null;
        }
    }

    public static void main(String[] args) {
//        DeckOfCards myDeckOfCards = new DeckOfCards();
//        myDeckOfCards.shuffle();
//
//        for (int i = 1; i <= 52; i++) {
//            System.out.printf("%-19s", myDeckOfCards.dealCard());
//            if (i % 4 == 0)
//                System.out.println();
//        }

//        int[] array = {1, 2, 3, 4, 5};
//
//        System.out.printf("Effects of passing reference to entire array:%n" +
//                "The values of the original array are:%n");
//        for (int value : array)
//            System.out.printf("   %d", value);
//
//        modifyArray(array);
//        System.out.printf("%n%nThe values of the method array are:%n");
//
//        for (int value : array)
//            System.out.printf("     %d", value);
//
//        System.out.printf(
//                "%n%nEffects of passing array element value:%n" +
//                        "array[3] before modifyElement: %d%n", array[3]);
//
//        modifyElement(array[3]);
//        System.out.printf("array[3] after modifyElement: %d%n", array[3]);

        int[] gradesArray = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
        GradeBook myGradeBook = new GradeBook("CS101 Introduction to Java Programming", gradesArray);
        System.out.printf("Welcome to the grade book for:%n%s%n", myGradeBook.getCourseName());
        myGradeBook.processGrades();

    }

    public static void modifyArray(int[] array2) {
        for (int counter = 0; counter < array2.length; counter++)
            array2[counter] *=  2;
    }

    public static void modifyElement(int element) {
        element *= 2;
        System.out.printf("Value of element in 'modifyElement': %d%n", element);
    }

}
