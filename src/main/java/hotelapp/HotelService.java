package hotelapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelService {

    /**
     * Method to get all hotels from the database
     *
     * @return List of hotels from database
     * @throws Exception when trying to connect to database
     */
    public List<Hotel> getHotels() throws Exception {
        // SQL query
        String sql = "SELECT * FROM hotelchain.hotel"; // Assuming the table name is "hotel"
        // Database connection object
        ConnectionDB db = new ConnectionDB();
        // Data structure to store all hotels retrieved from database
        List<Hotel> hotels = new ArrayList<>();

        // Try to connect to the database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // Prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // Get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // Iterate through the result set
            while (rs.next()) {
                // Create a new Hotel object
                Hotel hotel = new Hotel(
                        rs.getInt("hotelId"),
                        rs.getInt("chainId"),
                        rs.getString("city"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("numOfRooms"),
                        rs.getString("category")
                );

                // Append the hotel to the hotels list
                hotels.add(hotel);
            }

            // Close the result set
            rs.close();
            // Close the statement
            stmt.close();
            // Close the connection
            con.close();
            // Close the database connection
            db.close();

            // Return the hotels retrieved from the database
            return hotels;
        } catch (Exception e) {
            // Throw any errors occurred
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method to delete a hotel by ID
     *
     * @param hotelId ID of the hotel to be deleted from the database
     * @return String message indicating if the hotel was successfully deleted or not
     * @throws Exception when trying to connect to the database
     */
    public String deleteHotel(Integer hotelId) throws Exception {
        // Database connection object
        ConnectionDB db = new ConnectionDB();
        String message = "";

        // SQL query
        String sql = "DELETE FROM hotelchain.hotel WHERE hotelId = ?";

        // Try to connect to the database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // Prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // Set the parameter for the hotel ID
            stmt.setInt(1, hotelId);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Check if any rows were affected
            if (rowsAffected == 1) {
                message = "Hotel successfully deleted!";
            } else {
                message = "Hotel with ID " + hotelId + " not found.";
            }

            // Close the statement
            stmt.close();
        } catch (Exception e) {
            message = "Error while deleting hotel: " + e.getMessage();
        } finally {
            // Close the database connection
            db.close();
        }

        return message;
    }

    /**
     * Method to add a new hotel to the database
     *
     * @param hotel Hotel object representing the new hotel to be added
     * @return String message indicating if the hotel was successfully added or not
     * @throws Exception when trying to connect to the database
     */
    public String addHotel(Hotel hotel) throws Exception {
        // Database connection object
        ConnectionDB db = new ConnectionDB();
        String message = "";

        // SQL query
        String sql = "INSERT INTO hotelchain.hotel (chainId, city, name, email, phone, numOfRooms, category) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Try to connect to the database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // Prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // Set parameters for the new hotel
            stmt.setInt(1, hotel.getChainId());
            stmt.setString(2, hotel.getCity());
            stmt.setString(3, hotel.getName());
            stmt.setString(4, hotel.getEmail());
            stmt.setString(5, hotel.getPhone());
            stmt.setInt(6, hotel.getNumOfRooms());
            stmt.setString(7, hotel.getCategory());

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Check if any rows were affected
            if (rowsAffected == 1) {
                message = "Hotel successfully added!";
            } else {
                message = "Failed to add hotel.";
            }

            // Close the statement
            stmt.close();
        } catch (Exception e) {
            message = "Error while adding hotel: " + e.getMessage();
        } finally {
            // Close
        }
        return message;
    }

    /**
     * Method to update an existing hotel in the database
     *
     * @param hotel Hotel object representing the updated hotel information
     * @return String message indicating if the hotel was successfully updated or not
     * @throws Exception when trying to connect to the database
     */
    public String updateHotel(Hotel hotel) throws Exception {
        // Database connection object
        ConnectionDB db = new ConnectionDB();
        String message = "";

        // SQL query
        String sql = "UPDATE hotelchain.hotel SET chainId=?, city=?, name=?, email=?, phone=?, numOfRooms=?, category=? WHERE hotelId=?";

        // Try to connect to the database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // Prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // Set parameters for the updated hotel
            stmt.setInt(1, hotel.getChainId());
            stmt.setString(2, hotel.getCity());
            stmt.setString(3, hotel.getName());
            stmt.setString(4, hotel.getEmail());
            stmt.setString(5, hotel.getPhone());
            stmt.setInt(6, hotel.getNumOfRooms());
            stmt.setString(7, hotel.getCategory());
            stmt.setInt(8, hotel.getHotelId());

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Check if any rows were affected
            if (rowsAffected == 1) {
                message = "Hotel successfully updated!";
            } else {
                message = "Failed to update hotel.";
            }

            // Close the statement
            stmt.close();
        } catch (Exception e) {
            message = "Error while updating hotel: " + e.getMessage();
        } finally {
            // Close the database connection
            db.close();
        }

        return message;
    }
}
