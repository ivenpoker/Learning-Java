package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_10;

public class AlternativeImplementation {

    public static void main(String[] args) {
        for (AltTrafficLight enumVal : AltTrafficLight.values()) {
            System.out.printf("Enum: %8s | Duration: %d%n", enumVal, enumVal.getDuration());
        }
    }

}

enum AltTrafficLight {
    RED(100),
    GREEN(150),
    YELLOW(230);

    private int duration;

    AltTrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

}
