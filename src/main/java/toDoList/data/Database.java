package toDoList.data;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class that hosts task database and provide methods that are available to call on it.
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
     * @param title Text of the task.
     * @param project Project to which the task can be related to.
     * @param deadline Deadline of the task.
     */
    public void addTask(String title, String project, LocalDate deadline)
    {
        Task testTask = new Task(title, project, deadline);
        taskDatabase.add(testTask);
    }

    /**
     * Provide text output of all tasks in the system in a form of table that can be displayed to user.
     * In case of the empty database, the output is reduced to simple sentence.
     * @return Text output of all tasks.
     */
    @Override
    public String toString()
    {
        String textOutput;
        if (getTasksCount() == 0) {
            textOutput = "Database is empty.\n";
        } else {
            textOutput = "Current list of tasks contains:\n" +
                     "*******************************\n" +
                     "#  date\t\t\tstatus\tproject\t\t\t\t\ttitle\n";
            for (int counter = 0; counter < getTasksCount(); counter++) {
                textOutput = textOutput + counter + ") " + taskDatabase.get(counter).toString() + "\n";
            }
        }
        return textOutput;
    }

    /**
     * Remove the task from the database.
     * @param taskNumber Position of task in the database.
     * Throws: IndexOutOfBoundsException - if the index is out of range.
     */
    public void removeTask(int taskNumber)
    {
        taskDatabase.remove(taskNumber);
        System.out.println("Task was removed.\n");
    }

    /**
     * Return the number of tasks that are stored in the database.
     * @return Number of tasks.
     */
    public int getTasksCount()
    {
        return taskDatabase.size();
    }

    /**
     * Return the number of tasks of specific task status.
     * @param isCompleted Status of task (true - task done, false - task open).
     * @return Filtered number of tasks.
     */
    public int getTasksCount(boolean isCompleted)
    {
        int countOfTasks = 0;
        for (Task task : taskDatabase) {
            if (task.getIsCompleted() == isCompleted) {
                countOfTasks++;
            }
        }
        return countOfTasks;
    }

    /**
     * Change isCompleted status of specified task.
     * @param taskNumber Position of the task in the database.
     * @param newIsCompleted New isCompleted status of the task.
     * Throws: IndexOutOfBoundsException - if the index is out of range.
     */
    public void changeTaskInformation(int taskNumber, boolean newIsCompleted)
    {
        taskDatabase.get(taskNumber).setIsCompleted(newIsCompleted);
        System.out.println("Task status was changed.\n");
    }

    /**
     * Change deadline of specified task.
     * @param taskNumber Position of the task in the database.
     * @param newDeadline New deadline of the task.
     * Throws: IndexOutOfBoundsException - if the index is out of range.
     */
    public void changeTaskInformation(int taskNumber, LocalDate newDeadline)
    {
        taskDatabase.get(taskNumber).setDeadline(newDeadline);
        System.out.println("Deadline was changed.\n");
    }

    /**
     * Change title text of specified task.
     * @param newTitle New title of the task.
     * @param taskNumber Position of the task in the database.
     * Throws: IndexOutOfBoundsException - if the index is out of range.
     */
    public void changeTaskInformation(String newTitle, int taskNumber)
    {
        taskDatabase.get(taskNumber).setTitle(newTitle);
        System.out.println("Task title was changed.\n");
    }

    /**
     * Change project of specified task.
     * @param taskNumber Position of the task in the database.
     * @param newProject New project name of the task.
     * Throws: IndexOutOfBoundsException - if the index is out of range.
     */
    public void changeTaskInformation(int taskNumber, String newProject)
    {
        taskDatabase.get(taskNumber).setProject(newProject);
        System.out.println("Task project was changed.\n");
    }

    /**
     * Sort task database by chosen attribute in alphabetical or chronological order.
     * @param sortField can use "taskProject" or "taskTitle" value to sort by project or title, otherwise sort chronologically
     */
    public void sortTasks(String sortField){
        Comparator<Task> compare;
        if(sortField.equals("taskProject")) {
            compare = (Task t1, Task t2) -> t1.getProject().compareTo(t2.getProject());
        } else if(sortField.equals("taskTitle")) {
            compare = (Task t1, Task t2) -> t1.getTitle().compareTo(t2.getTitle());
        } else {
            compare = (Task t1, Task t2) -> t1.getDeadline().compareTo(t2.getDeadline());
        }
        Collections.sort(taskDatabase, compare);
    }
}