package nl.hu.ipass.IpassTest;

import java.util.ArrayList;
import java.util.Date;

public class Patiënt {
    private String gebruikersnaam;
    private String wachtwoord;
    private String email;
    private Dokter dokter;
    //private ArrayList<Dag> patiëntDagen= new ArrayList<>();
    public Patiënt(String nm, String ww, String mail) {
        this.gebruikersnaam = nm;
        this.wachtwoord = ww;
        this.email = mail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void addPatiëntDagen(Dag dag) {
        //patiëntDagen.add(dag);
        //TODO query
    }

//    public ArrayList<Dag> getPatiëntDagen() {
//        return patiëntDagen;
//    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    @Override
    public String toString() {
        return "Patiënt{" +
                "gebruikersnaam='" + gebruikersnaam + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                ", email='" + email + '\'' +
                ", dokter=" + dokter +
                ", patiëntDagen=" + '}';
    }
}
