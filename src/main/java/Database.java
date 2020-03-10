import java.util.ArrayList;

/**
 * Place for task database and methods that are available to call on it.
 */

public class Database
{
    private ArrayList<Task> taskDatabase;

    public Database()
    {
        taskDatabase = new ArrayList<Task>();
    }

    public String addTask()
    {
        Task testTask = new Task("Buy more groceries", "Doomsday preparation");
        taskDatabase.add(testTask);
        return "Task successfully added.";
    }

    public String showTasks()
    {
        String output = "";
        if (taskDatabase.size() == 0) {
            output = "Database is empty.";
        } else {
            for (int counter = 0; counter < taskDatabase.size(); counter++) {
                output = output + taskDatabase.get(counter).toString() + "\n";
            }
        }
        return output;
    }

}
