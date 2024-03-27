package hotelapp;

public class Position {
    private int positionId;
    private int essn;

    private String title;

    public Position(){

    }

    public Position(int positionId, int essn, String title){
        this.positionId = positionId;
        this.essn = essn;
        this.title = title;
    }

    // Getters and Setters
    public int getpositionId(){
        return positionId;
    }

    public void setpositionId(int positionId){
        this.positionId = positionId;
    }

    public int getEssn(){
        return essn;
    }

    public void setEssn(int essn){
        this.essn = essn;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
}
