package toDoList.data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class stores multiple types of information that creates a task in the system.
 */
public class Task implements Serializable
{
    private String title;
    private String project;
    private boolean isCompleted;
    private LocalDate deadline;

    /**
     * Create a task object.
     * @param title Text of the task.
     * @param project Name of the project to which the task belongs to.
     * @param deadline Date when the task should be completed.
     */
    public Task(String title, String project, LocalDate deadline)
    {
        this.title = title;
        this.project = project;
        isCompleted = false;
        this.deadline = deadline;
    }

    /**
     * Return text summary of a task, so it can be displayed for user.
     * @return Summary of all task fields in one String.
     */
    @Override
    public String toString()
    {
        if (isCompleted) {
            return (deadline + "\tdone\t" + project + "\t\t\t" + title);
        } else {
            return (deadline + "\topen\t" + project + "\t\t\t" + title);
        }
    }

    /**
     * Return information, if the task has been completed.
     * @return Task status, true if it has been completed.
     */
    public boolean getStatus()
    {
        return isCompleted;
    }

    /**
     * Return deadline of the task.
     * @return Task deadline.
     */
    public LocalDate getDeadline()
    {
        return deadline;
    }

    /**
     * Return name of the project, to which the task belongs to.
     * @return Project name.
     */
    public String getProject()
    {
        return project;
    }

    /**
     * Mark task as completed regardless of previous status.
     */
    public void markAsDone()
    {
        isCompleted = true;
    }

    /**
     * Change the title of the task.
     * @param title New title of the task.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Change the project of the task.
     * @param project New project of the task.
     */
    public void setProject(String project)
    {
        this.project = project;
    }

    /**
     * Change the deadline of the task.
     * @param deadline New deadline of the task.
     */
    public void setDeadline(LocalDate deadline)
    {
        this.deadline = deadline;
    }
}