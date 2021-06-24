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
    @Path("{comboinput}")
    public String doGet(@PathParam("comboinput") String comboinput) {
        String[] combo = comboinput.split(":");
        String gebruikersnaam = combo[0];
        String datum = combo[1];
        System.out.println(datum);
        System.out.println("Get innames voor: "+gebruikersnaam);
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        ArrayList<Inname> innames = Inname.getInnames(gebruikersnaam, datum);
        if (innames!=null){
            for (Inname inname : innames) {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
                objectBuilder.add("datum", inname.getDate().toString());
                objectBuilder.add("medicatie", inname.getMedicatie().getNaam());
                objectBuilder.add("tijd", inname.getTime().toString());
                objectBuilder.add("dosis", inname.getDosis());
                arrayBuilder.add(objectBuilder);
            }
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
        System.out.println("Maak inname voor: "+gebruikersnaam);
        JsonObjectBuilder responseObject = Json.createObjectBuilder();
        try {
            StringReader strReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(strReader);
            JsonObject jsonObject = jsonReader.readObject();

            if ((jsonObject.getString("medicatie") != null && jsonObject.getString("datum") != null) &&
                (jsonObject.getString("tijd") != null && jsonObject.getString("dosis") != null)){

                String medicatie = jsonObject.getString("medicatie");
                String dosis = jsonObject.getString("dosis");
                LocalTime tijd = LocalTime.parse(jsonObject.getString("tijd"));
                LocalDate date = LocalDate.parse(jsonObject.getString("datum"));
                Inname inname = new Inname(tijd, Double.parseDouble(dosis), new Medicatie(medicatie), date);
                Inname.addInname(inname, gebruikersnaam);
            }

        } catch (Exception e) {
            System.out.println(e);
            responseObject.add("message", "Error: " + e.getMessage());
        }

    }
}