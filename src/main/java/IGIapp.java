import java.util.concurrent.TimeUnit;

/**
 * This class is the main class of IGIapp todo list application.
 */

public class IGIapp {

    private Keyboard scanner;
    private String toDelete;


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
        System.out.println("No options to pick at the moment");
        System.out.println("*****************");

        toDelete = scanner.getInput();
        System.out.println("\n You have written: " + toDelete);
    }

    /**
     * Keep the app active for another 10 seconds to see the result of the action.
     * It will be decommissioned when the text input will be functional.
     */
    private void wait10Seconds() {
        System.out.println("App closes in 10 seconds");
        try{
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Waiting was interrupted");
        }
    }

    public static void main(String[] args) {

        IGIapp toDoList = new IGIapp();
        toDoList.welcomeText();



    }
}