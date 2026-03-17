import java.util.Arrays;
import java.util.List;

public class BookingValidator {

    private static final List<String> VALID_ROOM_TYPES =
            Arrays.asList("Single", "Double", "Suite");

    public static void validate(String guestName, String roomType)
            throws InvalidBookingException {

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if (!VALID_ROOM_TYPES.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}
