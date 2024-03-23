package hotelapp;

public class Makes {
    private int bookingId;
    private int essn;

    public Makes(){

    }

    public Makes(int bookingId, int essn){
        this.bookingId = bookingId;
        this.essn = essn;
    }

    // Getters and Setters
    public int getBookingID(){
        return bookingId;
    }

    public void setBookingID(int bookingId){
        this.bookingId = bookingId;
    }

    public int getEssn(){
        return essn;
    }

    public void setEssn(int essn){
        this.essn = essn;
    }
}
