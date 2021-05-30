package nl.hu.ipass.IpassTest;

public class Medicatie {
    private String naam;
    public Medicatie(String nm){
        this.naam = nm;
    }

    @Override
    public String toString() {
        return ""+ naam ;

    }
}
