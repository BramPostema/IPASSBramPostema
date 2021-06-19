package nl.hu.ipass.IpassTest;

import java.sql.*;

public final class DatabaseCon {
    private static Connection conn;
    private static String url;

    public static Connection connect(){
        String url = "jdbc:sqlite:/sqlite/db/test.db";
        if (DatabaseCon.url == null){
            try {
                DatabaseCon.conn = DriverManager.getConnection(url);
                DatabaseCon.url = url;
            }
            catch(SQLException ignored){
            }
            try {
                DatabaseCon.conn = DriverManager.getConnection(url);
                DatabaseCon.url = url;
            }
            catch(SQLException e){
                System.out.println("nogsteeds stuk");
                System.out.println(e);
            }
        }
        return conn;
    }
}
