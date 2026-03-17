public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        PersistenceService persistence = new PersistenceService();

        // Load previous state
        InventoryService inventory = persistence.load();

        // Display inventory
        inventory.displayInventory();

        // Save current state
        persistence.save(inventory);
    }
}
