/**
 * List all available user commands in application.
 */
public class Command {

    Database appDatabase;

    public Command(){
        appDatabase = new Database();
    }

    public boolean processCommand(String inputFromUser) {
        switch (inputFromUser) {
            case "1":
                System.out.println(appDatabase.showTasks());
                return true;
            case "2":
                System.out.println(appDatabase.addTask());
                return true;
            case "4":
                System.out.println("You have chosen to quit. Have a nice day.");
                return false;
            default:
                System.out.println("I don't understand. You can choose between options 1, 2 and 4.");
                return true;
        }
    }
}