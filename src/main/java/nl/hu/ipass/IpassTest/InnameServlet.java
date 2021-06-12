package nl.hu.ipass.IpassTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

@WebServlet(name = "Inname", value = "/inname")
public class InnameServlet extends HttpServlet {

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
        try{
            if (request.getParameterValues("dosis")!=null && request.getParameterValues("medicatie")!=null && request.getParameterValues("tijd")!=null){

                String bijwerking1 = request.getParameterValues("bijwerking1")[0];
                String naam = request.getParameterValues("Naam")[0];
                String notitie = request.getParameterValues("Notitie")[0];
                String datum = request.getParameterValues("Datum")[0];
                ArrayList<String> bijwerkingen = new ArrayList<>();
                bijwerkingen.add(bijwerking1);

                try {
                    LocalDate date = LocalDate.parse(datum);
                    Dag dag = new Dag(bijwerkingen, notitie, date);
                    System.out.println(dag);
                }
                catch (DateTimeParseException e){

                    throw new Error("datum invalid");
                }

                //TODO: meer input format tests

                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(200);
                return;

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

