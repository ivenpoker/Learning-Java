package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_23;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise_14_23 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] keyMetrics =
            {"inches", "meters", "liters", "feet", "quarts", "kilograms"};
    private static final String HOW_MANY_STR =  "how many ";
    private static final String ARE_IN_STR  = "are in ";
    private static final int EXIT_FAILURE = 1;

    private enum MetricType {INCHES, METERS, LITERS, FEET, QUARTS, KILOGRAMS, UNKNOWN_METRIC};

    private static String readUserInputStr(String inputMess) {
        boolean valid = false;
        String userStr = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userStr = scanner.nextLine().trim();

                if (userStr.isEmpty()) {
                    throw new IllegalArgumentException("please enter some text");
                }
                valid = true;
            } catch (IllegalArgumentException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userStr;
    }

    private static String[] keyQuestionSegments(String question) {
        if (question.isEmpty()) {
            return null;
        }
        question = question.toLowerCase();
        int howManyIdx = question.indexOf(HOW_MANY_STR);
        int areInIdx = question.indexOf(ARE_IN_STR);

        if (howManyIdx < 0 || areInIdx < 0) {
            return null;
        }
        String[] keySegs = new String[3];
        keySegs[0] = question.substring(howManyIdx + HOW_MANY_STR.length(),
                question.indexOf(' ', howManyIdx + HOW_MANY_STR.length()));

        String twoSegStr = question.substring(areInIdx + ARE_IN_STR.length(), question.length()).trim();
        String[] twoSegVals = twoSegStr.split(" ");

        if (twoSegVals.length != 2) {
            return null;
        }

        keySegs[1] = twoSegVals[0];
        keySegs[2] = twoSegVals[1];

        return keySegs;
    }

    private static MetricType convertStrToMetricTypes(String metricStr) {
        switch (metricStr.toLowerCase()) {
            case "inches":     return MetricType.INCHES;
            case "meters":     return MetricType.METERS;
            case "kilograms":  return MetricType.KILOGRAMS;
            case "quarts":     return MetricType.QUARTS;
            case "liters":     return MetricType.LITERS;
            case "feet":       return MetricType.FEET;
            default:
                return MetricType.UNKNOWN_METRIC;
        }
    }

    private static boolean validQuestionSegments(String[] segments) {

        boolean firstSegValid = false;
        boolean sndSegValid   = false;
        boolean thirdSegValid = false;

        // making sure the first segment value is in the possible list of segment metrics
        for (String keyMetric : keyMetrics) {
            if (keyMetric.equals(segments[0])) {
                firstSegValid = true;
                break;
            }
        }
        if (!firstSegValid) {
            System.out.printf("Invalid metric '%s'%n", segments[0]);
            return false;
        }

        // making sure there is a number attached to the second metric
        try {
            double tmpHold = Double.parseDouble(segments[1]);
            sndSegValid = true;

        } catch (NumberFormatException nFe) {
            System.err.printf("Invalid number for conversion '%s'%n", segments[1]);
        }

        if (!sndSegValid) {
            return false;
        }

        // Making sure the last segment value is a valid metric
        for (String keyMetric : keyMetrics) {
            if (keyMetric.equals(segments[2])) {
                thirdSegValid = true;
                break;
            }
        }

        if (!thirdSegValid) {
            return false;
        }

        return true;
    }

    private static double performConversion(String from, double dblVal, String to) {
        MetricType fromType = convertStrToMetricTypes(from);

        // if the 'from' type was and invalid type. We alert user and
        // terminate application.

        if (fromType == MetricType.UNKNOWN_METRIC) {
            System.err.printf("\n\t[SYSTEM__FAILURE]%n");
            System.exit(EXIT_FAILURE);                      // TERMINATE APPLICATION
        }

        MetricType toType = convertStrToMetricTypes(to);

        // if the 'to' type was an invalid type. We alert user and
        // terminate application

        if (toType == MetricType.UNKNOWN_METRIC) {
            System.err.printf("\n\t[SYSTEM_FAILURE]%n");
            System.exit(EXIT_FAILURE);                      // TERMINATE APPLICATION
        }

        // At this point the 'from' and the 'to' type are valid
        // metrics, so we convert the double values

        switch (fromType) {
            case FEET: {
                switch (toType) {
                    case FEET: return dblVal;
                    case INCHES: return ConversionUtils.convertFeetToInches(dblVal);
                    case KILOGRAMS: {
                        System.out.println("Cannot convert from feet to kilograms");
                        return -1;
                    }
                    case LITERS: return ConversionUtils.convertFeetToLitres(dblVal);
                    case METERS: return ConversionUtils.convertFeetToMetre(dblVal);
                    case QUARTS: return ConversionUtils.convertFeetToQuart(dblVal);
                }
            }

            case KILOGRAMS: {
                switch (toType) {
                    case KILOGRAMS: {
                        return dblVal;
                    }
                    case FEET: {
                        System.out.println("Cannot convert from kilograms to feet");
                        return -1;
                    }
                    case INCHES: {
                        System.out.println("Cannot convert from kilograms to inches");
                        return -1;
                    }
                    case LITERS: {
                        System.out.println("Cannot convert from kilograms to liters");
                        return -1;
                    }
                    case METERS: {
                        System.out.println("Cannot convert from kilograms to metres");
                        return -1;
                    }
                    case QUARTS: return ConversionUtils.convertKilogramToQuart(dblVal);
                }
            }

            case LITERS: {
                switch (toType) {
                    case LITERS: return dblVal;
                    case FEET:   return ConversionUtils.convertLitresToFeet(dblVal);
                    case QUARTS: return ConversionUtils.convertLitreToQuarts(dblVal);
                    case INCHES: return ConversionUtils.convertLitresToInch(dblVal);
                    case KILOGRAMS: {
                        System.out.println("Cannot convert litres to kilograms");
                        return -1;
                    }
                    case METERS: return ConversionUtils.convertLitresToMetre(dblVal);
                }
            }

            case METERS: {
                switch (toType) {
                    case METERS: return dblVal;
                    case FEET:   return ConversionUtils.convertMetreToFeet(dblVal);
                    case INCHES: return ConversionUtils.convertMetreToInch(dblVal);
                    case QUARTS: return ConversionUtils.convertMetreToQuart(dblVal);
                    case KILOGRAMS: {
                        System.out.println("Cannot convert meters to kilograms");
                        return -1;
                    }
                    case LITERS: return ConversionUtils.convertMetreToLitre(dblVal);
                }
            }

            case INCHES: {
                switch (toType) {
                    case INCHES: return dblVal;
                    case FEET:   return ConversionUtils.convertInchesToFeet(dblVal);
                    case METERS: return ConversionUtils.convertInchesToMetre(dblVal);
                    case QUARTS: return ConversionUtils.convertInchesToQuart(dblVal);
                    case KILOGRAMS: {
                        System.out.println("Cannot convert inches to kilograms");
                        return -1;
                    }
                    case LITERS: return  ConversionUtils.convertInchesToLitre(dblVal);
                }
            }

            case QUARTS: {
                switch (toType) {
                    case QUARTS: return dblVal;
                    case INCHES: return ConversionUtils.convertQuartsToInches(dblVal);
                    case LITERS: return ConversionUtils.convertQuartsToLitres(dblVal);
                    case FEET:   return ConversionUtils.convertQuartsToFoot(dblVal);
                    case METERS: return ConversionUtils.convertQuartsToMetres(dblVal);
                    case KILOGRAMS: return ConversionUtils.convertQuartsToKilogram(dblVal);
                }
            }
        }

        // The application shouldn't reach this point.
        throw new IllegalStateException("[SYSTEM_ERROR]: Application shouldn't reach this point");
    }

    public static void main(String[] args) {
        boolean userValidData = true;
        do {
            String userQuestion = readUserInputStr("Enter your question: ");
            String[] keySegments = keyQuestionSegments(userQuestion);

            // asserting need fields where obtained
            if (keySegments == null || keySegments.length != 3) {
                System.out.println("[Invalid question] must be in format -> 'How many x are in y k'");
                userValidData = false;
            } else {
                System.out.printf("Received data: %s%n", Arrays.toString(keySegments));
                if (validQuestionSegments(keySegments)) {

                    // Data here is valid, we can now start processing the data and
                    // do the necessary conversions

                    double results = performConversion(keySegments[0], Double.parseDouble(keySegments[1]), keySegments[2]);

                    System.out.printf("Results from conversion: %.4f%n", results);

                }

            }
        } while (userValidData);
    }
}

class ConversionUtils {
    public static double convertInchToMeter(double inchValue) {
        return inchValue * 0.0254;
    }

    public static double convertMeterToInch(double metreValue) {
        return metreValue * 39.3701;
    }

    public static double convertLitreToQuarts(double litre) {
        return litre * 1.05669;
    }

    public static double convertQuartsToLitres(double quart) {
        return quart * 0.946353;
    }

    public static double convertFeetToInches(double feet) {
        return feet * 12.0;
    }

    public static double convertFeetToLitres(double feet) {
        return feet * 28.3168;
    }

    public static double convertFeetToMetre(double feet) {
        return feet * 0.3048;
    }

    public static double convertFeetToQuart(double feet) {
        return feet * 29.9221;
    }

    public static double convertKilogramToQuart(double kilogram) {
        return kilogram * 1.05668821;
    }

    public static double convertLitresToFeet(double litres) {
        return litres * 0.0353147;
    }

    public static double convertLitresToInch(double litres) {
        return litres * 61.0237;
    }

    public static double convertLitresToMetre(double litres) {
        return litres * 0.001;
    }

    public static double convertMetreToFeet(double metre) {
        return metre * 3.28084;
    }

    public static double convertMetreToInch(double metre) {
        return metre * 39.3701;
    }

    public static double convertMetreToQuart(double metre) {
        return metre * 1056.69;
    }

    public static double convertMetreToLitre(double metre) {
        return metre * 1000;
    }

    public static double convertInchesToFeet(double inches) {
        return inches * 0.0833333;
    }

    public static double convertInchesToMetre(double inches) {
        return inches * 0.0254;
    }

    public static double convertInchesToQuart(double inches) {
        return inches * 0.017316;
    }

    public static double convertInchesToLitre(double inches) {
        return inches * 0.0163871;
    }

    public static double convertQuartsToInches(double quarts) {
        return quarts * 57.75;
    }

    public static double convertQuartsToFoot(double quarts) {
        return quarts * 0.0334201;
    }

    public static double convertQuartsToMetres(double quarts) {
        return quarts * 0.000946353;
    }

    public static double convertQuartsToKilogram(double quarts) {
        return quarts * 0.946352946;
    }
}
