import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class allows creating tasks objects. Date is still a little challenging.
 */

public class Task implements Serializable
{
    private String title;
    private String project;
    private boolean isCompleted;
    private LocalDate date;

    public Task(String title, String project, LocalDate deadline)
    {
        this.title = title;
        this.project = project;
        isCompleted = false;
        this.date = deadline;
    }

    public String toString() {
        if (isCompleted) {
            return ("You have done " + title + " with deadline " + date + " regarding project " + project + ".");
        } else {
            return ("You need to do " + title + " until " + date + " regarding project " + project + ".");

            }
        }
    public boolean getStatus()
    {
        return isCompleted;
    }

    public void markAsDone()
    {
        isCompleted = true;
    }
}