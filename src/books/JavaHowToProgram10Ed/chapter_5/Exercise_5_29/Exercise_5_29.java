package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_29;

public class Exercise_5_29 {

    public static void main(String[] args) {

        int numberOfVerses = 12;
        for (int day = 1; day <= numberOfVerses; day++) {

            switch (day) {
                case 1:
                    System.out.println("On the first day of christmas ...");
                    break;
                case 2:
                    System.out.println("On the second day of christmas ...");
                    break;
                case 3:
                    System.out.println("On the third day of christmas ...");
                    break;
                case 4:
                    System.out.println("On the fourth day of christmas ...");
                    break;
                case 5:
                    System.out.println("On the fifth day of christmas ...");
                    break;
                case 6:
                    System.out.println("On the sixth day of christmas ...");
                    break;
                case 7:
                    System.out.println("On the seventh day of christmas ...");
                    break;
                case 8:
                    System.out.println("On the eight day of christmas ...");
                    break;
                case 9:
                    System.out.println("On the ninth day of christmas ...");
                    break;
                case 10:
                    System.out.println("On the tenth day of christmas ...");
                    break;
                case 11:
                    System.out.println("On the eleventh day of christmas ...");
                    break;
                case 12:
                    System.out.println("On the twelfth day of christmas ...");
                    break;
                default:
                    System.out.println("[INVALID_DAY]");
                    break;
            }

            switch (day) {
                case 1:
                    System.out.println("\tmy true love sent to me, A partridge in a pear tree.");
                    break;
                case 2:
                    System.out.println("\tmy true love sent to me Two turtle doves, And a partridge in a pear tree.");
                    break;
                case 3:
                    System.out.println("\tmy true love sent to me, Three French hens, Two " +
                            "turtle doves, And a partridge in a pear tree");
                    break;
                case 4:
                    System.out.println("\tmy true love sent to me, four calling birds, three French hens, Two " +
                            "turtle doves, And a partridge in a pear tree");
                    break;
                case 5:
                    System.out.println("\tmy true love sent to me, 5 gold rings, four calling birds," +
                            " three French hens, Two turtle doves, And a partridge in a pear tree");
                    break;
                case 6:
                    System.out.println("\tmy true love sent to me, 6 geese a-laying," +
                            " 5 gold rings, four calling birds, three French hens, Two turtle doves, And a partridge in a pear tree");
                    break;
                case 7:
                    System.out.println("\tmy true love sent to me, 7 swans a-swimming," +
                            " 5 gold rings, four calling birds, three French hens, Two turtle doves, And a partridge in a pear tree");
                    break;
                case 8:
                    System.out.println("\tmy true love sent to me, 8 maids a-milking, 7 swans a-swimming," +
                            " 5 gold rings, four calling birds, three French hens, Two turtle doves, And a partridge in a pear tree");
                    break;
                case 9:
                    System.out.println("\tmy true love sent to me, 9 ladies dancing, 8 maids a-milking, 7 swans a-swimming," +
                            " 5 gold rings, four calling birds, three French hens, Two turtle doves, And a partridge in a pear tree");
                    break;
                case 10:
                    System.out.println("\tmy true love sent to me, 10 lords a-leaping,9 ladies dancing, " +
                            "8 maids a-milking, 7 swans a-swimming, 5 gold rings, four calling birds, three French hens, Two turtle doves, And a partridge in a pear tree");
                    break;
                case 11:
                    System.out.println("\tmy true love sent to me, 11 pipers piping, 10 lords a-leaping,9 ladies dancing, " +
                            "8 maids a-milking, 7 swans a-swimming, 5 gold rings, four calling birds, three French hens, Two turtle doves, And a partridge in a pear tree");
                    break;
                case 12:
                    System.out.println("\tmy true love sent to me, 12 drummers drumming, 11 pipers piping, 10 lords a-leaping,9 ladies dancing, " +
                            "8 maids a-milking, 7 swans a-swimming, 5 gold rings, four calling birds, three French hens, Two turtle doves, And a partridge in a pear tree");
                default:
                    System.out.println("[INVALID_SONG_ENDING]");
                    break;

            }

        }

    }

}
