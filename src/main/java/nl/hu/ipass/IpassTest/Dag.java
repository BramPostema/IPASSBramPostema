package nl.hu.ipass.IpassTest;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Dag{
    private ArrayList<String> bijwerkingen;
    private String extraInformatie;
    private LocalDate datum;
    private ArrayList<Inname> innames;



    public Dag(ArrayList<String> bijw, String extInf, LocalDate dat){
        this.bijwerkingen = bijw;
        this.datum = dat;
        this.extraInformatie = extInf;

    }

    public ArrayList<String> getBijwerkingen() {
        return bijwerkingen;
    }

    public String getExtraInformatie() {
        return extraInformatie;
    }

    public LocalDate getDatum() {
        return datum;
    }


    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setBijwerkingen(ArrayList<String> bijwerkingen) {
        this.bijwerkingen = bijwerkingen;
    }


    public void setExtraInformatie(String extraInformatie) {
        if(this.datum.equals(LocalDate.now())){
        this.extraInformatie = extraInformatie;
        }else{
            System.out.println("De informatie is niet aangepast, omdat het alleen op de zelfde dag aangepast kan worden");
//            throw new Error("De informatie kan alleen op de dag aangepast worden");
        }
    }

    public void addInname(Inname inname) {
        innames.add(inname);
    }

    public ArrayList<Inname> getInnames() {
        return innames;
    }

    @Override
    public String toString() {
        return "Dag{" +

                ", bijwerkingen=" + bijwerkingen +
                ", extraInformatie='" + extraInformatie + '\'' +
                ", datum=" + datum +

                '}';
    }
}
