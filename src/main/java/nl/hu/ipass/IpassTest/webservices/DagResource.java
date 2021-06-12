package nl.hu.ipass.IpassTest.webservices;

import nl.hu.ipass.IpassTest.Dag;
import nl.hu.ipass.IpassTest.Dokter;

import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    public void maakDag(String jsonBody){
        JsonObjectBuilder responseObject = Json.createObjectBuilder();
        try{
            StringReader strReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(strReader);
            JsonObject jsonObject = jsonReader.readObject();
            if(jsonObject.getString("bijwerking1")!=null && jsonObject.getString("bijwerking2")!=null
                    && jsonObject.getString("bijwerking3")!=null && jsonObject.getString("notitie")!=null) {
                System.out.println("1");
                String bijwerking1 = jsonObject.getString("bijwerking1");
                System.out.println("2");
                String bijwerking2 = jsonObject.getString("bijwerking2");
                System.out.println(bijwerking2);
                System.out.println("3");
                String bijwerking3 = jsonObject.getString("bijwerking3");
                System.out.println(bijwerking3);
                System.out.println("4");
                LocalDate date = LocalDate.parse(jsonObject.getString("datum"));
                System.out.println(date);
                System.out.println("5");
                String notitie = jsonObject.getString("notitie");
                System.out.println(notitie);
                System.out.println("6");
                ArrayList<String> bijwerkingen = new ArrayList<>();
                bijwerkingen.add(bijwerking1);
                bijwerkingen.add(bijwerking2);
                bijwerkingen.add(bijwerking3);
                Dag dag = new Dag(bijwerkingen, notitie, date);
                Dag.addDag(dag);
            }

//            if(new Dag(bijwerking1, wachtwoord, email)!=null){
//                responseObject.add("message", "het ging goed");
//            }
//            else {
//                throw new Exception("Niet alles is ingevuld");
//            }

        }catch (Exception e){
            System.out.println(e);
            responseObject.add("message", "Error: "+e.getMessage());
        }

    }
}
