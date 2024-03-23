package hotelapp;

public class Hotel {
    private Integer hotelId;
    private int chainId;
    private String city;

    private String name;
    private String email;
    private int numOfRooms;
    private String phone;
    private String category;
    public Hotel() {
    }

    public Hotel(int hotelId, int chainId, String city, String name, String email, String phone, int numOfRooms, String category) {
        this.hotelId = hotelId;
        this.chainId = chainId;
        this.city = city;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.numOfRooms = numOfRooms;
        this.category = category;
    }

    // Getters and Setters
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getChainId() {
        return chainId;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", chainId=" + chainId +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", numOfRooms=" + numOfRooms +
                ", category='" + category + '\'' +
                '}';
    }
}

