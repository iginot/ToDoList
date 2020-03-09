import java.util.Date;

/**
 * This class allows creating tasks objects. Date is still a little challenging.
 */

public class Task
{
    private String title;
    private boolean status;
    private Date dueDate;
    private String project;

    public Task(String title,  String project)
    {
        this.title = title;
        status = false;
        dueDate = new Date();
        this.project = project;
    }

    public String toString() {
        if (status) {
            return (title + " from project " + project + " was done. The deadline was  " + dueDate);
        } else {
            return (title + " from project " + project + " should be done before " + dueDate);
        }
    }
}
