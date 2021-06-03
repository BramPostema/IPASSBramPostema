package nl.hu.ipass.IpassTest;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] arg) {
//        String zoekNaam = "Isa Bergen";
//        Dokter Klaas = new Dokter("Klaas de Boer", "123", "klaasdeboer@gmail.com");
//        System.out.println(Klaas);
//        Patiënt Isa = new Patiënt("Isa Bergen", "441", "isa.bergen@gmail.com");
//        System.out.println(Isa);
//        LocalTime localTime = LocalTime.now();
//        LocalDate date = LocalDate.now();
//        Time time = Time.valueOf(localTime);
//        Medicatie methylfenidaat = new Medicatie("Methylfenidaat");
//        ArrayList<String> medicatielijst = new ArrayList<String>();
//        medicatielijst.add("Hoofdpijn");
//        medicatielijst.add("Geen Honger");
//        medicatielijst.add("hartkloppingen");
//        Dag Isa20052021 = new Dag(medicatielijst, "Heb deze dag wel weinig gedronken",  date, Isa);
//        Dag Isa23052021 = new Dag(medicatielijst, "Heb deze dag wel weinig gedronken",  date, Isa);
//        Dag Isa24052021 = new Dag(medicatielijst, "Heb deze dag wel weinig gedronken",  LocalDate.parse("2021-05-23"), Isa);
//        Inname ochtend24052021= new Inname(LocalDate.parse("2021-05-24"), time,7.5, methylfenidaat);
//        Inname middag24052021= new Inname(LocalDate.parse("2021-05-24"), time,10.0, methylfenidaat);
//        Isa24052021.addInname(ochtend24052021);
//        Isa24052021.addInname(middag24052021);
//        Isa24052021.setExtraInformatie("Ik was erg moe deze dag");
//        Isa20052021.setExtraInformatie("dit is een test");
//
//        Isa24052021.setExtraInformatie("dit is een test");
//        System.out.println(Isa24052021.getExtraInformatie());
//        if(Isa20052021.getPatiënt().getGebruikersnaam()==zoekNaam) {
//            Isa.addPatiëntDagen(Isa20052021);
//        }
//        if(Isa23052021.getPatiënt().getGebruikersnaam()==zoekNaam) {
//            Isa.addPatiëntDagen(Isa23052021);
//        }
//        if(Isa24052021.getPatiënt().getGebruikersnaam()==zoekNaam) {
//            Isa.addPatiëntDagen(Isa24052021);
//        }
//        Klaas.addPatiënts(Isa);
////        int c;
////        for (c=0; c<Isa.getPatiëntDagen().size(); c++) {
////            System.out.println(Isa.getPatiëntDagen().get(c));
////            System.out.println(Isa.getPatiëntDagen().get(c).getInnames());
////        }
////        for (Dag dag : Isa.getPatiëntDagen()) {
////            System.out.println(dag);
////            System.out.println(dag.getInnames());
////        }
//
//        for (Dag dag : Klaas.getPatiënts().get(0).getPatiëntDagen()) {
//            System.out.println(dag);
//            System.out.println(dag.getInnames());
//        }
//    }
        ArrayList<Inname> Inna = new ArrayList<>();
        ArrayList<String> bijwerkingen = new ArrayList<>();

        LocalDate date = LocalDate.now();
        Dag dag = new Dag(bijwerkingen, "", date);
        System.out.println(dag);
    }
}
