import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;

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

    public void addTask(String name, String project, LocalDate deadline)
    {
        Task testTask = new Task(name, project, deadline);
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
                output = output + counter + ") " + taskDatabase.get(counter).toString() + "\n";
            }
        }
        return output;
    }

    public void removeTask(String taskNumber)
    {
        try{
            int number = Integer.parseInt(taskNumber);
            taskDatabase.remove(number);
            System.out.println("Task removal successful");

        } catch (Exception e){
            System.out.println("Task removal unsuccessful");
        }
    }

    public int getTasksCount(boolean isDone)
    {
        int countOfTasks = 0;
        for (Task task : taskDatabase) {
            if (task.getStatus() == isDone){
                countOfTasks++;
            }
        }
        return countOfTasks;
    }

    public void markTaskAsDone(String taskNumber)
    {
        try{
            int number = Integer.parseInt(taskNumber);
            taskDatabase.get(number).markAsDone();
            System.out.println("Task removal successful");

        } catch (Exception e){
            System.out.println("Task removal unsuccessful");
        }
    }

}
