import java.util.ArrayList;
import java.io.Serializable;

/**
 * Place for task database and methods that are available to call on it.
 */

public class Database implements Serializable
{
    private ArrayList<Task> taskDatabase;

    public Database()
    {
        taskDatabase = new ArrayList<Task>();
    }

    public void addTask(String name, String project)
    {
        Task testTask = new Task(name, project);
        taskDatabase.add(testTask);
    }

    public String showTasks()
    {
        String output = "";
        if (taskDatabase.size() == 0) {
            output = "Database is empty.";
        } else {
            output = "Current list of tasks contains:\n" +
                     "*******************************\n";
            for (int counter = 0; counter < taskDatabase.size(); counter++) {
                output = output + taskDatabase.get(counter).toString() + "\n";
            }
        }
        return output;
    }

    public String summarizeTasks()
    {
        String taskSummarization = "";
        if (taskDatabase.size() > 0)
        {
            for (int counter = 0; counter < taskDatabase.size(); counter++) {
                taskSummarization = taskSummarization + taskDatabase.get(counter).taskSummary();
            }
        }
        return taskSummarization;
    }

}
