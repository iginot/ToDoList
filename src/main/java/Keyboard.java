import java.time.LocalDate;
import java.util.Scanner;

/**
 * Purpose of this class is to provide input from keyboard in correct format.
 */
public class Keyboard
{
    private Scanner reader;

    /**
     * Create a keyboard object.
     */
    public Keyboard()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Return the String type of input provided by the user.
     * @return String user input.
     */
    public String getString()
    {
        return reader.nextLine();
    }

    /**
     * Return the LocalDate type of input provided by the user.
     * If the input is not in correct format, used is repeatedly ask to provide correct one with example shown.
     * @return LocalDate user input.
     */
    public LocalDate getLocalDate()
    {
        LocalDate processedDate;
        try {
            processedDate = LocalDate.parse(getString());
        } catch (Exception e) {
            System.out.println("Date has invalid format. The correct format is 2020-02-29");
            processedDate = getLocalDate();
        }
        return processedDate;
    }

    /**
     * Return the int type of input provided by the user.
     * If the input is not in correct format, used is repeatedly ask to provide correct one.
     * @return int user input.
     */
    public int getInt()
    {
        int processedInt;
        try {
            processedInt = Integer.parseInt(getString());
        } catch (Exception e) {
            System.out.println("Number without decimals is expected. Please try again.");
            processedInt = getInt();
        }
        return processedInt;
    }
}