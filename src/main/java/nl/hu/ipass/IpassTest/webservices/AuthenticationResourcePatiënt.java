package nl.hu.ipass.IpassTest.webservices;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.ipass.IpassTest.DatabaseCon;
import nl.hu.ipass.IpassTest.Patiënt;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.Calendar;

@Path("login")
public class AuthenticationResourcePatiënt {
    public static final Key key = MacProvider.generateKey();
    @GET
    public String authtest(){
        return "hij doet get";
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("patient")
    public Response authenticationLoginPatient(@FormParam("Gebruikersnaam") String gebruikersnaamInvoer, @FormParam("wachtwoord") String wachtwoord){
        String role = validatePatiënt(gebruikersnaamInvoer, wachtwoord);
        System.out.println(role);
        String token = createToken(gebruikersnaamInvoer, role);
        return Response.ok(new AbstractMap.SimpleEntry<>("JWT", token)).build();
    }

    private String createToken(String gebruikersnaamInvoer, String role) {
        Calendar expirationMoment = Calendar.getInstance();
        expirationMoment.add(Calendar.HOUR, 1);
        return Jwts.builder()
                .setSubject(gebruikersnaamInvoer)
                .setExpiration(expirationMoment.getTime())
                .claim(gebruikersnaamInvoer, role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
    public String validatePatiënt(String gebruikersnaamInvoer, String wachtwoordInvoer){
        try {
            Connection con = DatabaseCon.connect();
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select gebruikersnaam, wachtwoord from Patiënt where gebruikersnaam='"+gebruikersnaamInvoer+"'");
            System.out.println(res);
            System.out.println(res.getString(1)+res.getString(2));
            if(res.getString(1)==gebruikersnaamInvoer && res.getString(2)==wachtwoordInvoer){
                return "patiënt";
            }else {
                return null;
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
