package nl.hu.ipass.IpassTest.webservices;

import nl.hu.ipass.IpassTest.Dokter;
import nl.hu.ipass.IpassTest.Patiënt;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.StringReader;

@Path("patient")
public class PatiëntResource {
    @POST
    @Produces("application/json")
    public void maakPatientService(String jsonBody){
        JsonObjectBuilder responseObject = Json.createObjectBuilder();
        try{
            StringReader strReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(strReader);
            JsonObject jsonObject = jsonReader.readObject();
            String naam = jsonObject.getString("gebruikersnaam");
            String wachtwoord = jsonObject.getString("wachtwoord");
            String email = jsonObject.getString("email");
            System.out.println(naam);
            System.out.println(wachtwoord);
            System.out.println(email);
            if(Patiënt.addPatient(naam, wachtwoord, email)!=null){
                responseObject.add("message", "het ging goed");
            }
            else {
                throw new Exception("Niet alles is ingevuld");
            }

        }catch (Exception e){
            System.out.println(e);
            responseObject.add("message", "Error: "+e.getMessage());
        }

    }
}
