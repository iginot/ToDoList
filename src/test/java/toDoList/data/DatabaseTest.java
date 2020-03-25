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
     * Testing isDatabaseEmpty method directly after creating Database object
     */
    @Test
    public void testIsDatabaseEmptyAfterCreating()
    {
        Database sampleDatabase = new Database();
        boolean databaseStatus = sampleDatabase.isDatabaseEmpty();
        assertEquals(databaseStatus, true);
    }

    /**
     * Testing isDatabaseEmpty method after adding task to database
     */
    @Test
    public void testIsDatabaseEmptyAfterAddingTask()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.addTask("sampleName", "sampleProject", LocalDate.parse("2020-12-31"));
        boolean databaseStatus = sampleDatabase.isDatabaseEmpty();
        assertEquals(databaseStatus, false);
    }

    /**
     * Testing showTasks method on empty database.
     */
    @Test
    public void testShowTasksOnEmptyDatabase()
    {
        Database sampleDatabase = new Database();
        String stringOfEmptyDatabase = sampleDatabase.showTasks();
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
        boolean databaseStatus = sampleDatabase.isDatabaseEmpty();
        assertEquals(databaseStatus, true);
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
        sampleDatabase.markTaskAsDone(0);
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
     * Testing sortByDeadline method on empty database
     */
    @Test
    public void testSortByDeadlineOnEmptyDatabase()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.sortByDeadline();
        boolean databaseStatus = sampleDatabase.isDatabaseEmpty();
        assertEquals(databaseStatus, true);
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
        String databaseBeforeSorting = sampleDatabase.showTasks();
        sampleDatabase.sortByDeadline();
        String databaseAfterSoring = sampleDatabase.showTasks();
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
        String databaseBeforeSorting = sampleDatabase.showTasks();
        sampleDatabase.sortByDeadline();
        String databaseAfterSoring = sampleDatabase.showTasks();
        assertThat(databaseBeforeSorting, equalTo(databaseAfterSoring));
    }

    /**
     * Testing sortByProject method on empty database
     */
    @Test
    public void testSortByProjectOnEmptyDatabase()
    {
        Database sampleDatabase = new Database();
        sampleDatabase.sortByProject();
        boolean databaseStatus = sampleDatabase.isDatabaseEmpty();
        assertEquals(databaseStatus, true);
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
        String databaseBeforeSorting = sampleDatabase.showTasks();
        sampleDatabase.sortByProject();
        String databaseAfterSoring = sampleDatabase.showTasks();
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
        String databaseBeforeSorting = sampleDatabase.showTasks();
        sampleDatabase.sortByProject();
        String databaseAfterSoring = sampleDatabase.showTasks();
        assertThat(databaseBeforeSorting, equalTo(databaseAfterSoring));
    }
}
