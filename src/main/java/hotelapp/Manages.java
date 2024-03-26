package hotelapp;

public class Manages {
    private int hoteld;
    private int essn;

    public Manages(){

    }

    public Manages(int hoteld, int essn){
        this.hoteld = hoteld;
        this.essn = essn;
    }

    // Getters and Setters
    public int gethoteld(){
        return hoteld;
    }

    public void sethoteld(int hoteld){
        this.hoteld = hoteld;
    }

    public int getEssn(){
        return essn;
    }

    public void setEssn(int essn){
        this.essn = essn;
    }
}
