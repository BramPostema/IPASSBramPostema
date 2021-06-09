package nl.hu.ipass.IpassTest;

import javax.servlet.annotation.WebServlet;

import java.time.LocalDate;
import java.util.ArrayList;


import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;



public class Dag{
    private String bijwerking1;
    private String extraInformatie;
    private LocalDate datum;
    private ArrayList<Inname> innames = new ArrayList<>();




    public Dag(String bijw, String extInf, LocalDate dat){
        this.bijwerking1 = bijw;
        this.datum = dat;
        this.extraInformatie = extInf;
    }

    public String getBijwerkingen() {
        return bijwerking1;
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

    public void setBijwerkingen(String bijwerkingen) {
        this.bijwerking1 = bijwerkingen;
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
        return  " bijwerkingen=" + bijwerking1 +
                ", extraInformatie='" + extraInformatie + '\'' +
                ", datum=" + datum ;
    }
}
