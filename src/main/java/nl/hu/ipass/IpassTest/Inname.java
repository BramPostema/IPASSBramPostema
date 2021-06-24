package nl.hu.ipass.IpassTest;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Inname {
    private LocalDate date;
    private LocalTime time;
    private double dosis;
    private Medicatie medicatie;

    public Inname(LocalTime tim, double dos, Medicatie med, LocalDate date){
    this.time = tim;
    this.dosis = dos;
    this.medicatie = med;
    this.date = date;
    }
    public static Inname addInname(Inname inname, String gebruikersnaam){
        String query = "INSERT INTO Inname(tijd, Dagdatum, dosis, Medicatienaam, Patiëntnaam) values('"+inname.time+"', '"+inname.date+"','"+inname.dosis+"','"+inname.medicatie+"','"+gebruikersnaam+"')";
        try{
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            statement.executeUpdate(query);
            return inname;
        }
        catch(SQLException e){
            System.out.println(e);
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ArrayList<Inname> getInnames(String gebruikersnaam, String datum){
        ArrayList<Inname> innames = new ArrayList<>();
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inname WHERE patiëntnaam='"+gebruikersnaam +"' AND dagdatum= '"+datum+"'");
            while (resultSet.next()) {
                innames.add(new Inname(LocalTime.parse(resultSet.getString(1)), resultSet.getDouble(3), new Medicatie(resultSet.getString(4)), LocalDate.parse(resultSet.getString(2))));
            }
            return innames;
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public LocalTime getTime() {
        return time;
    }

    public double getDosis() {
        return dosis;
    }

    public LocalDate getDate() {
        return date;
    }

    public Medicatie getMedicatie(){return medicatie;}

    @Override
    public String toString() {
        return "Inname{" +
                ", date=" + date +
                ", time=" + time +
                ",  dosis=" + dosis +
                ",  medicatie=" + medicatie +
                "}";
    }
}
