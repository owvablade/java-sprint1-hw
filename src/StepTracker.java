public class StepTracker {

    private static final int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MONTH_NAMES = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    private int stepDailyRate;
    private final MonthData[] monthsData;

    StepTracker() {
        this.stepDailyRate = 7000;
        this.monthsData = new MonthData[12];
        for (int i = 0; i < monthsData.length; i++) {
            monthsData[i] = new MonthData(MONTH_NAMES[i], MONTH_DAYS[i]);
        }
    }

    public int getStepDailyRate() {
        return stepDailyRate;
    }

    public int getNumberOfDaysInMonth(int month) {
        return monthsData[month].getDays();
    }

    public void setStepDailyRate(int stepDailyRate) {
        this.stepDailyRate = stepDailyRate;
    }

    public void setStepsTakenPerDay(int month, int day, int steps) {
        monthsData[month].setStepsOfDay(day, steps);
    }

    public void printStatisticsForMonth(int month) {
        int daysWithCompletedGoal = 0;
        System.out.printf("Статистика за %s:%n", monthsData[month].getMonthName());
        for (int i = 0; i < monthsData[month].getDays(); i++) {
            System.out.printf("День %d. Пройдено шагов: %d (%.2f км). Сожжено калорий: %.2f%n",
                    i + 1,
                    monthsData[month].getStepsOfDay(i),
                    monthsData[month].getKilometersOfDay(i),
                    monthsData[month].getCaloriesOfDay(i));
            if (stepDailyRate <= monthsData[month].getStepsOfDay(i)) {
                daysWithCompletedGoal++;
            }
        }
        System.out.println("Дней с выполненной целью шагов: " + daysWithCompletedGoal);
    }
}
