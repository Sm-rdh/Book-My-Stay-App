public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        InventoryService inventory = new InventoryService();
        CancellationService cancellation = new CancellationService();

        String reservationId = "Single-1";
        String roomType = "Single";

        // Simulate cancellation
        cancellation.cancelBooking(reservationId, roomType, inventory);

        // Show rollback history
        cancellation.showRollbackHistory();

        // Show updated inventory
        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getAvailability(roomType));
    }
}
