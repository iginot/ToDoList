import java.time.LocalDate;

/**
 * List all available user commands in application and call the respective methods for them.
 */
public class Command
{
    Database appDatabase;
    IOoperations ioOperator;
    Keyboard commandKeyboard;

    public Command()
    {
        appDatabase = new Database();
        ioOperator = new IOoperations();
        commandKeyboard = new Keyboard();

        appDatabase = ioOperator.databaseReadFromFile();
        showWelcomeText();
    }

    public boolean processCommand(String inputFromUser)
    {
        switch (inputFromUser) {
            case "1":
                System.out.println(appDatabase.showTasks());
                return true;
            case "2":
                System.out.println("What is the name of the task?");
                String taskName = commandKeyboard.getString();

                System.out.println("What is the name of the project?");
                String taskProject = commandKeyboard.getString();

                System.out.println("When is the deadline? Date has format 2020-02-29");
                LocalDate taskDeadline = commandKeyboard.getLocalDate();

                appDatabase.addTask(taskName, taskProject, taskDeadline);
                System.out.println("Task successfully added.");
                return true;
            case "3":
                if (appDatabase.isDatabaseEmpty()){
                    System.out.println("Database is empty");
                } else {
                    System.out.println(appDatabase.showTasks() +
                                       "\nWhich task do you want to edit?");
                    int taskNumber = commandKeyboard.getInt();
                    if (appDatabase.existsSuchTask(taskNumber)) {

                        System.out.println("What to you want to do?\n" +
                                "1) mark as done\n" +
                                "2) change title\n" +
                                "3) change project\n" +
                                "4) change deadline\n" +
                                "5) delete\n" +
                                "0) return to previous menu");

                        processEditCommand(commandKeyboard.getString(), taskNumber);
                    }
                }
                return true;
            case "4":
                ioOperator.databaseSaveToFile(appDatabase);
                System.out.println("You have chosen to quit. Have a nice day.");
                return false;
            default:
                System.out.println("I don't understand. You can choose between options 1, 2, 3 and 4.");
                return true;
        }
    }

    public void processEditCommand(String inputFromUser, int taskNumber) {
        switch (inputFromUser) {
            case "1":
                appDatabase.markTaskAsDone(taskNumber);
                break;
            case "2":
                System.out.println("Enter new task title:");
                appDatabase.changeTaskTitle(taskNumber, commandKeyboard.getString());
                break;
            case "3":
                System.out.println("Enter new task project:");
                appDatabase.changeTaskProject(taskNumber, commandKeyboard.getString());
                break;
            case "4":
                System.out.println("Enter new task deadline:");
                appDatabase.changeTaskDeadline(taskNumber, commandKeyboard.getLocalDate());
                break;
            case "5":
                appDatabase.removeTask(taskNumber);
                break;
            case "0":
                break;
            default:
                System.out.println("I don't understand. You can choose between options 1, 2, 3, 4, 5 and 0.");
                processEditCommand(commandKeyboard.getString(), taskNumber);
        }
    }

    private void showWelcomeText()
    {
        int countOfOpenedTasks = appDatabase.getTasksCount(false);
        int countOfClosedTasks = appDatabase.getTasksCount(true);

        System.out.println("*****************");
        System.out.println("Welcome to IGIapp");
        System.out.println("You have " + countOfOpenedTasks + " tasks to do and " + countOfClosedTasks + " tasks are done!");
        System.out.println("*****************");
    }
}