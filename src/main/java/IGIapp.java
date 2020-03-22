/**
 * This class is the main class of IGIapp todo list application.
 */

public class IGIapp {

    /**
     * Print the welcome message on the screen.
     */

    private void showMenuText(){
        System.out.println("Pick an option:");
        System.out.println("(1) Show task list");
        System.out.println("(2) Add new task");
        System.out.println("(3) Edit task");
        System.out.println("(4) Quit");
    }

    /**
     * Run the application. User can type and system will respond.
     */
    private void runtime() {

        boolean runtimeActive = true;
        Keyboard scanner = new Keyboard();
        Command commander = new Command();

        commander.showWelcomeText();

        while (runtimeActive) {
            showMenuText();
            runtimeActive = commander.processCommand(scanner.getInput());
        }
    }

    public static void main(String[] args) {

        IGIapp toDoList = new IGIapp();
        toDoList.runtime();
    }
}