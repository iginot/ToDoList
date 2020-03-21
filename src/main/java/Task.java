import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class allows creating tasks objects. Date is still a little challenging.
 */

public class Task implements Serializable
{
    private String title;
    private String project;
    private boolean status;
    private LocalDate date;

    public Task(String title, String project, LocalDate deadline)
    {
        this.title = title;
        this.project = project;
        status = false;
        this.date = deadline;
    }

    public String toString() {
        if (status) {
            return ("You have done " + title + " with deadline " + date + " regarding project " + project + ".");
        } else {
            return ("You need to do " + title + " until " + date + " regarding project " + project + ".");

            }
        }

    public String taskSummary(){
        return (title + ";" + project + ";");
    }
}