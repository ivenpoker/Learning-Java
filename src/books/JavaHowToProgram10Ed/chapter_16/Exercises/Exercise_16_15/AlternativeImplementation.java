package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_15;

import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final String TERMINATE_STR = ".";
    private static final Scanner input = new Scanner(System.in);

    private static void testColorChooser() {
        String colorName = "";
        do {
            try {
                System.out.print("Enter color name to 'choose': ");
                colorName = input.next();

                if (colorName.isEmpty()) {
                    throw new InputMismatchException("please enter color name");
                }
                Color equivColor = (new ColorChooser()).getColor(colorName);
                System.out.printf("Equivalent color: %s%n", equivColor);

            } catch (InputMismatchException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());

            } catch (IllegalArgumentException iAe) {
                System.err.printf("[COLOR_NOT_FOUND]: Color '%s' not found", colorName);

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        } while (!colorName.equals(TERMINATE_STR));
    }

    public static void main(String[] args) {
        testColorChooser();
    }
}

class ColorChooser {
    private final Map<String, Color> colorMap;
    private final String[] mainColors = {"black", "white", "orange", "pink", "yellow",
                                         "darkgray", "red", "lightgray", "BLACK", "green", "gray",
                                         "blue", "magenta", "cyan"};
    public ColorChooser() {
        this.colorMap = new HashMap<>();
        this.fillColorsInMap();
    }

    private void fillColorsInMap() {
        this.colorMap.put(this.mainColors[0], Color.BLACK);
        this.colorMap.put(this.mainColors[1], Color.WHITE);
        this.colorMap.put(this.mainColors[2], Color.ORANGE);
        this.colorMap.put(this.mainColors[3], Color.PINK);
        this.colorMap.put(this.mainColors[4], Color.YELLOW);
        this.colorMap.put(this.mainColors[5], Color.DARK_GRAY);
        this.colorMap.put(this.mainColors[6], Color.RED);
        this.colorMap.put(this.mainColors[7], Color.LIGHT_GRAY);
        this.colorMap.put(this.mainColors[8], Color.BLACK);
        this.colorMap.put(this.mainColors[9], Color.green);
        this.colorMap.put(this.mainColors[10], Color.gray);
        this.colorMap.put(this.mainColors[11], Color.blue);
        this.colorMap.put(this.mainColors[12], Color.magenta);
        this.colorMap.put(this.mainColors[13], Color.cyan);
    }

    public Color getColor(String colorName) {
        if (!Objects.isNull(colorName) && !this.colorMap.containsKey(colorName)) {
            throw new IllegalArgumentException(String.format("Invalid color name '%s'.", colorName));
        }
        return this.colorMap.get(colorName);
    }
}
