package nl.hu.ipass.IpassTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Patiënt {
    private String gebruikersnaam;
    private String wachtwoord;
    private String email;
    private Dokter dokter;
//    private String role = "patiënt";
    //private ArrayList<Dag> patiëntDagen= new ArrayList<>();
    public Patiënt(String nm, String ww, String mail) {
        this.gebruikersnaam = nm;
        this.wachtwoord = ww;
        this.email = mail;
    }
    public static Patiënt addPatient(String gebruikersnaam, String wachtwoord, String email){
        String query = "INSERT INTO Patiënt(gebruikersnaam, wachtwoord, email) values('"+gebruikersnaam+"', '"+wachtwoord+"','"+email+"')";
        try{
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            statement.executeUpdate(query);
            return new Patiënt(gebruikersnaam, wachtwoord, email);
        }
        catch(SQLException e){
            System.out.println(e);
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean isValid(){
        //TODO kijk of this.gebruikersnaam ook echt in de table van dokters staat
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select count(gebruikersnaam) from Patiënt where gebruikersnaam='"+this.gebruikersnaam+"'");
            return res.getInt(1)==1;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }
    public static Patiënt getPatient(String naam) {
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            Statement statement1 = con.createStatement();
            ResultSet res = statement.executeQuery("select count(gebruikersnaam) from Patiënt where gebruikersnaam='"+naam+"'");
            if(res.getInt(1)==1){
                ResultSet resultSet = statement1.executeQuery(("select gebruikersnaam, wachtwoord, email FROM Patiënt WHERE gebruikersnaam='"+naam+"'"));
                Patiënt newPatient = new Patiënt(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                System.out.println(newPatient);
                return newPatient;
            }
            return null;
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
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



    public boolean validateInlog(String gebruikersnaamInvoer, String wachtwoordInvoer){
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select gebruikersnaam, wachtwoord from Patiënt where gebruikersnaam='"+this.gebruikersnaam+"'");
            System.out.println(res);
            System.out.println(res.getString(1)+res.getString(2));
            if(res.getString(1)==gebruikersnaamInvoer && res.getString(2)==wachtwoordInvoer){
                return true;
            }else {
                return false;
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }
    public String getWachtwoord() {
        return wachtwoord;
    }
    public String getEmail() {
        return email;
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
