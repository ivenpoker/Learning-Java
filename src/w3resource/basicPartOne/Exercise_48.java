package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Display the current date time in a specific format.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 12, 2019                                               #
// #                                                                                      #
// ########################################################################################

import java.util.Calendar;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class Exercise_48 {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        simpleDateFormat.setCalendar(Calendar.getInstance(TimeZone.getTimeZone("GMT")));

        System.out.println("\nNow: " + simpleDateFormat.format(System.currentTimeMillis()));
    }


}
