public class MonthData {

    private final int days;
    private final String monthName;
    private final int[] stepsPerDay;
    private final double[] caloriesPerDay;
    private final double[] kilometersPerDay;

    MonthData(String monthName, int days) {
        this.days = days;
        this.monthName = monthName;
        this.stepsPerDay = new int[days];
        this.caloriesPerDay = new double[days];
        this.kilometersPerDay = new double[days];
    }

    public int getDays() {
        return days;
    }

    public String getMonthName() {
        return monthName;
    }

    public int getStepsOfDay(int day) {
        return stepsPerDay[day];
    }

    public double getCaloriesOfDay(int day) {
        return caloriesPerDay[day];
    }

    public double getKilometersOfDay(int day) {
        return kilometersPerDay[day];
    }

    public void setStepsOfDay(int day, int steps) {
        stepsPerDay[day] = steps;
        caloriesPerDay[day] = Converter.convertStepsToCalories(steps);
        kilometersPerDay[day] = Converter.convertStepsToKilometers(steps);
    }
}
