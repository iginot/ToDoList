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
    private LocalDate deadline;

    public Task(String title, String project, LocalDate deadline)
    {
        this.title = title;
        this.project = project;
        isCompleted = false;
        this.deadline = deadline;
    }

    public String toString() {
        if (isCompleted) {
            return (deadline + "\tdone\t" + project + "\t\t\t" + title);
        } else {
            return (deadline + "\topen\t" + project + "\t\t\t" + title);
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

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setProject(String project)
    {
        this.project = project;
    }

    public void setDeadline(LocalDate deadline)
    {
        this.deadline = deadline;
    }
}