package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_14;

public abstract class Employee implements Payable {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private final Date birthDate;

    public Employee(String firstName, String lastName,
                    String socialSecurityNumber, Date birthDate) {
        this.firstName = firstName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getDate() {
        return this.birthDate;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    public String toString() {
        return String.format("%s %s%nsocial security number: %s%nBirth date: %s%n",
                this.getFirstName(), this.getLastName(), this.getSocialSecurityNumber(),
                this.birthDate.toString());
    }
}
