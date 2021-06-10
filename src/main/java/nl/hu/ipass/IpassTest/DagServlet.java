package nl.hu.ipass.IpassTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nl.hu.ipass.IpassTest.Inname;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

class DagTemplate{
    public String datum;
    public String bijwerking1;
    public String bijwerking2;
    public String bijwerking3;
    public String notitie;
}

@WebServlet(name = "dag", value = "/dag")
public class DagServlet extends HttpServlet {
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
        String url = "jdbc:sqlite:C:/sqlite/db/test.db";
        DatabaseCon.connect(url);


        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        DagTemplate test = GsonBuild.gsonMaker().fromJson(line, DagTemplate.class);
        try{
            if (test.bijwerking1!=null && test.datum!=null && test.notitie!=null){

                try {
                    LocalDate date = LocalDate.parse(test.datum);
                    Dag dag = new Dag(test.bijwerking1, test.notitie, date);
                    System.out.println(dag);
                }
                catch (DateTimeParseException e){

                    throw new Error("datum invalid");
                }

                //TODO: meer input format tests

                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(200);

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