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
        // cuts the project field to chosen number of characters, to make summary of tasks more readable
        int showedProjectLength = 20;
        String showedProject;
        String oneSpace = " ";
        if (project.length() > showedProjectLength) {
            showedProject = project.substring(0, showedProjectLength);
        } else {
            showedProject = project + oneSpace.repeat(showedProjectLength - project.length());
        }

        if (isCompleted) {
            return (deadline + "\tdone\t" + showedProject + "\t" + title);
        } else {
            return (deadline + "\topen\t" + showedProject + "\t" + title);
        }
    }

    /**
     * Return information, if the task has been completed.
     * @return Task status, true if it has been completed.
     */
    public boolean getIsCompleted()
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
    public void setIsCompleted(boolean isCompleted)
    {
        this.isCompleted = isCompleted;
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