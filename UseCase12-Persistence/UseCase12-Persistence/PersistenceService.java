import java.io.*;

public class PersistenceService {

    private static final String FILE_NAME = "inventory.dat";

    // Save inventory
    public void save(InventoryService inventory) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Load inventory
    public InventoryService load() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (InventoryService) ois.readObject();

        } catch (Exception e) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return new InventoryService();
        }
    }
}
