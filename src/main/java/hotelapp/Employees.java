package hotelapp;

public class Employees {
    private int ssn;
    private String role;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private int managerSsn; // Assuming this is the manager's SSN
    private int hotelId;

    // Constructors
    public Employees() {
    }

    public Employees(int ssn, String role, String firstName, String lastName, String street, String city, int managerSsn, int hotelId) {
        this.ssn = ssn;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.managerSsn = managerSsn;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return managerSsn;
    }

    public void setManagerSsn(int managerSsn) {
        this.managerSsn = managerSsn;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", managerSsn=" + managerSsn +
                ", hotelId=" + hotelId +
                '}';
    }
}
