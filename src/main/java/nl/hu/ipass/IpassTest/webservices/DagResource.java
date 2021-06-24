package nl.hu.ipass.IpassTest.webservices;

import nl.hu.ipass.IpassTest.Dag;
import nl.hu.ipass.IpassTest.Patiënt;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;

@Path("/dag")
public class DagResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{gebruikersnaam}")
    public String doGet(@PathParam("gebruikersnaam") String gebruikersnaam) {
        System.out.println("Get dag voor: "+gebruikersnaam);
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        ArrayList<Dag> dagen = Patiënt.getDagen(gebruikersnaam);
        for (Dag dag : dagen) {
            ArrayList<String> bijwerkingen = dag.getBijwerkingen();
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("datum", dag.getDatum().toString());
            objectBuilder.add("notitie", dag.getExtraInformatie());
            objectBuilder.add("bijwerking1", bijwerkingen.get(0));
            objectBuilder.add("bijwerking2", bijwerkingen.get(1));
            objectBuilder.add("bijwerking3", bijwerkingen.get(2));
            arrayBuilder.add(objectBuilder);
        }
        JsonArray array = arrayBuilder.build();
        return array.toString();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String doGet() {
        String gebruikersnaam = "klaas";
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        ArrayList<Dag> dagen = Patiënt.getDagen(gebruikersnaam);
        for (Dag dag : dagen) {
            ArrayList<String> bijwerkingen = dag.getBijwerkingen();
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("datum", dag.getDatum().toString());
            objectBuilder.add("notitie", dag.getExtraInformatie());
            objectBuilder.add("bijwerking1", bijwerkingen.get(0));
            objectBuilder.add("bijwerking2", bijwerkingen.get(1));
            objectBuilder.add("bijwerking3", bijwerkingen.get(2));
            arrayBuilder.add(objectBuilder);
        }
        JsonArray array = arrayBuilder.build();
        return array.toString();
    }
    @POST
    @Path("{test}")
    public void maakDag(@PathParam("test") String gebruikersnaam, String jsonBody){
        System.out.println("Maak dag voor: "+gebruikersnaam);
        JsonObjectBuilder responseObject = Json.createObjectBuilder();
        try{
            StringReader strReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(strReader);
            JsonObject jsonObject = jsonReader.readObject();
            if (jsonObject.getString("bijwerking1")!=null && jsonObject.getString("bijwerking2")!=null &&
                jsonObject.getString("bijwerking3")!=null && jsonObject.getString("notitie")!=null &&
                    !jsonObject.getString("datum").equals("")) {
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
