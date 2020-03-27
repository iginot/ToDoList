package toDoList.data;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * This class tests methods from class Database.
 */
public class DatabaseTest {

    /**
     * Testing showTasks method on empty database.
     */
    @Test
    public void testShowTasksOnEmptyDatabase()
    {
        Database sampleDatabase = new Database();
        String stringOfEmptyDatabase = sampleDatabase.toString();
        assertEquals(stringOfEmptyDatabase, "Database is empty.\n");
    }

    /**
     * Testing removeTask method on sample database
     */
    @Test
    public void testRemoveTaskOnSampleDatabase()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("sampleName", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleDatabase.removeTask(0);
        int tasksCount = sampleDatabase.getTasksCount(true) + sampleDatabase.getTasksCount(false);
        assertEquals(tasksCount, 0);
    }

    /**
     * Testing getTasksCount method for open tasks on empty database
     */
    @Test
    public void testGetOpenTaskCountOnEmptyDatabase()
    {
        Database sampleDatabase = new Database();
        int openTasksCount = sampleDatabase.getTasksCount(false);
        assertEquals(openTasksCount, 0);
    }

    /**
     * Testing getTasksCount method for open tasks on database with one open task
     */
    @Test
    public void testGetTaskOpenCountOnDatabaseWithOneOpenTask()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("sampleName", "sampleProject", LocalDate.parse("2020-12-31"));
        int openTasksCount = sampleDatabase.getTasksCount(false);
        assertEquals(openTasksCount, 1);
    }

    /**
     * Testing getTasksCount method for closed tasks on empty database
     */
    @Test
    public void testGetClosedTaskCountOnEmptyDatabase()
    {
        Database sampleDatabase = new Database();
        int openTasksCount = sampleDatabase.getTasksCount(true);
        assertEquals(openTasksCount, 0);
    }

    /**
     * Testing getTasksCount method for closed tasks on database with one open task
     */
    @Test
    public void testGetClosedTaskCountOnDatabaseWithOneOpenTask()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("sampleName", "sampleProject", LocalDate.parse("2020-12-31"));
        int openTasksCount = sampleDatabase.getTasksCount(true);
        assertEquals(openTasksCount, 0);
    }

    /**
     * Testing getTasksCount method for closed tasks on database with one closed task
     */
    @Test
    public void testGetClosedTaskCountOnDatabaseWithOneClosedTask()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("sampleName", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleDatabase.changeTaskInformation(0, true);
        int openTasksCount = sampleDatabase.getTasksCount(true);
        assertEquals(openTasksCount, 1);
    }

    /**
     * Testing existsSuchTask method on empty database
     */
    @Test
    public void testExistsSuchTaskOnEmptyDatabase()
    {
        Database sampleDatabase = new Database();
        boolean taskExists = sampleDatabase.existsSuchTask(0);
        assertEquals(taskExists, false);
    }

    /**
     * Testing existsSuchTask method on sample database
     */
    @Test
    public void testExistsSuchTaskOnSampleDatabase()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("sampleName", "sampleProject", LocalDate.parse("2020-12-31"));
        boolean taskExists = sampleDatabase.existsSuchTask(0);
        assertEquals(taskExists, true);
    }

    /**
     * Testing sortByDeadline method on sample unordered database
     */
    @Test
    public void testSortByDeadlineOnSampleUnorderedDatabase()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("secondTaskToFinish", "sampleProject", LocalDate.parse("2020-12-31"));
        sampleDatabase.addTask("firstTaskToFinish", "sampleProject", LocalDate.parse("2020-11-30"));
        String databaseBeforeSorting = sampleDatabase.toString();
        sampleDatabase.sortByDeadline();
        String databaseAfterSoring = sampleDatabase.toString();
        assertThat(databaseBeforeSorting, not(equalTo(databaseAfterSoring)));
    }

    /**
     * Testing sortByDeadline method on sample database already ordered by deadline
     */
    @Test
    public void testSortByDeadlineOnSampleOrderedDatabase()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("firstTaskToFinish", "sampleProject", LocalDate.parse("2020-11-30"));
        sampleDatabase.addTask("secondTaskToFinish", "sampleProject", LocalDate.parse("2020-12-31"));
        String databaseBeforeSorting = sampleDatabase.toString();
        sampleDatabase.sortByDeadline();
        String databaseAfterSoring = sampleDatabase.toString();
        assertThat(databaseBeforeSorting, equalTo(databaseAfterSoring));
    }

    /**
     * Testing sortByProject method on sample unordered database
     */
    @Test
    public void testSortByProjectSampleUnorderedDatabase()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("firstTaskOfB-project", "B-project", LocalDate.parse("2020-12-31"));
        sampleDatabase.addTask("secondTaskOfA-project", "A-project", LocalDate.parse("2020-12-31"));
        String databaseBeforeSorting = sampleDatabase.toString();
        sampleDatabase.sortByProject();
        String databaseAfterSoring = sampleDatabase.toString();
        assertThat(databaseBeforeSorting, not(equalTo(databaseAfterSoring)));
    }

    /**
     * Testing sortByProject method on sample database already ordered by project
     */
    @Test
    public void testSortByProjectOnSampleOrderedDatabase()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("secondTaskOfA-project", "A-project", LocalDate.parse("2020-12-31"));
        sampleDatabase.addTask("firstTaskOfB-project", "B-project", LocalDate.parse("2020-12-31"));
        String databaseBeforeSorting = sampleDatabase.toString();
        sampleDatabase.sortByProject();
        String databaseAfterSoring = sampleDatabase.toString();
        assertThat(databaseBeforeSorting, equalTo(databaseAfterSoring));
    }
}
