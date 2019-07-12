// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_14;

public class Employee {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
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

    public void setFirstName(String newFirstName) {
        this.firstName = firstName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setSocialSecurityNumber(String newSocialSecurityNumber) {
        this.socialSecurityNumber = newSocialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s %s, SSN: %s",
                this.getFirstName(), this.getLastName(), this.getSocialSecurityNumber());
    }

}
