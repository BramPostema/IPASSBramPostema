package nl.hu.ipass.IpassTest.webservices;

import nl.hu.ipass.IpassTest.Dag;
import nl.hu.ipass.IpassTest.Patiënt;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;

@Path("/inname")
public class InnameResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{gebruikersnaam}")
    public String doGet(@PathParam("gebruikersnaam") String gebruikersnaam) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        ArrayList<Dag> dagen = Patiënt.getDagen(gebruikersnaam);
        for (Dag dag : dagen) {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("datum", Patiënt.getWachtwoordDatabase(gebruikersnaam));
            objectBuilder.add("medicatie", Patiënt.getEmailDatabase(gebruikersnaam));
            objectBuilder.add("tijd", dagen.toString());
            objectBuilder.add("dosis", dagen.toString());
            arrayBuilder.add(objectBuilder);
        }
        JsonArray array = arrayBuilder.build();
        return array.toString();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String doGet() {
//        String gebruikersnaam = "Isa";
//        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//        ArrayList<Dag> dagen = Patiënt.getDagen(gebruikersnaam);
//        for (Dag dag : dagen) {
//            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
//            objectBuilder.add("datum", Patiënt.getWachtwoordDatabase(gebruikersnaam));
//            objectBuilder.add("notitie", Patiënt.getEmailDatabase(gebruikersnaam));
//            objectBuilder.add("email", dagen.toString());
//            arrayBuilder.add(objectBuilder);
//        }
//        JsonArray array = arrayBuilder.build();
//        return array.toString();
//    }

    @POST
    @Path("{test}")
    public void maakInname(@PathParam("test") String gebruikersnaam, String jsonBody) {
        System.out.println(gebruikersnaam);
        JsonObjectBuilder responseObject = Json.createObjectBuilder();
        try {
            StringReader strReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(strReader);
            JsonObject jsonObject = jsonReader.readObject();
            if (jsonObject.getString("bijwerking1") != null && jsonObject.getString("bijwerking2") != null &&
                    jsonObject.getString("bijwerking3") != null && jsonObject.getString("notitie") != null &&
                    jsonObject.getString("datum") != null) {

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
        } catch (Exception e) {
            System.out.println(e);
            responseObject.add("message", "Error: " + e.getMessage());
        }

    }
}