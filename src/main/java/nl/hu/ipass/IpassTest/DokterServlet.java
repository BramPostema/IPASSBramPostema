package nl.hu.ipass.IpassTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

class DokterTemplate{
    public String gebruikersnaam;
    public String wachtwoord;
    public String email;
}


@WebServlet(name = "dokter", value = "/dokter")
public class DokterServlet extends HttpServlet {
//static ArrayList<Dag> dagen = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");


        try (PrintWriter writer = res.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>MyServlet.java:doGet(): Servlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>This is a simple java servlet.</h1>");

            writer.println("</body>");
            writer.println("</html>");
        }
        System.out.println("hallo");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DokterTemplate test;
        String url = "jdbc:sqlite:C:/sqlite/db/test.db";
//        Connection con = DatabaseCon.connect(url);
        DatabaseCon.connect(url);
        Gson g = new Gson();

        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        //TODO soms staat json op meerdere lines fix dit
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        test = gson.fromJson(line, DokterTemplate.class);
//        Dokter.addDokter(test.gebruikersnaam, test.wachtwoord, test.email);
        String gebnm =test.gebruikersnaam;
        String testww = test.wachtwoord;
        String testEmail = test.email;

        try{
            System.out.println(request.toString());
//            System.out.println(Arrays.toString(request.get("gebruikersnaam")));
            System.out.println(gebnm);
            System.out.println(testww);
            System.out.println(testEmail);
            if (gebnm!=null && testww!=null && testEmail!=null){


                if(Dokter.addDokter(gebnm, testww, testEmail) != null){
                    System.out.println("goed");

                    response.setStatus(200);
                }
                else{
                    System.out.println("faalt");
                    response.setStatus(400);
                }

                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");


            }else {
                System.out.println("mist input string");
                response.sendError(400, "mist input");
                throw new Error("input invalid");
            }

        }
        catch (Error e){
            System.out.println(e.getMessage());
        }
    }

}

