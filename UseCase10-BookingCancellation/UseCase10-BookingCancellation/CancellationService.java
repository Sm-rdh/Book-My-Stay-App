import java.util.Stack;

public class CancellationService {

    private Stack<String> rollbackStack = new Stack<>();

    public void cancelBooking(String reservationId, String roomType, InventoryService inventory) {

        // Push to rollback stack
        rollbackStack.push(reservationId);

        // Restore inventory
        inventory.releaseRoom(roomType);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");

        for (int i = rollbackStack.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + rollbackStack.get(i));
        }
    }
}
