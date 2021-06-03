package nl.hu.ipass.Resources;

import nl.hu.ipass.IpassTest.Dag;
import nl.hu.ipass.IpassTest.Patiënt;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Path("dagaanmaken")
public class DagResource {
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response MakeDag() {
//        Dag dag = new Dag();
//        if (dagenLijst.isEmpty()) {
//            Map<String, String> messages = new HashMap<>();
//            messages.put("error", "no lists present");
//            return Response.status(409).entity(messages).build();
//        }
//        return Response.ok(dagenLijst).build();
//    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDag(@FormParam("Datum") Date date, @FormParam("Notitie") String notitie, @FormParam("bijwerking1") ArrayList<String> ja) {
        System.out.println("hahallo");
        Patiënt p = new Patiënt("Isa", "Isa", "Isa.Isa@gmail.com");
        ArrayList<Dag> dagen = p.getPatiëntDagen();
        for (Dag dag : dagen) {
            if(dag.getDatum() != LocalDate.parse((CharSequence) date)){
                System.out.println("dag bestaat nog neit");
        }
        }
//        if (shopper1 != null) {
//            return Response.status(Response.Status.CONFLICT).entity(
//                    new AbstractMap.SimpleEntry<String, String>("error", "Shopper bestaat al")
//            ).build();
//        }
//
//        shopper1 = new Shopper(name);
        Dag dag = new Dag(ja, notitie, LocalDate.parse((CharSequence) date));
        System.out.println(dag);
        return Response.ok(dag).build();

    }
}
