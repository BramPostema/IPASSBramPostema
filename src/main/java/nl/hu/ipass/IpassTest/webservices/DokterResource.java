package nl.hu.ipass.IpassTest.webservices;


import nl.hu.ipass.IpassTest.Dokter;

import javax.json.*;
import javax.ws.rs.*;
import java.io.StringReader;


@Path("/dokter")
public class DokterResource {

    @GET
    public String getDokterService() {
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
    @Produces("application/json")
    public void maakDokterService(String jsonBody){
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
            if(Dokter.addDokter(naam, wachtwoord, email)!=null){
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

//    @POST
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String url = "jdbc:sqlite:/sqlite/db/test.db";
////        DatabaseCon.connect(url);
//        Connection con = DatabaseCon.connect(url);
//
//
//        BufferedReader reader = request.getReader();
//        String line = reader.readLine();
//        //TODO soms staat json op meerdere lines fix dit
//        DokterTemplate test = GsonBuild.gsonMaker().fromJson(line, DokterTemplate.class);
//
//
//        try{
//            System.out.println(request.toString());
////            System.out.println(Arrays.toString(request.get("gebruikersnaam")));
//
//            if (test.gebruikersnaam!=null && test.wachtwoord!=null && test.email!=null){
//
//
//                if(Dokter.addDokter(test.gebruikersnaam, test.wachtwoord, test.email) != null){
//                    System.out.println("goed");
//                    response.setStatus(200);
//                }
//                else{
//                    System.out.println("faalt");
//                    response.setStatus(400);
//                }
//
//                response.setContentType("text/html");
//                response.setCharacterEncoding("UTF-8");
//
//
//            }else {
//                System.out.println("mist input string");
//                response.sendError(400, "mist input");
//                throw new Error("input invalid");
//            }
//
//        }
//        catch (Error e){
//            System.out.println(e.getMessage());
//        }
//    }
}
