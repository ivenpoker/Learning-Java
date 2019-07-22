package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_17;

public abstract class Bicycle implements CarbonFootPrint {

    private String name;
    private Type type;
    private static enum Type {SPORTS, NOT_SPORTS}

    public Bicycle(String name, Bicycle.Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Bicycle.Type type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
