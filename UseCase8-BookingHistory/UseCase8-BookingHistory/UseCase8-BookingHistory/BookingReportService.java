import java.util.List;

public class BookingReportService {

    public void generateReport(List<Reservation> reservations) {

        System.out.println("\nBooking History Report");

        for (Reservation r : reservations) {
            System.out.println("Guest: " + r.getGuestName()
                    + ", Room Type: " + r.getRoomType());
        }
    }
}
