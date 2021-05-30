package nl.hu.ipass.IpassTest;

import java.util.ArrayList;

public class Dokter {
    private String gebruikersnaam;
    private String wachtwoord;
    private String email;
    private ArrayList<Patiënt> patiënts = new ArrayList<>();
    public Dokter(String nm, String ww, String mail) {
        this.gebruikersnaam = nm;
        this.wachtwoord = ww;
        this.email = mail;
    }


    public String getWachtwoord() {
        return wachtwoord;
    }
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }
    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void addPatiënts(Patiënt patiënt) {
        patiënts.add(patiënt);
    }

    public ArrayList<Patiënt> getPatiënts() {
        return patiënts;
    }

    @Override
    public String toString() {
        return "Dokter{" +
                "gebruikersnaam='" + gebruikersnaam + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                ", email='" + email + '\'' +
                ", patiënts=" + patiënts +
                '}';
    }
}
