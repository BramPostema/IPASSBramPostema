package nl.hu.ipass.IpassTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DatabaseCon.connect();
        System.out.println(Patiënt.getPatient("klaas"));
        Patiënt.getDagen("Asi");
        Patiënt.getDagen("Isa");
        if(Patiënt.validateInlog("klaas", "1234")){
            System.out.println("hij doet het 1");
        }else {
            System.out.println("hij doet het niet 1");
        }
        if(Patiënt.validateInlog("s", "1234")){
            System.out.println("hij doet het 2");
        }else {
            System.out.println("hij doet het niet 2");
        }
        System.out.println(Patiënt.getWachtwoordDatabase("klaas"));
        System.out.println(Patiënt.getEmailDatabase("klaas"));
    }
}
