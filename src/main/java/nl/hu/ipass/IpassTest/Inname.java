package nl.hu.ipass.IpassTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;

public class Inname {
    private LocalDate date;
    private Time time;
    private double dosis;
    private Medicatie medicatie;

    public Inname(Time tim, double dos, Medicatie med){
    this.time = tim;
    this.dosis = dos;
    this.medicatie = med;
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
    public Time getTime() {
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
