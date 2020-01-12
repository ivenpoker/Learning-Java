package books.JavaHowToProgram10Ed.chapter_16.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 16.15 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : September 15, 2019                                         #
// #                                                                                  #
// ####################################################################################

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;


public class Exercise_16_15 {

    private static class ChooseDiffColors {

        private String[] colors = {"green", "orange", "violet", "brown", "pink",
                "grey", "black", "white", "yellow", "blue",
                "purple", "silver", "red"};
        private HashMap<String, Color> mainColors;

        public ChooseDiffColors() {
            mainColors = new HashMap<>();
            setupColors();
        }

        private void setupColors() {
            mainColors.put("green", new Color(0, 165, 0));
            mainColors.put("orange", new Color(255, 165, 0));
            mainColors.put("violet", new Color(238, 130, 238));
            mainColors.put("brown", new Color(165, 42, 42));
            mainColors.put("pink", new Color(255, 192, 203));
            mainColors.put("grey", new Color(128, 128, 128));
            mainColors.put("black", new Color(0, 0, 0));
            mainColors.put("white", new Color(255, 255, 255));
            mainColors.put("yellow", new Color(255, 255, 0));
            mainColors.put("blue", new Color(0, 0, 255));
            mainColors.put("purple", new Color(128, 0, 128));
            mainColors.put("silver", new Color(192, 192, 192));
            mainColors.put("red", new Color(255, 0, 0));
        }

        public String[] getColors() {
            return Arrays.copyOf(this.colors, this.colors.length);
        }

        public Color get(String colorName) {
            return mainColors.get(colorName.trim());
        }

        @Override
        public String toString() {
            Set<String> keySet = this.mainColors.keySet();
            StringBuilder builder = new StringBuilder();

            builder.append("Color keys and values:\n\n");
            int i = 1;
            for (String key : keySet) {
                builder.append(String.format("%02d. [key: %s]---[value: %s]\n",
                        i++, key, this.mainColors.get(key)));
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        ChooseDiffColors diffColors = new ChooseDiffColors();
        System.out.println(diffColors);
    }
}
