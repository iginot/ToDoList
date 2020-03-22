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

    public boolean isDatabaseEmpty()
    {
        boolean isDatabaseEmpty = true;
        if (taskDatabase.size() > 0){
            isDatabaseEmpty = false;
        }
        return isDatabaseEmpty;
    }

    public String showTasks()
    {
        String output = "";
        if (isDatabaseEmpty()) {
            output = "Database is empty.\n";
        } else {
            output = "Current list of tasks contains:\n" +
                     "*******************************\n" +
                     "#  date\t\t\tstatus\tproject\t\ttask\n";
            for (int counter = 0; counter < taskDatabase.size(); counter++) {
                output = output + counter + ") " + taskDatabase.get(counter).toString() + "\n";
            }
        }
        return output;
    }

    public void removeTask(int taskNumber)
    {
        taskDatabase.remove(taskNumber);
        System.out.println("Task was removed.\n");
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

    public void markTaskAsDone(int taskNumber)
    {
        taskDatabase.get(taskNumber).markAsDone();
        System.out.println("Task is marked as done.\n");
    }

    public boolean existsSuchTask(int taskNumber)
    {
        if(taskNumber >= 0 && taskNumber < taskDatabase.size()) {
            return true;
        } else {
            System.out.println("No such task.\n");
            return false;
        }
    }

    public void changeTaskDeadline(int taskNumber, LocalDate newDeadline)
    {
        taskDatabase.get(taskNumber).setDeadline(newDeadline);
        System.out.println("Deadline was changed.\n");
    }

    public void changeTaskTitle(int taskNumber, String newTitle)
    {
        taskDatabase.get(taskNumber).setTitle(newTitle);
        System.out.println("Task title was changed.\n");
    }

    public void changeTaskProject(int taskNumber, String newProject)
    {
        taskDatabase.get(taskNumber).setProject(newProject);
        System.out.println("Task project was changed.\n");
    }
}
