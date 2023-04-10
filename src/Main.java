import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        boolean isRunning = true;

        while (isRunning) {
            printMainMenu();
            int userCommand = scanner.nextInt();
            switch (userCommand) {
                case 1:
                    setStepDailyGoal(scanner, tracker);
                    break;
                case 2:
                    enterStepsTakenPerDay(scanner, tracker);
                    break;
                case 3:
                    showStatisticsForMonth(scanner, tracker);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неопознанная команда");
                    break;
            }
        }
    }

    public static void printMainMenu() {
        System.out.println("Счётчик калорий:");
        System.out.println("1. Ввод цели по количеству шагов в день");
        System.out.println("2. Ввод пройденного количества шагов за день");
        System.out.println("3. Вывод статистики за определённый месяц");
        System.out.println("0. Выход");
        System.out.print("> ");
    }

    public static void setStepDailyGoal(Scanner scanner, StepTracker tracker) {
        System.out.print("Введите цель по количеству шагов в день: ");
        int userStepGoal = scanner.nextInt();
        if (userStepGoal <= 0) {
            System.out.println("Недопустимое введенное значение. Текущее значение: " + tracker.getStepDailyRate());
            return;
        }
        tracker.setStepDailyRate(userStepGoal);
    }

    public static void enterStepsTakenPerDay(Scanner scanner, StepTracker tracker) {
        System.out.print("Введите номер месяца (от 1 до 12): ");
        int userMonth = scanner.nextInt();
        if (userMonth < 1 || userMonth > 12) {
            System.out.println("Недопустимое введенное значение месяца.");
            return;
        }

        int numberOfDays = tracker.getNumberOfDaysInMonth(userMonth - 1);
        System.out.printf("Введите номер дня (от 1 до %d): ", numberOfDays);
        int userDay = scanner.nextInt();
        if (userDay < 1 || userDay > numberOfDays) {
            System.out.println("Недопустимое введенное значение дня.");
            return;
        }

        System.out.print("Введите количество пройденных шагов: ");
        int userSteps = scanner.nextInt();
        if (userSteps < 0) {
            System.out.println("Недопустимое введенное значение шагов.");
            return;
        }

        tracker.setStepsTakenPerDay(userMonth - 1, userDay - 1, userSteps);
    }

    public static void showStatisticsForMonth(Scanner scanner, StepTracker tracker) {
        System.out.print("Введите номер месяца (от 1 до 12): ");
        int userMonth = scanner.nextInt();
        if (userMonth < 1 || userMonth > 12) {
            System.out.println("Недопустимое введенное значение месяца.");
            return;
        }
        tracker.showStatisticsForMonth(userMonth - 1);
    }
}
