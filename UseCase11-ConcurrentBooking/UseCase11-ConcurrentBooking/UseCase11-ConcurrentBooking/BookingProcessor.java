public class BookingProcessor extends Thread {

    private Reservation reservation;
    private InventoryService inventory;

    public BookingProcessor(Reservation reservation, InventoryService inventory) {
        this.reservation = reservation;
        this.inventory = inventory;
    }

    @Override
    public void run() {

        String roomId = inventory.allocateRoom(reservation.getRoomType());

        if (roomId != null) {
            System.out.println("Booking confirmed for Guest: "
                    + reservation.getGuestName()
                    + ", Room ID: "
                    + roomId);
        } else {
            System.out.println("Booking failed for Guest: "
                    + reservation.getGuestName());
        }
    }
}
