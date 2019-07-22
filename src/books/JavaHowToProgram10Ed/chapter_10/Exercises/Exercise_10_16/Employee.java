package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_16;

public abstract class Employee implements Payable {

    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee(String firstName, String lastName,
                    String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s%nsocial security number: %s",
                this.getFirstName(), this.getLastName(), this.getSocialSecurityNumber());
    }

    @Override
    public double getPaymentAmount() {
        return this.earnings();
    }

    public abstract double earnings();
}
