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
        appDatabase = ioOperator.databaseRead();
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
                System.out.println("What task do you want to remove?");
                String taskNumber = commandKeyboard.getInput();
                appDatabase.removeTask(taskNumber);
                return true;
            case "4":
                ioOperator.databaseSave(appDatabase);
                System.out.println("You have chosen to quit. Have a nice day.");
                return false;
            default:
                System.out.println("I don't understand. You can choose between options 1, 2 and 4.");
                return true;
        }
    }

    private LocalDate getDeadline()
    {
        LocalDate processedDate = null;
        System.out.println("When is the deadline? Date has format 2020-02-29");
        String deadlineFromUser = commandKeyboard.getInput();
        LocalDate convertedDate;
        try {
            processedDate = LocalDate.parse(deadlineFromUser);
        } catch (Exception e) {
            processedDate = LocalDate.now();
        }
        return processedDate;
    }
}