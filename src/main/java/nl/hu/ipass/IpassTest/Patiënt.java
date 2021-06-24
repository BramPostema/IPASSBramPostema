package nl.hu.ipass.IpassTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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
            return null;
        }
    }

    public static boolean isValid(String gebruikersnaam){
        //TODO kijk of this.gebruikersnaam ook echt in de table van dokters staat
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select count(gebruikersnaam) from Patiënt where gebruikersnaam='"+gebruikersnaam+"'");
            res.next();
            return res.getInt(1)==1;
        }
        catch (SQLException ignored){
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
                ResultSet resultSet = statement1.executeQuery("select gebruikersnaam, wachtwoord, email FROM Patiënt WHERE gebruikersnaam='"+naam+"'");
                return new Patiënt(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
            }
            return null;
        }
        catch (SQLException ignored){
            return null;
        }

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public static ArrayList<Dag> getDagen(String patientNaam) {
        ArrayList<Dag> dagen = new ArrayList<>();
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Dag WHERE Patiëntgebruikersnaam='" + patientNaam + "'");
            while (resultSet.next()) {
                ArrayList<String> bijwerkingen = new ArrayList<>();
                bijwerkingen.add(resultSet.getString(3));
                bijwerkingen.add(resultSet.getString(4));
                bijwerkingen.add(resultSet.getString(5));
                dagen.add(new Dag(bijwerkingen, resultSet.getString(2), LocalDate.parse(resultSet.getString(1))));
            }
            return dagen;
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
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

    public static String getWachtwoordDatabase(String gebruikersnaam) {
        String query = "SELECT wachtwoord FROM Patiënt WHERE gebruikersnaam='"+gebruikersnaam+"'";
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            if(isValid(gebruikersnaam)){
                ResultSet res =  statement.executeQuery(query);
                res.next();
                return res.getString(1);
            }
            else {
                throw new SQLException("Gebruiker bestaat niet!");
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static String getEmailDatabase(String gebruikersnaam) {
        String query = "SELECT email FROM Patiënt WHERE gebruikersnaam='"+gebruikersnaam+"'";
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            return statement.executeQuery(query).getString(1);
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }
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
