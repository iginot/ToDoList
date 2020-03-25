package toDoList.data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

/**
 * This class tests methods from class Task.
 */
public class TaskTest
{
    /**
     * Testing toString method with task that has false value in boolean isCompleted, so it is still open.
     */
    @Test
    public void testToStringForTaskWithOpenStatus()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        String stringOfOpenTask = sampleOpenTask.toString();
        assertEquals(stringOfOpenTask, "2020-12-31\topen\tsampleProject\t\t\tsampleTitle");
    }

    /**
     * Testing getStatus method with task that has false value in boolean isCompleted, so it is still open.
     */
    @Test
    public void testGetStatusForTaskWithOpenStatus()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        boolean statusOfOpenTask = sampleOpenTask.getStatus();
        assertEquals(statusOfOpenTask, false);
    }

    /**
     * Testing getDeadline method with sample task.
     */
    @Test
    public void testGetDeadlineForTask()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        LocalDate deadlineOfTask = sampleOpenTask.getDeadline();
        assertEquals(deadlineOfTask, LocalDate.parse("2020-12-31"));
    }

    /**
     * Testing getProject method with sample task.
     */
    @Test
    public void testGetProjectForTask()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        String projectOfTask = sampleOpenTask.getProject();
        assertEquals(projectOfTask, "sampleProject");
    }

    /**
     * Testing markAsDone method with open task.
     */
    @Test
    public void testMarkAsDoneForOpenTask()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleOpenTask.markAsDone();
        boolean statusOfTaskAfterwards = sampleOpenTask.getStatus();
        assertEquals(statusOfTaskAfterwards, true);
    }

    /**
     * Testing markAsDone method twice in a row to make sure it's not setting back status to open.
     */
    @Test
    public void testMarkAsDoneForClosedTask()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleOpenTask.markAsDone();
        sampleOpenTask.markAsDone();
        boolean statusOfTaskAfterTwoCalls = sampleOpenTask.getStatus();
        assertEquals(statusOfTaskAfterTwoCalls, true);
    }

    /**
     * Testing toString method with closed task.
     */
    @Test
    public void testToStringForTaskWithClosedStatus()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleOpenTask.markAsDone();
        String stringOfOpenTask = sampleOpenTask.toString();
        assertEquals(stringOfOpenTask, "2020-12-31\tdone\tsampleProject\t\t\tsampleTitle");
    }

    /**
     * Testing setTitle method with sample task.
     */
    @Test
    public void testSetTitleForTask()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleOpenTask.setTitle("changedTitle");
        String taskWithChangedTitle = sampleOpenTask.toString();
        assertEquals(taskWithChangedTitle, "2020-12-31\topen\tsampleProject\t\t\tchangedTitle");
    }

    /**
     * Testing setProject method with sample task.
     */
    @Test
    public void testSetProjectForTask()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleOpenTask.setProject("changedProject");
        String newProjectName = sampleOpenTask.getProject();
        assertEquals(newProjectName, "changedProject");
    }

    /**
     * Testing setDeadline method with sample task.
     */
    @Test
    public void testSetDeadline()
    {
        Task sampleOpenTask = new Task("sampleTitle", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleOpenTask.setDeadline(LocalDate.parse("2020-11-30"));
        LocalDate newDeadline = sampleOpenTask.getDeadline();
        assertEquals(newDeadline, LocalDate.parse("2020-11-30"));
    }
}
