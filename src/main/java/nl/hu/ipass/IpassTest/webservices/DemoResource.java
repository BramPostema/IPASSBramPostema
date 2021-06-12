package nl.hu.ipass.IpassTest.webservices;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/demo")
public class DemoResource {

    @GET
    public String demoService() {

        return "hello";
    }


}


