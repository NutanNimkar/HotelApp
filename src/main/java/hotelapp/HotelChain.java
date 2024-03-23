package hotelapp;

public class HotelChain {
    private int chainId;        // Primary key
    private String name;
    private String email;
    private int numOfHotels;
    private String coAddress;
    private String phone;

    // Constructors
    public HotelChain() {
    }

    public HotelChain(int chainId, String name, String email, int numOfHotels, String coAddress, String phone) {
        this.chainId = chainId;
        this.name = name;
        this.email = email;
        this.numOfHotels = numOfHotels;
        this.coAddress = coAddress;
        this.phone = phone;
    }

    // Getters and Setters
    public int getChainId() {
        return chainId;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
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

    public int getNumOfHotels() {
        return numOfHotels;
    }

    public void setNumOfHotels(int numOfHotels) {
        this.numOfHotels = numOfHotels;
    }

    public String getCoAddress() {
        return coAddress;
    }

    public void setCoAddress(String coAddress) {
        this.coAddress = coAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "HotelChain{" +
                "chainId=" + chainId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", numOfHotels=" + numOfHotels +
                ", coAddress='" + coAddress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
