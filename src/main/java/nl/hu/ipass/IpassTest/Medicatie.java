package nl.hu.ipass.IpassTest;

public class Medicatie {
    private String naam;
    public Medicatie(String nm){
        this.naam = nm;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        return naam ;

    }
}
