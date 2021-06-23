package nl.hu.ipass.IpassTest.webservices;

import nl.hu.ipass.IpassTest.Dag;
import nl.hu.ipass.IpassTest.Inname;
import nl.hu.ipass.IpassTest.Medicatie;
import nl.hu.ipass.IpassTest.Patiënt;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalTime;
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
    @Path("{gebruikersnaam}")
    public void maakInname(@PathParam("gebruikersnaam") String gebruikersnaam, String jsonBody) {
        System.out.println(gebruikersnaam);
        JsonObjectBuilder responseObject = Json.createObjectBuilder();
        try {
            StringReader strReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(strReader);
            JsonObject jsonObject = jsonReader.readObject();
            if (jsonObject.getString("medicatie") != null && jsonObject.getString("datum") != null &&
                    jsonObject.getString("tijd") != null && jsonObject.getString("dosis") != null){

                String medicatie = jsonObject.getString("medicatie");
                String dosis = jsonObject.getString("dosis");
                LocalTime tijd = LocalTime.parse(jsonObject.getString("tijd"));
                LocalDate date = LocalDate.parse(jsonObject.getString("datum"));
                System.out.println(date);
                System.out.println(tijd);
                System.out.println(dosis);
                System.out.println(medicatie);
                Inname inname = new Inname(tijd, Double.parseDouble(dosis), new Medicatie(medicatie), date);
                Inname.addInname(inname, gebruikersnaam);

            }
        } catch (Exception e) {
            System.out.println(e);
            responseObject.add("message", "Error: " + e.getMessage());
        }

    }
}