package hotelapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public List<Customers> getCustomers() throws Exception {
        String sql = "SELECT * FROM hotelchain.customer";
        ConnectionDB db = new ConnectionDB();
        List<Customers> customers = new ArrayList<>();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customers customer = new Customers(
                        rs.getInt("customerId"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("address"),
                        rs.getInt("registrationDate")
                );
                customers.add(customer);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return customers;
    }

    public void addCustomer(Customers customer) throws Exception {
        String sql = "INSERT INTO hotelchain.customer (fname, lname, address) VALUES (?, ?, ?)";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, customer.getfname());
            stmt.setString(2, customer.getlname());
            stmt.setString(3, customer.getAddress());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteCustomer(int customerId) throws Exception {
        String sql = "DELETE FROM hotelchain.customer WHERE customerId = ?";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, customerId);

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateCustomer(Customers customer) throws Exception {
        String sql = "UPDATE hotelchain.customer SET fname = ?, lname = ?, address = ? WHERE customerId = ?";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, customer.getfname());
            stmt.setString(2, customer.getlname());
            stmt.setString(3, customer.getAddress());
            stmt.setInt(4, customer.getCustomerId());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
