import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int SET_STEP_GOAL = 1;
    private static final int ENTER_STEP_PER_DAY = 2;
    private static final int PRINT_MONTH_STATS = 3;
    private static final int EXIT = 0;

    public static void main(String[] args) {
        boolean isRunning = true;
        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        setRandomValues(tracker);

        while (isRunning) {
            printMainMenu();

            int command = -1;
            String userInput = scanner.nextLine();
            if (isNumeric(userInput)) {
                command = Integer.parseInt(userInput);
            }

            switch (command) {
                case SET_STEP_GOAL:
                    setStepDailyGoal(scanner, tracker);
                    break;
                case ENTER_STEP_PER_DAY:
                    enterStepsTakenPerDay(scanner, tracker);
                    break;
                case PRINT_MONTH_STATS:
                    printStatisticsForMonth(scanner, tracker);
                    break;
                case EXIT:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неопознанная команда");
                    break;
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("Счётчик калорий:");
        System.out.println("1. Ввод цели по количеству шагов в день");
        System.out.println("2. Ввод пройденного количества шагов за день");
        System.out.println("3. Вывод статистики за определённый месяц");
        System.out.println("0. Выход");
        System.out.print("> ");
    }

    private static void setStepDailyGoal(Scanner scanner, StepTracker tracker) {
        System.out.print("Введите цель по количеству шагов в день (0 <): ");
        String userInput = scanner.nextLine();
        int userStepGoal = 0;
        if (isNumeric(userInput)) {
            userStepGoal = Integer.parseInt(userInput);
        }
        if (userStepGoal <= 0) {
            System.out.println("Недопустимое введенное значение. Текущее значение: " + tracker.getStepDailyRate());
            return;
        }
        tracker.setStepDailyRate(userStepGoal);
    }

    private static int enterMonth(Scanner scanner) {
        System.out.print("Введите номер месяца (от 1 до 12): ");
        String userInput = scanner.nextLine();
        int userMonth = 0;
        if (isNumeric(userInput)) {
            userMonth = Integer.parseInt(userInput);
        }
        if (userMonth < 1 || userMonth > 12) {
            System.out.println("Недопустимое введенное значение месяца.");
        }
        return userMonth;
    }

    private static int enterDayOfMonth(Scanner scanner, StepTracker tracker, int month) {
        int numberOfDays = tracker.getNumberOfDaysInMonth(month - 1);
        System.out.printf("Введите номер дня (от 1 до %d): ", numberOfDays);
        String userInput = scanner.nextLine();
        int userDay = 0;
        if (isNumeric(userInput)) {
            userDay = Integer.parseInt(userInput);
        }
        if (userDay < 1 || userDay > numberOfDays) {
            System.out.println("Недопустимое введенное значение дня.");
        }
        return userDay;
    }

    private static int enterStepsOfDay(Scanner scanner) {
        System.out.print("Введите количество пройденных шагов (0 <=): ");
        String userInput = scanner.nextLine();
        int userSteps = -1;
        if (isNumeric(userInput)) {
            userSteps = Integer.parseInt(userInput);
        }
        if (userSteps < 0) {
            System.out.println("Недопустимое введенное значение шагов.");
        }
        return userSteps;
    }

    private static void enterStepsTakenPerDay(Scanner scanner, StepTracker tracker) {
        int userMonth = enterMonth(scanner);
        if (userMonth == 0) {
            return;
        }
        int userDay = enterDayOfMonth(scanner, tracker, userMonth);
        if (userDay == 0) {
            return;
        }
        int userSteps = enterStepsOfDay(scanner);
        if (userSteps == -1) {
            return;
        }
        tracker.setStepsTakenPerDay(userMonth - 1, userDay - 1, userSteps);
    }

    private static void printStatisticsForMonth(Scanner scanner, StepTracker tracker) {
        int userMonth = enterMonth(scanner);
        if (userMonth == 0) {
            return;
        }
        tracker.printStatisticsForMonth(userMonth - 1);
    }

    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static void setRandomValues(StepTracker tracker) {
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < tracker.getNumberOfDaysInMonth(i); j++) {
                tracker.setStepsTakenPerDay(i, j, random.nextInt(10000));
            }
        }
    }
}
