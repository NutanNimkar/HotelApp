package hotelapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeesService {

    public List<Employees> getEmployees() throws Exception {
        String sql = "SELECT * FROM hotelchain.employees";
        ConnectionDB db = new ConnectionDB();
        List<Employees> employees = new ArrayList<>();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Employees employee = new Employees(
                        rs.getInt("ssn"),
                        rs.getString("role"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getInt("mssn"),
                        rs.getInt("hotelId")
                );
                employees.add(employee);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return employees;
    }

    public void addEmployee(Employees employee) throws Exception {
        String sql = "INSERT INTO hotelchain.employees (ssn, role, fname, lname, street, city, mssn, hotelId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, employee.getSsn());
            stmt.setString(2, employee.getRole());
            stmt.setString(3, employee.getfname());
            stmt.setString(4, employee.getlname());
            stmt.setString(5, employee.getStreet());
            stmt.setString(6, employee.getCity());
            stmt.setInt(7, employee.getManagerSsn());
            stmt.setInt(8, employee.getHotelId());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteEmployee(int ssn) throws Exception {
        String sql = "DELETE FROM hotelchain.employees WHERE ssn = ?";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, ssn);

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateEmployee(Employees employee) throws Exception {
        String sql = "UPDATE hotelchain.employees SET role = ?, fname = ?, lname = ?, street = ?, city = ?, mssn = ?, hotelId = ? WHERE ssn = ?";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, employee.getRole());
            stmt.setString(2, employee.getfname());
            stmt.setString(3, employee.getlname());
            stmt.setString(4, employee.getStreet());
            stmt.setString(5, employee.getCity());
            stmt.setInt(6, employee.getManagerSsn());
            stmt.setInt(7, employee.getHotelId());
            stmt.setInt(8, employee.getSsn());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
