package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_17;

public abstract class Car implements CarbonFootPrint {
    private enum Type {SPORTS, NOT_SPORTS}

    private int numberOfWheels;
    private Type carType;
    private String name;
    private int maxPassenger;

    public Car(Car.Type type, String name, int numberOfWheels,
               int maxPassenger) {

        if (numberOfWheels <= 0)
            throw new IllegalArgumentException("Invalid wheels for car");
        if (maxPassenger <= 0)
            throw new IllegalArgumentException("Invalid number of passengers");
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");

        this.carType = type;
        this.name = name;
        this.numberOfWheels = numberOfWheels;
        this.maxPassenger = maxPassenger;
    }

    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }

    public int getMaxPassenger() {
        return this.maxPassenger;
    }

    public String getName() {
        return this.name;
    }

    public Car.Type getCarType() {
        return this.carType;
    }

    // #################### SETTERS ###########################

    public void setNumberOfWheels(int numberOfWheels) {
        if (numberOfWheels <= 0)
            throw new IllegalArgumentException("Invalid wheels for car");
        this.numberOfWheels = numberOfWheels;
    }

    public void setCarType(Car.Type type) {
        this.carType = type;
    }

    public void setMaxPassenger(int maxPassenger) {
        if (maxPassenger <= 0)
            throw new IllegalArgumentException("Invalid number of passengers");
        this.maxPassenger = maxPassenger;
    }

    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }
}
