package hotelapp;
import java.util.Date;

public class Renting {
    private int bookingId;
    private int customerId;
    private int roomId;
    private int essn;
    private Date checkInDate;
    private Date checkOutDate;

    // Constructors
    public Renting() {
    }

    public Renting(int bookingId, int customerId, int roomId, int essn, Date checkInDate, Date checkOutDate) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.essn = essn;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getEssn() {
        return essn;
    }

    public void setEssn(int essn) {
        this.essn = essn;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Renting{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", roomId=" + roomId +
                ", essn=" + essn +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
