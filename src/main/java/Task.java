import java.io.Serializable;

/**
 * This class allows creating tasks objects. Date is still a little challenging.
 */

public class Task implements Serializable
{
    public String title;
    public String project;

    public Task(String title, String project)
    {
        this.title = title;
        this.project = project;
    }

    public String toString() {
            return (title + " from project " + project + ".");
        }

    public String taskSummary(){
        return (title + ";" + project + ";");
    }
}