package nl.hu.ipass.IpassTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        DatabaseCon.connect();
        System.out.println(Patiënt.getPatient("klaas"));

    }
}
