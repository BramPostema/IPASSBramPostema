package nl.hu.ipass.IpassTest.webservices;

import nl.hu.ipass.IpassTest.Patiënt;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;

@Path("patientlogin")

public class PatientLoginResource {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response inlogGet(String jsonBody){
        StringReader strReader = new StringReader(jsonBody);
        JsonReader jsonReader = Json.createReader(strReader);
        JsonObject jsonObject = jsonReader.readObject();
        String gebruikersnaam = jsonObject.getString("gebruikersnaam");
        String wachtwoord =jsonObject.getString("wachtwoord");
        System.out.println("invoer: "+gebruikersnaam);
        System.out.println("invoer: "+wachtwoord);
        if(Patiënt.isValid(gebruikersnaam)){
            if(Patiënt.getWachtwoordDatabase(gebruikersnaam).hashCode() == wachtwoord.hashCode()){
                return Response.ok("true").build();
            }else {
                return Response.ok("false").build();
            }
        }else {
            return Response.ok("false").build();
        }
    }
}
