/**
 * This class is the main class of IGIapp todo list application.
 */

public class IGIapp {

    private Keyboard scanner;

    public IGIapp()
    {
        scanner = new Keyboard();
    }

    /**
     * Print the welcome message on the screen.
     */
    private void welcomeText() {
        System.out.println("*****************");
        System.out.println("Welcome to IGIapp");
        System.out.println("You have 0 tasks todo and 0 tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Quit");
        System.out.println("(2) Create a task");
        System.out.println("*****************");
    }

    /**
     * Run the application. User can type and system will respond. So far with limited options.
     */
    private void runtime() {
        String inputFromUser;
        boolean runtimeActive = true;
        while (runtimeActive) {
            inputFromUser = scanner.getInput();
            if (inputFromUser.equals("1")) {
                System.out.println("You have chosen to quit. Have a nice day.");
                runtimeActive = false;
            } else if (inputFromUser.equals("2")) {
                testOfTasks();
            } else {
                System.out.println("I don't understand. You can choose between options 1 and 2.");
            }
        }
    }

    /**
     * Method just for testing purposes of the task class. Will be deleted once command class is implemented.
     */
    private void testOfTasks()
    {
        Task testTask = new Task("Buy more groceries", "Doomsday preparation");
        System.out.println(testTask.toString());
    }

    public static void main(String[] args) {

        IGIapp toDoList = new IGIapp();
        toDoList.welcomeText();
        toDoList.runtime();

    }
}