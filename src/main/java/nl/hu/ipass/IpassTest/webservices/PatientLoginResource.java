package nl.hu.ipass.IpassTest.webservices;

import nl.hu.ipass.IpassTest.Patiënt;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.ArrayList;

@Path("patientlogin")

public class PatientLoginResource {
    @POST
    public Response inlogGet(String jsonBody){
        StringReader strReader = new StringReader(jsonBody);
        JsonReader jsonReader = Json.createReader(strReader);
        JsonObject jsonObject = jsonReader.readObject();
        String gebruikersnaam = jsonObject.getString("gebruikersnaam");
        String wachtwoord =jsonObject.getString("wachtwoord");
        System.out.println(gebruikersnaam);
        System.out.println(wachtwoord);
        String wachtwoordDatabase = Patiënt.getWachtwoordDatabase(gebruikersnaam);
        System.out.println(wachtwoordDatabase);
        System.out.println(wachtwoord.hashCode());
        if(wachtwoordDatabase!=null) {
            System.out.println(wachtwoordDatabase.hashCode());
        }
        if(wachtwoordDatabase!=null && wachtwoordDatabase.hashCode() == wachtwoord.hashCode()) {
            return Response.ok(true).build();
        }else {
            return Response.ok(false).build();
        }
    }
}
