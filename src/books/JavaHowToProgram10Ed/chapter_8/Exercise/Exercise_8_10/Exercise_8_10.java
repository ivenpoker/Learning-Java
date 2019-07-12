// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.10 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_10;

public class Exercise_8_10 {

    public static void main(String[] args) {
        System.out.printf("Traffic lights:%n%n");
        System.out.printf("%10s%10s\n", "Light", "Duration");

        for (TrafficLight light : TrafficLight.values())
            System.out.printf("%10s%10d\n", light, light.getDuration());
    }
}
