package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_38;

public class Digits {

    public static boolean isNDigit(int val, int n) {
        int tmp = 0;
        while (val > 0) {
            val /= 10;
            tmp++;
        }
        return tmp == n;
    }
}
