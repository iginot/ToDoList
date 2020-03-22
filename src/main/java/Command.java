import java.time.LocalDate;

/**
 * List all available user commands in application.
 */

public class Command {

    Database appDatabase;
    IOoperations ioOperator;
    Keyboard commandKeyboard;

    public Command(){
        appDatabase = new Database();
        ioOperator = new IOoperations();
        commandKeyboard = new Keyboard();

        appDatabase = ioOperator.databaseReadFromFile();
    }

    public boolean processCommand(String inputFromUser) {
        switch (inputFromUser) {
            case "1":
                System.out.println(appDatabase.showTasks());
                return true;
            case "2":
                System.out.println("What is the name of the task?");
                String name = commandKeyboard.getInput();
                System.out.println("What is the name of the project?");
                String project = commandKeyboard.getInput();
                LocalDate deadline = getDeadline();
                appDatabase.addTask(name, project, deadline);
                System.out.println("Task successfully added.");
                return true;
            case "3":
                System.out.println("What to you want to do?\n" +
                        "1) mark as done\n" +
                        "2) delete\n" +
                        "0) return to previous menu");
                processEditCommand(commandKeyboard.getInput());
                return true;
            case "4":
                ioOperator.databaseSaveToFile(appDatabase);
                System.out.println("You have chosen to quit. Have a nice day.");
                return false;
            default:
                System.out.println("I don't understand. You can choose between options 1, 2 and 4.");
                return true;
        }
    }

    public void processEditCommand(String inputFromUser) {
        switch (inputFromUser) {
            case "1":
                System.out.println("Which task do you want to mark as done?");
                String taskNumber = commandKeyboard.getInput();
                appDatabase.markTaskAsDone(taskNumber);
                break;
            case "2":
                System.out.println("Which task do you want to delete?");
                taskNumber = commandKeyboard.getInput();
                appDatabase.removeTask(taskNumber);
                break;
            case "0":
                break;
            default:
                System.out.println("I don't understand. You can choose between options 1, 2 and 4.");
                processEditCommand(commandKeyboard.getInput());
        }
    }

    private LocalDate getDeadline()
    {
        LocalDate processedDate;
        System.out.println("When is the deadline? Date has format 2020-02-29");
        String deadlineFromUser = commandKeyboard.getInput();
        try {
            processedDate = LocalDate.parse(deadlineFromUser);
        } catch (Exception e) {
            processedDate = LocalDate.now();
        }
        return processedDate;
    }

    public void showWelcomeText() {
        int countOfOpenedTasks = appDatabase.getTasksCount(false);
        int countOfClosedTasks = appDatabase.getTasksCount(true);
        System.out.println("*****************");
        System.out.println("Welcome to IGIapp");
        System.out.println("You have " + countOfOpenedTasks + " tasks to do and " + countOfClosedTasks + " tasks are done!");
        System.out.println("*****************");
    }
}