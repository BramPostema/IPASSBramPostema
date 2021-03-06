package nl.hu.ipass.IpassTest;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        //TODO soms staat json op meerdere lines fix dit
        DokterTemplate test = GsonBuild.gsonMaker().fromJson(line, DokterTemplate.class);


        try{
            System.out.println(request.toString());
//            System.out.println(Arrays.toString(request.get("gebruikersnaam")));

            if (test.gebruikersnaam!=null && test.wachtwoord!=null && test.email!=null){


                if(Dokter.addDokter(test.gebruikersnaam, test.wachtwoord, test.email) != null){
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

