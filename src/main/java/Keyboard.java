import java.time.LocalDate;
import java.util.Scanner;

/**
 * Purpose of this class is to provide input from keyboard in correct format.
 */
public class Keyboard
{
    private Scanner reader;

    public Keyboard()
    {
        reader = new Scanner(System.in);
    }

    public String getString()
    {
        return reader.nextLine();
    }

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