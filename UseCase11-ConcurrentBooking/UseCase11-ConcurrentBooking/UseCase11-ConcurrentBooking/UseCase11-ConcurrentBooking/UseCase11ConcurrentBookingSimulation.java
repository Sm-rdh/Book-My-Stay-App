import java.util.Map;

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        InventoryService inventory = new InventoryService();

        // Create reservations
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Vanmathi", "Double");
        Reservation r3 = new Reservation("Kunal", "Suite");
        Reservation r4 = new Reservation("Subha", "Single");

        // Create threads
        Thread t1 = new BookingProcessor(r1, inventory);
        Thread t2 = new BookingProcessor(r2, inventory);
        Thread t3 = new BookingProcessor(r3, inventory);
        Thread t4 = new BookingProcessor(r4, inventory);

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print remaining inventory
        System.out.println("\nRemaining Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.getInventory().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
