import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

/**
 * Place for task database and methods that are available to call on it.
 */
public class Database implements Serializable
{
    private ArrayList<Task> taskDatabase;

    /**
     * Create a database object.
     */
    public Database()
    {
        taskDatabase = new ArrayList<>();
    }

    /**
     * Add new task to the database of tasks.
     * @param name Text of the task.
     * @param project Project to which the task can be related to.
     * @param deadline Deadline of the task.
     */
    public void addTask(String name, String project, LocalDate deadline)
    {
        Task testTask = new Task(name, project, deadline);
        taskDatabase.add(testTask);
    }

    /**
     * Check if the database of tasks is empty or if it contains some tasks.
     * If the database is empty, edit task in menu is disabled.
     * @return True, if the Database is empty, otherwise false.
     */
    public boolean isDatabaseEmpty()
    {
        boolean isDatabaseEmpty = true;
        if (taskDatabase.size() > 0){
            isDatabaseEmpty = false;
        }
        return isDatabaseEmpty;
    }

    /**
     * Provide text output of all tasks in the system in a form of table that can be displayed to user.
     * In case of the empty database, the output is reduced to simple sentence.
     * @return Text output of all tasks.
     */
    public String showTasks()
    {
        String textOutput = "";
        if (isDatabaseEmpty()) {
            textOutput = "Database is empty.\n";
        } else {
            textOutput = "Current list of tasks contains:\n" +
                     "*******************************\n" +
                     "#  date\t\t\tstatus\tproject\t\ttask\n";
            for (int counter = 0; counter < taskDatabase.size(); counter++) {
                textOutput = textOutput + counter + ") " + taskDatabase.get(counter).toString() + "\n";
            }
        }
        return textOutput;
    }

    /**
     * Remove the task from the database.
     * @param taskNumber Position of task in the database.
     */
    public void removeTask(int taskNumber)
    {
        taskDatabase.remove(taskNumber);
        System.out.println("Task was removed.\n");
    }

    /**
     * Return the number of tasks of specific task status.
     * @param isDone Status of task (true - task done, false - task open).
     * @return Filtered number of tasks.
     */
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

    /**
     * Mark chosen task as done and inform the user about it.
     * @param taskNumber Position of the task in the database.
     */
    public void markTaskAsDone(int taskNumber)
    {
        taskDatabase.get(taskNumber).markAsDone();
        System.out.println("Task is marked as done.\n");
    }

    /**
     * Verify, if there is a task on provided position in the database. Inform user, if such task doesn't exist.
     * @param taskNumber Position of the task in the database.
     * @return True - if such task exist or false - if such task doesn't exist.
     */
    public boolean existsSuchTask(int taskNumber)
    {
        if(taskNumber >= 0 && taskNumber < taskDatabase.size()) {
            return true;
        } else {
            System.out.println("No such task.\n");
            return false;
        }
    }

    /**
     * Change deadline of specified task.
     * @param taskNumber Position of the task in the database.
     * @param newDeadline New deadline of the task.
     */
    public void changeTaskDeadline(int taskNumber, LocalDate newDeadline)
    {
        taskDatabase.get(taskNumber).setDeadline(newDeadline);
        System.out.println("Deadline was changed.\n");
    }

    /**
     * Change title text of specified task.
     * @param taskNumber Position of the task in the database.
     * @param newTitle New title of the task.
     */
    public void changeTaskTitle(int taskNumber, String newTitle)
    {
        taskDatabase.get(taskNumber).setTitle(newTitle);
        System.out.println("Task title was changed.\n");
    }

    /**
     * Change project of specified task.
     * @param taskNumber Position of the task in the database.
     * @param newProject New project name of the task.
     */
    public void changeTaskProject(int taskNumber, String newProject)
    {
        taskDatabase.get(taskNumber).setProject(newProject);
        System.out.println("Task project was changed.\n");
    }

    /**
     * Sort task database by deadline, oldest first.
     */
    public void sortByDeadline(){
        Comparator<Task> compareByDeadline = (Task t1, Task t2) ->
                t1.getDeadline().compareTo( t2.getDeadline() );
        Collections.sort(taskDatabase, compareByDeadline);
    }

    /**
     * Sort task database by project name in alphabetical order.
     */
    public void sortByProject(){
        Comparator<Task> compareByProject = (Task t1, Task t2) ->
                t1.getProject().compareTo( t2.getProject() );
        Collections.sort(taskDatabase, compareByProject);
    }
}