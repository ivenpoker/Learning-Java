package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_19 {

    public static void main(String[] args) {

        int i = 1;
        int j = 2;
        int k = 3;
        int m = 2;

        System.out.println(i == 1);                         // prints 'true'
        System.out.println(j == 3);                         // prints 'false'
        System.out.println((i >= 1) && (j < 4));            // prints 'true'
        System.out.println((k + m < j) | (3 - j >= k));     // prints 'false'
        System.out.println(!(k > m));                       // prints 'false'

    }
}
