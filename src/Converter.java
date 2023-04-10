public class Converter {

    public static double convertStepsToKilometers(int steps) {
        return steps / 1000.0;
    }

    public static double convertStepsToCalories(int steps) {
        return steps * 0.05;
    }
}
