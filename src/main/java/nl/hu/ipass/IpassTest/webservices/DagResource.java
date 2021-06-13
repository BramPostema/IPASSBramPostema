package nl.hu.ipass.IpassTest.webservices;

import nl.hu.ipass.IpassTest.Dag;
import nl.hu.ipass.IpassTest.Dokter;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

@Path("/dag")
public class DagResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String doGet() {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        if(Dokter.getDokters() != null){
            for(Dokter dokter: Dokter.getDokters()){
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
                objectBuilder.add("gebruikersnaam", dokter.getGebruikersnaam());
                objectBuilder.add("wachtwoord", dokter.getEmail());
                objectBuilder.add("email", dokter.getEmail());
                arrayBuilder.add(objectBuilder);
            }}
        JsonArray array = arrayBuilder.build();
        return array.toString();

    }
    @POST
    @Path("{test}")
    public void maakDag(@PathParam("test") String gebruikersnaam, String jsonBody){
        System.out.println(gebruikersnaam);
        JsonObjectBuilder responseObject = Json.createObjectBuilder();
        try{
            StringReader strReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(strReader);
            JsonObject jsonObject = jsonReader.readObject();
            if (jsonObject.getString("bijwerking1")!=null && jsonObject.getString("bijwerking2")!=null &&
                jsonObject.getString("bijwerking3")!=null && jsonObject.getString("notitie")!=null &&
                jsonObject.getString("datum")!=null) {

                String bijwerking1 = jsonObject.getString("bijwerking1");
                String bijwerking2 = jsonObject.getString("bijwerking2");
                String bijwerking3 = jsonObject.getString("bijwerking3");
                LocalDate date = LocalDate.parse(jsonObject.getString("datum"));
                String notitie = jsonObject.getString("notitie");
                ArrayList<String> bijwerkingen = new ArrayList<>();
                bijwerkingen.add(bijwerking1);
                bijwerkingen.add(bijwerking2);
                bijwerkingen.add(bijwerking3);
                Dag dag = new Dag(bijwerkingen, notitie, date);
                Dag.addDag(dag, gebruikersnaam);

            }
        }catch (Exception e){
            System.out.println(e);
            responseObject.add("message", "Error: "+e.getMessage());
        }

    }
}
