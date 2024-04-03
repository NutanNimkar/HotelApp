package hotelapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelService {

    /**
     * Method to get all hotels from the database
     *
     * @return List of hotels from database
     * @throws Exception when trying to connect to database
     */
    public List<Hotel> getHotels(Integer chainId) throws Exception {
        // SQL query
        String sql = "SELECT * FROM \"Hotel\".hotel"; // Assuming the table name is "hotel"
        // Check if a chainId is provided and append a WHERE clause
        if (chainId != null) {
            sql += " WHERE chainId = ?";
        }
        // Database connection object
        ConnectionDB db = new ConnectionDB();
        // Data structure to store all hotels retrieved from database
        List<Hotel> hotels = new ArrayList<>();

        // Try to connect to the database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // Prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // If a chainId is provided, set it as the parameter for the SQL query
            if (chainId != null) {
                stmt.setInt(1, chainId);
            }

            // Get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // Iterate through the result set
            while (rs.next()) {
                // Create a new Hotel object
                Hotel hotel = new Hotel(
                        rs.getInt("hotelId"),
                        rs.getInt("chainid"),
                        rs.getString("city"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("street"),
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
    public String deleteHotel(int hotelId) throws Exception {
        ConnectionDB db = new ConnectionDB();
        String message = "";

        try (Connection con = db.getConnection()) {
            // Check if there are any related rooms
            boolean roomsExist = checkRoomsExist(con, hotelId);
            // Check if there are any related employees
            boolean employeesExist = checkEmployeesExist(con, hotelId);

            // If there are related rooms, delete them first
            if (roomsExist) {
                deleteRelatedRooms(con, hotelId);
            }

            // If there are related employees, delete them first
            if (employeesExist) {
                deleteRelatedEmployees(con, hotelId);
            }

            // Proceed with deleting the hotel
            String sql = "DELETE FROM hotelchain.hotel WHERE hotelId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, hotelId);
            stmt.executeUpdate();
            stmt.close();

            message = "Hotel successfully deleted!";
        } catch (Exception e) {
            message = "Error while deleting hotel: " + e.getMessage();
        } finally {
            db.close();
        }

        return message;
    }

    private boolean checkRoomsExist(Connection con, int hotelId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM hotelchain.rooms WHERE hotelId = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, hotelId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int roomCount = rs.getInt(1);
            return roomCount > 0;
        }
        return false;
    }
    private boolean checkEmployeesExist(Connection con, int hotelId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM hotelchain.employees WHERE hotelId = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, hotelId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int employeeCount = rs.getInt(1);
            return employeeCount > 0;
        }
        return false;
    }
    private void deleteRelatedRooms(Connection con, int hotelId) throws SQLException, SQLException {
        String sql = "DELETE FROM hotelchain.rooms WHERE hotelId = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, hotelId);
        stmt.executeUpdate();
        stmt.close();
    }
    private void deleteRelatedEmployees(Connection con, int hotelId) throws SQLException {
        String sql = "DELETE FROM hotelchain.employees WHERE hotelId = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, hotelId);
        stmt.executeUpdate();
        stmt.close();
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
        String sql = "INSERT INTO hotelchain.hotel (city, name, email, phone, street, numOfRooms, category) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Try to connect to the database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // Prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // Set parameters for the new hotel
//            stmt.setInt(1, hotel.getChainId());
            stmt.setString(1, hotel.getCity());
            stmt.setString(2, hotel.getName());
            stmt.setString(3, hotel.getEmail());
            stmt.setString(4, hotel.getPhone());
            stmt.setString(5,hotel.getStreet());
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
        String sql = "UPDATE hotelchain.hotel SET  chainId=?, city=?, name=?, email=?, phone=?, street=? ,numOfRooms=?, category=? WHERE hotelId=?";

        // Try to connect to the database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // Prepare the statement
            System.out.println("Preparing statement...");
            PreparedStatement stmt = con.prepareStatement(sql);

            // Set parameters for the updated hotel
            stmt.setInt(1, hotel.getChainId());
            stmt.setString(2, hotel.getCity());
            stmt.setString(3, hotel.getName());
            stmt.setString(4, hotel.getEmail());
            stmt.setString(5, hotel.getPhone());
            stmt.setString(6, hotel.getStreet());
            stmt.setInt(7, hotel.getNumOfRooms());
            stmt.setString(8, hotel.getCategory());
            stmt.setInt(9, hotel.getHotelId()); // Add this line

            // Execute the query
            System.out.println("Executing update query...");
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            // Check if any rows were affected
            if (rowsAffected == 1) {
                message = "Hotel successfully updated!";
            } else {
                message = "Failed to update hotel.";
            }

            // Close the statement
            System.out.println("Closing statement...");
            stmt.close();
        } catch (Exception e) {
            System.err.println("Error while updating hotel: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
            message = "Error while updating hotel: " + e.getMessage();
        } finally {
            // Close the database connection
            db.close();
        }

        return message;
    }
}
