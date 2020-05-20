package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_18;

public class Exercise_7_18 {

    private static final int MAX_GAME_OF_CRAPS_RUN = 30;

    public static void main(String[] args) {

        Craps craps = new Craps(MAX_GAME_OF_CRAPS_RUN);
        craps.run();

        int[] wins = craps.getWinsTrack();
        int[] loses = craps.getLosesTrack();

        // Below the answers for a) and b) could be found

        System.out.printf("%n%n========== [WINS IN ROLLS] =======%n");
        System.out.printf("%-15s\t%10s%n", "Roll number", "Number of wins");
        for (int i = 0; i < wins.length; i++) {
            // display only those with values > 0
            if (wins[i] > 0) {
                System.out.printf("%-10s\t%10d%n", String.format("Roll #%d", i+1), wins[i]);
            }
        }

        System.out.printf("%n========== [LOSES IN ROLLS] =======%n");
        System.out.printf("%-15s\t%10s%n", "Roll number", "Number of loses");
        for (int i = 0; i < loses.length; i++) {
            // display only those with values > 0
            if (loses[i] > 0) {
                System.out.printf("%-10s\t%10d%n", String.format("Roll #%d", i+1), loses[i]);
            }
        }

        // ANSWER c) Chances for winning crap is the same as the changes for losing, since it's fair.
        // ANSWER d) Average length = (number of rolls per game) / number of games.

        // ANSWER e) NO. Because the games are independent, that is, the outcome of a game doesn't affect
        //           the other.

    }

}
