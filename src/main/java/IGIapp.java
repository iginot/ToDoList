/**
 * This class is the main class of IGIapp todo list application.
 */
public class IGIapp
{
    /**
     * Run the application. User can type and system will deliver appropriate response.
     */
    private void runtime()
    {
        boolean runtimeActive = true;
        Keyboard scanner = new Keyboard();
        Command commander = new Command();

        while (runtimeActive) {
            showMenuText();
            runtimeActive = commander.processCommand(scanner.getString());
        }
    }

    /**
     * Print application menu, so user can see what options are possible.
     */
    private void showMenuText()
    {
        System.out.println("Pick an option:");
        System.out.println("(1) Show task list");
        System.out.println("(2) Add new task");
        System.out.println("(3) Edit task");
        System.out.println("(4) Quit");
    }

    /**
     * Create and run loop of the application.
     */
    public static void main(String[] args)
    {
        IGIapp toDoList = new IGIapp();
        toDoList.runtime();
    }
}