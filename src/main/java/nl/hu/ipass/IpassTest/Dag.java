package nl.hu.ipass.IpassTest;

import javax.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class Dag{
    private ArrayList<String> bijwerkingen;
    private String extraInformatie;
    private LocalDate datum;
    private ArrayList<Inname> innames = new ArrayList<>();




    public Dag(ArrayList<String> bijw, String extInf, LocalDate dat){
        this.bijwerkingen = bijw;
        this.datum = dat;
        this.extraInformatie = extInf;
    }
    public static Dag addDag(Dag dag, String gebruikersnaam){
        String query = "INSERT INTO Dag(datum, notitie, bijwerking1, bijwerking2, bijwerking3, Patiëntgebruikersnaam) values('"+dag.datum+"', '"+dag.extraInformatie+"','"+dag.bijwerkingen.get(0)+"','"+dag.bijwerkingen.get(1)+"','"+dag.bijwerkingen.get(2)+"','"+gebruikersnaam+"')";
        try{
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            statement.executeUpdate(query);
            return dag;
        }
        catch(SQLException e){
            System.out.println(e);
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static String getNotitie(Date datum){
        String query = "SELECT notitie FROM Dag WHERE datum='"+datum+"'";
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
    public static ArrayList<String> getBijwerkingen(Date datum, String gebruikersnaam){
        String query = "SELECT bijwerking1, bijwerking2, bijwerking3 FROM Dag WHERE datum='"+datum+"' AND Patiëntgebruikersnaam='"+gebruikersnaam+"'";
        ArrayList<String> bijwerkingen = new ArrayList<>();
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            bijwerkingen.add(resultSet.getString(1));
            bijwerkingen.add(resultSet.getString(2));
            bijwerkingen.add(resultSet.getString(3));
            return bijwerkingen;
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }
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
        return  " bijwerkingen=" + bijwerkingen +
                ", extraInformatie='" + extraInformatie + '\'' +
                ", datum=" + datum ;
    }
}
