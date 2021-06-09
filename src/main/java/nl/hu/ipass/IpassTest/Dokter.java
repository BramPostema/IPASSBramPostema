package nl.hu.ipass.IpassTest;

import java.sql.*;
import java.util.ArrayList;

public class Dokter {
    private String gebruikersnaam; //UID
    public Dokter(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }
    public boolean isValid(){
        //TODO kijk of this.gebruikersnaam ook echt in de table van dokters staat
        try {
            Connection con = DatabaseCon.getConn();
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select count(gebruikersnaam) from Dokter where gebruikersnaam='"+this.gebruikersnaam+"'");
            return res.getInt(1)==1;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }
    public static Dokter getDokter(String naam) {
        Dokter newDokter = new Dokter(naam);
        if (newDokter.isValid()) {
            return newDokter;
        } else {
            return null;
        }
    }
    public static ArrayList<Dokter> getDokters(){
        //TODO query geef usernames van alle dokters
        try {
            ArrayList<Dokter> dokters= new ArrayList<>();
            Connection con = DatabaseCon.getConn();
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Dokter");
            while (res.next()) {
                dokters.add(new Dokter(res.getString(1)));
            }
            return dokters;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static Dokter addDokter(String gebruikersnaam, String wachtwoord, String email){
        String query = "INSERT INTO Dokter(gebruikersnaam, wachtwoord, email) values('"+gebruikersnaam+"', '"+wachtwoord+"','"+email+"')";
        try{
            Connection con = DatabaseCon.getConn();
            Statement statement = con.createStatement();
            statement.executeUpdate(query);
            return new Dokter(gebruikersnaam);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public String getWachtwoord() {
        String query = "SELECT wachtwoord FROM Dokter WHERE gebruikersnaam='"+this.gebruikersnaam+"'";
        try {
            Connection con = DatabaseCon.getConn();
            Statement statement = con.createStatement();
            return statement.executeQuery(query).getString(1);
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }


    public void setWachtwoord(String wachtwoord) {
        //TODO: query
        //.wachtwoord = wachtwoord;
    }

    public String getEmail() {
        String query = "SELECT email FROM Dokter WHERE gebruikersnaam='"+this.gebruikersnaam+"'";
        try {
            Connection con = DatabaseCon.getConn();
            Statement statement = con.createStatement();
            return statement.executeQuery(query).getString(1);
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public void setEmail(String email) {
        String query = "UPDATE Dokter SET email = '"+email+"' where gebruikersnaam = '"+gebruikersnaam+"' ";
        try {
            Connection con = DatabaseCon.getConn();
            Statement statement = con.createStatement();
            statement.executeQuery(query);
        }
        catch (SQLException e){
            System.out.println(e);

        }
        //TODO
    }

//    public Patiënt getPatient(){
//        // query met this.gebruikersnaam om patient te vinden
//
//    }

//    public void addPatiënt(Patiënt patiënt) {
//        //patiënts.add(patiënt);
//    }
//
//    public ArrayList<Patiënt> getPatiënts() {
//        return patiënts;
//    }

    @Override
    public String toString() {
        return "Dokter{" + this.gebruikersnaam+ this.getWachtwoord() + this.getEmail();
//                "gebruikersnaam='" + this.gebruikersnaam + '\'' +
//                ", wachtwoord='" + this.getWachtwoord() + '\'' +
//                ", email='" + this.getEmail() + '\'' +
//                ", patiënts=" +
//                '}';
    }
}
