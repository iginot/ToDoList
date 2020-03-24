package toDoList.util;

import toDoList.data.Database;

import java.time.LocalDate;

/**
 * List all available user commands in application and call the respective methods for them.
 */
public class Command
{
    private toDoList.data.Database appDatabase;
    private IOoperations ioOperator;
    private Keyboard commandKeyboard;

    /**
     * Create a command object.
     */
    public Command()
    {
        appDatabase = new Database();
        ioOperator = new IOoperations();
        commandKeyboard = new Keyboard();

        appDatabase = ioOperator.databaseReadFromFile();
        showWelcomeText();
    }

    /**
     * Process a command from user by calling appropriate method, asking for additional user input or both.
     * @param inputFromUser Command entered by user.
     * @return information, if the application should be kept alive after processing command.
     */
    public boolean processCommand(String inputFromUser)
    {
        switch (inputFromUser) {
            case "1": //show task
                System.out.println("How do you want to sort the list?\n" +
                                   "1) By date\n" +
                                   "2) By project");

                processShowTasksCommand(commandKeyboard.getString());
                System.out.println(appDatabase.showTasks());

                return true;

            case "2": //add task
                System.out.println("What is the name of the task?");
                String taskName = commandKeyboard.getString();

                System.out.println("What is the name of the project?");
                String taskProject = commandKeyboard.getString();

                System.out.println("When is the deadline? Date has format 2020-02-29");
                LocalDate taskDeadline = commandKeyboard.getLocalDate();

                appDatabase.addTask(taskName, taskProject, taskDeadline);
                System.out.println("Task successfully added.");

                return true;

            case "3": //edit task
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

            case "4": //exit application
                ioOperator.databaseSaveToFile(appDatabase);
                System.out.println("You have chosen to quit. Have a nice day.");

                return false;

            default:
                System.out.println("I don't understand. You can choose between options 1, 2, 3 and 4.");
                return true;
        }
    }

    /**
     * Process sub-command in the Edit task menu.
     * @param inputFromUser Command entered by user.
     * @param taskNumber Position of task that will be edited.
     */
    private void processEditCommand(String inputFromUser, int taskNumber) {
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

    /**
     *Process sub-command in the Show task menu.
     * @param inputFromUser Command entered by user.
     */
    private void processShowTasksCommand(String inputFromUser)
    {
        switch (inputFromUser) {
            case "1":
                appDatabase.sortByDeadline();
                break;
            case "2":
                appDatabase.sortByProject();
                break;
            default:
                System.out.println("I don't understand. You can choose between options 1 and 2.");
                processShowTasksCommand(commandKeyboard.getString());
        }
    }

    /**
     * Show specific text that is only used when starting the application.
     */
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