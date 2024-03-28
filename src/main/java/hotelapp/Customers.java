package hotelapp;
import java.util.Date;

public class Customers {
    private int customerId;
    private String fname;
    private String lname;
    private String address;
    private Integer registrationDate;

    // Constructors
    public Customers() {
    }

    public Customers(int customerId, String fname, String lname, String address, Integer registrationDate) {
        this.customerId = customerId;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getfname() {
        return fname;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public String getlname() {
        return lname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Integer registrationDate) {
        this.registrationDate = registrationDate;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
