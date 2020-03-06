import java.util.concurrent.TimeUnit;

/**
 * This class is the main class of IGIapp todo list application, currently the only class.
 */

public class IGIapp {

    /**
     * Print the welcome message on the screen.
     */
    private static void welcomeText() {
        System.out.println("*****************");
        System.out.println("Welcome to IGIapp");
        System.out.println("You have 0 tasks todo and 0 tasks are done!");
        System.out.println("No options to pick at the moment");
        System.out.println("*****************");
    }

    /**
     * Keep the app active for another 10 seconds to see the result of the action.
     * It will be decommissioned when the text input will be functional.
     */
    private static void wait10Seconds() {
        System.out.println("App closes in 10 seconds");
        try{
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Waiting was interrupted");
        }
    }

    public static void main(String[] args) {
        welcomeText();
        wait10Seconds();

    }
}