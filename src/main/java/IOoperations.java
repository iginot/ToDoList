import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class is able to read from the file and also save changes in it.
 */

public class IOoperations
{
    public void databaseSave(Database dataToSave)
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("TaskDatabase.txt");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(dataToSave);

            oos.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("Database save unsuccessful.");
        } finally {
            try{
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch(Exception e) {
                System.out.println("Database close unsuccessul.");
            }
        }
    }

    public Database databaseRead() {

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
