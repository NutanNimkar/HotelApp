package hotelapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    /**
     * Method to get all bookings from the database.
     *
     * @return List of bookings from the database.
     * @throws Exception when trying to connect to the database.
     */
    public List<Booking> getBookings() throws Exception {
        String sql = "SELECT * FROM \"Hotel\".booking";
        ConnectionDB db = new ConnectionDB();
        List<Booking> bookings = new ArrayList<>();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("bookingid"),
                        rs.getInt("customerid"),
                        rs.getInt("roomid"),
                        rs.getDate("bookingdate"),
                        rs.getDate("checkIndate"),
                        rs.getDate("checkoutdate")
                );
                bookings.add(booking);
            }
        } catch (Exception e) {
            throw new Exception("Error getting bookings: " + e.getMessage());
        }
        return bookings;
    }
}
