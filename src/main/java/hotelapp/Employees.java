package hotelapp;

public class Employees {
    private int ssn;
    private String role;
    private String fname;
    private String lname;
    private String street;
    private String city;
    private int mssn; // Assuming this is the manager's SSN
    private int hotelId;

    // Constructors
    public Employees() {
    }

    public Employees(int ssn, String role, String fname, String lname, String street, String city, int managerSsn, int hotelId) {
        this.ssn = ssn;
        this.role = role;
        this.fname = fname;
        this.lname = lname;
        this.street = street;
        this.city = city;
        this.mssn = mssn;
        this.hotelId = hotelId;
    }

    // Getters and Setters
    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getManagerSsn() {
        return mssn;
    }

    public void setManagerSsn(int mssn) {
        this.mssn = mssn;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Employee{" +
                "ssn=" + ssn +
                ", role='" + role + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", managerSsn=" + mssn +
                ", hotelId=" + hotelId +
                '}';
    }
}
