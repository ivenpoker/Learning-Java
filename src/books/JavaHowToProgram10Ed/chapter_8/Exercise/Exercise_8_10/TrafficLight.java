// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.10 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_10;

public enum TrafficLight {

    RED(5000),
    GREEN(4500),
    ORANGE(3000);

    private int _duration;

    TrafficLight(int duration) {
        if (duration < 0)
            throw new IllegalArgumentException("Invalid duration for traffic light");
        this._duration = duration;
    }

    public int getDuration() {
        return this._duration;
    }

}
