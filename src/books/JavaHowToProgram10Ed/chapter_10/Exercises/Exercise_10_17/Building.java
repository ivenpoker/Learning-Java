package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_17;

public abstract class Building implements CarbonFootPrint {

    private int numberOfFloors;
    private String name;
    private int length;
    private int width;



    public Building(String name, int numberOfFloors, int length, int width) {
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.length = length;
        this.width = width;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }
}
