import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Provide ability to read from the file and also save changes in it.
 */

public class IOoperations
{
    /**
     * Create a Input-output operations object.
     */
    public IOoperations()
    {}

    /**
     * Save database of tasks to the file, when closing the application, so it will be available by next run.
     * @param dataToSave whole database of tasks
     */
    public void databaseSaveToFile(Database dataToSave)
    {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("TaskDatabase.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(dataToSave);

            objectOutputStream.close();
            fileOutputStream.close();

        } catch (Exception e) {
            System.out.println("Database save unsuccessful.");
        } finally {
            try{
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch(Exception e) {
                System.out.println("Database close unsuccessful.");
            }
        }
    }

    /**
     * Load database of tasks from file by startup of application.
     * @return whole database of tasks
     */
    public Database databaseReadFromFile() {

        Database dataFromDatabase = new Database();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("TaskDatabase.txt");
            ois = new ObjectInputStream(fis);
            dataFromDatabase = (Database) ois.readObject();

        } catch(Exception e) {
            System.out.println("Database load unsuccessful.");

        } finally {
            try{
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch(Exception e) {
                System.out.println("Database close unsuccessful.");
            } finally {
                return dataFromDatabase;
            }
        }
    }
}
