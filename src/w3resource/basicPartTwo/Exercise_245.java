package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Obtains student information (name, ID and mark) and display students  #
// #                     sorted in descending order from highest mark to lowest mark.          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : August 07, 2020                                                       #
// #                                                                                           #
// #############################################################################################

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Exercise_245 {

    private static final Scanner input = new Scanner(System.in);
    private static final String END_STR = ".";

    private static class Student implements Comparable<Student> {
        private String name;
        private int id;
        private int marks;

        public Student(String name, int id, int mark) {
            this.setName(name);
            this.setID(id);
            this.setMark(mark);
        }

        public void setName(String newName) {
            if (Objects.isNull(newName) || newName.isEmpty()) {
                throw new IllegalArgumentException("student name cannot be empty or null");
            }
            this.name = newName;
        }

        public void setID(int newId) {
            if (newId < 0) {
                throw new IllegalArgumentException("student ID cannot be negative");
            }
            this.id = newId;
        }

        public void setMark(int newMark) {
            if (newMark < 0) {
                throw new IllegalArgumentException("student mark cannot be negative");
            }
            this.marks = newMark;
        }

        public String getName() {
            return this.name;
        }

        public int getID() {
            return this.id;
        }

        public int getMark() {
            return this.marks;
        }

        @Override
        public String toString() {
            return String.format("[Name: %s, ID: %d, Mark: %d]",
                    this.getName(), this.getID(), this.getMark());
        }

        @Override
        public int compareTo(Student other) {
            if (Objects.isNull(other)) {
                throw new IllegalArgumentException("Can't compare student to null");
            }
            return this.marks - other.marks;
        }
    }

    // Read student data from user via console (as: name id mark)
    private static ArrayList<Student> obtainStudentsDataFromUser(String inputMess, String endSig) {
        ArrayList<Student> studentList = new ArrayList<>();
        do {
            try {
                System.out.print(inputMess);
                String line = input.nextLine().trim();

                if (line.isEmpty()) {
                    throw new InputMismatchException("please enter text");
                } else if (line.equals(endSig)) {
                    break;
                }

                String[] tokens = line.split("\\s+");

                if (tokens.length != 3) {
                    throw new InputMismatchException(
                            String.format("Expected %d arguments, got %d.", 3, tokens.length));
                }

                // both second and third tokens must be numbers (integers)
                studentList.add(new Student(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));


            } catch (InputMismatchException | NumberFormatException iMNe) {
                System.err.printf("[invalid_input]: %s%n", iMNe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: Something 'bad' occurred: %s%n", exc.getMessage());
            }
        } while (true);

        return studentList;
    }

    // Display students data to console.
    private static void displayStudents(String mess, ArrayList<Student> studentsList) {
        System.out.print(mess);
        for (int i = 0, size = studentsList.size(); i < size; i++) {
            System.out.printf("Student #%d: %s%n", (i+1), studentsList.get(i));
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> studentsList = obtainStudentsDataFromUser("Enter student [as: name id mark]: ", END_STR);

        // Display students
        displayStudents("\nObtained students:\n", studentsList);

        // Sort the collection of students in reverse order (largest to smallest, based on their marks)
        studentsList.sort(Collections.reverseOrder());

        displayStudents("\nStudents in descending order:\n", studentsList);

    }

}
