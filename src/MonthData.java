public class MonthData {

    private final String monthName;
    private final int days;
    private final int[] stepsPerDay;
    private final double[] kilometersPerDay;
    private final double[] caloriesPerDay;

    MonthData(String monthName, int days) {
        this.monthName = monthName;
        this.days = days;
        this.stepsPerDay = new int[days];
        this.kilometersPerDay = new double[days];
        this.caloriesPerDay = new double[days];
    }

    public String getMonthName() {
        return monthName;
    }

    public int getDays() {
        return days;
    }

    public int getStepsOfDay(int day) {
        return stepsPerDay[day];
    }

    public double getKilometersOfDay(int day) {
        return kilometersPerDay[day];
    }

    public double getCaloriesOfDay(int day) {
        return caloriesPerDay[day];
    }

    public void setStepsOfDay(int day, int steps) {
        stepsPerDay[day] = steps;
        kilometersPerDay[day] = Converter.convertStepsToKilometers(steps);
        caloriesPerDay[day] = Converter.convertStepsToCalories(steps);
    }
}
