package hotelapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomsService {

    public List<Rooms> getRooms() throws Exception {
        String sql = "SELECT * FROM \"Hotel\".rooms";
        ConnectionDB db = new ConnectionDB();
        List<Rooms> rooms = new ArrayList<>();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Rooms room = new Rooms(
                        rs.getInt("roomId"),
                        rs.getInt("hotelId"),
                        rs.getBoolean("seaView"),
                        rs.getBoolean("mountainView"),
                        rs.getString("amenties"),
                        rs.getBoolean("isSingle"),
                        rs.getBoolean("isExtended"),
                        rs.getString("problems")
                );
                rooms.add(room);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return rooms;
    }

    public void addRoom(Rooms room) throws Exception {
        String sql = "INSERT INTO hotelchain.rooms (roomId, hotelId, seaView, mountainView, amenities, isSingle, isExtended, problems) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, room.getRoomId());
            stmt.setInt(2, room.getHotelId());
            stmt.setBoolean(3, room.isSeaView());
            stmt.setBoolean(4, room.isMountainView());
            stmt.setString(5, room.getAmenties());
            stmt.setBoolean(6, room.isSingle());
            stmt.setBoolean(7, room.isExtended());
            stmt.setString(8, room.getProblems());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteRoom(int roomId) throws Exception {
        String sql = "DELETE FROM hotelchain.rooms WHERE roomId = ?";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, roomId);

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateRoom(Rooms room) throws Exception {
        String sql = "UPDATE hotelchain.rooms SET hotelId = ?, seaView = ?, mountainView = ?, amenities = ?, isSingle = ?, isExtended = ?, problems = ? WHERE roomId = ?";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, room.getHotelId());
            stmt.setBoolean(2, room.isSeaView());
            stmt.setBoolean(3, room.isMountainView());
            stmt.setString(4, room.getAmenties());
            stmt.setBoolean(5, room.isSingle());
            stmt.setBoolean(6, room.isExtended());
            stmt.setString(7, room.getProblems());
            stmt.setInt(8, room.getRoomId());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
