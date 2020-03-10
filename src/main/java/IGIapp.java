/**
 * This class is the main class of IGIapp todo list application.
 */

public class IGIapp {

    /**
     * Print the welcome message on the screen.
     */
    private void welcomeText() {
        System.out.println("*****************");
        System.out.println("Welcome to IGIapp");
        System.out.println("You have 0 tasks to do and 0 tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Show task list");
        System.out.println("(2) Add new task");
        System.out.println("(4) Quit");
        System.out.println("*****************");
    }

    /**
     * Run the application. User can type and system will respond. So far with limited options.
     */
    private void runtime() {

        boolean runtimeActive = true;
        Keyboard scanner = new Keyboard();
        Command commander = new Command();

        welcomeText();

        while (runtimeActive) {
            runtimeActive = commander.processCommand(scanner.getInput());
        }
    }

    public static void main(String[] args) {

        IGIapp toDoList = new IGIapp();
        toDoList.runtime();

    }
}