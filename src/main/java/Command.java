/**
 * List all available user commands in application.
 */
public class Command {

    Database appDatabase;
    IOoperations ioOperator;
    String testRead;
    Keyboard commandKeyboard;

    public Command(){
        appDatabase = new Database();
        ioOperator = new IOoperations();
        commandKeyboard = new Keyboard();
        //new code
        appDatabase = ioOperator.databaseRead();
/*        String[] fieldsFromDatabase = ioOperator.databaseRead().split(";");
            for (int i = 0; i < (fieldsFromDatabase.length - 1); i = i + 2) {
                appDatabase.addTask(fieldsFromDatabase[i], fieldsFromDatabase[i + 1]);
            }*/
    }

    public boolean processCommand(String inputFromUser) {
        switch (inputFromUser) {
            case "1":
                System.out.println(appDatabase.showTasks());
                return true;
            case "2":
                String name = "";
                String project = "";
                System.out.println("What is the name of the task?");
                name = commandKeyboard.getInput();
                System.out.println("What is the name of the project?");
                project = commandKeyboard.getInput();
                appDatabase.addTask(name, project);
                System.out.println("Task successfully added.");
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
}