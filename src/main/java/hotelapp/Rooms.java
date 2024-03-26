package hotelapp;

public class Rooms {
    private int roomId;
    private int hotelId;
    private boolean seaView;
    private boolean mountainView;
    private String amenities;
    private boolean isSingle;
    private boolean isExtended;
    private String problems;

    // Constructors
    public Rooms() {
    }

    public Rooms(int roomId, int hotelId, boolean seaView, boolean mountainView, String amenities, boolean isSingle, boolean isExtended, String problems) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.seaView = seaView;
        this.mountainView = mountainView;
        this.amenities = amenities;
        this.isSingle = isSingle;
        this.isExtended = isExtended;
        this.problems = problems;
    }

    // Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public boolean isMountainView() {
        return mountainView;
    }

    public void setMountainView(boolean mountainView) {
        this.mountainView = mountainView;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public boolean isExtended() {
        return isExtended;
    }

    public void setExtended(boolean extended) {
        isExtended = extended;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", hotelId=" + hotelId +
                ", seaView=" + seaView +
                ", mountainView=" + mountainView +
                ", amenities='" + amenities + '\'' +
                ", isSingle=" + isSingle +
                ", isExtended=" + isExtended +
                ", problems='" + problems + '\'' +
                '}';
    }
}
