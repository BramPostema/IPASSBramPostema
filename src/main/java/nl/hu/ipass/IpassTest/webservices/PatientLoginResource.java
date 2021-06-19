package nl.hu.ipass.IpassTest.webservices;

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
    public boolean inlogGet(String jsonBody){
        StringReader strReader = new StringReader(jsonBody);
        JsonReader jsonReader = Json.createReader(strReader);
        JsonObject jsonObject = jsonReader.readObject();
        String gebn = jsonObject.getString("gebruikersnaam");
        String ww =jsonObject.getString("wachtwoord");
        System.out.println(gebn);
        System.out.println(ww);
        return true;
    }
}
