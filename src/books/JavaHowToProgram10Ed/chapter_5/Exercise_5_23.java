package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_23 {

    public static void main(String[] args) {

        // Answers:
        //
        // a) !(x < 5) && !(y >= 7)  <===> !(x < 5 || y >= 7)
        // b) !(a == b) || !(g != 5) <===> !(a == b && g != 5)
        // c) !((x <= 8) && (y > 4)) <===> (!(x <= 8) || !(y > 4))
        // d) !((i > 4) || (j <= 6)) <===> (!(i > 4) && !(j <= 6))

        // Application to test expressions

        int x = 3;
        int y = 10;
        int a = 2;
        int b = 6;
        int i = 8;
        int j = 0;
        int g = 4;

        System.out.printf("!(x < 5) && !(y >= 7) = %b AND !(x < 5 || y >= 7) = %b%n", !(x < 5) && !(y >= 7),!(x < 5 || y >= 7));
        System.out.printf("!(a == b) || !(g != 5) = %b AND !(a == b && g != 5) = %b%n", !(a == b) || !(g != 5), !(a == b && g != 5));
        System.out.printf("!((x <= 8) && (y > 4)) = %b AND (!(x <= 8) || !(y > 4)) = %b%n", !((x <= 8) && (y > 4)), (!(x <= 8) || !(y > 4)));
        System.out.printf("!((i > 4) || (j <= 6)) = %b AND (!(i > 4) && !(j <= 6)) = %b%n", (!(i > 4) && !(j <= 6)), (!(i > 4) && !(j <= 6)));

    }
}
