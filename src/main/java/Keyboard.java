import java.util.Scanner;

/**
 * Purpose of this class is to provide input from keyboard.
 */

public class Keyboard
{
    private Scanner reader;

    public Keyboard()
    {
        reader = new Scanner(System.in);
    }

    public String getInput()
    {
        return reader.nextLine();
    }
}