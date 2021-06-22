package nl.hu.ipass.IpassTest;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public final class DatabaseCon {
    private static String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "GoedWachtwoord12";
    private static Connection conn;

    private static String url;

//    public static Connection connect(){
//        String url = "jdbc:sqlite:C:\\Users\\bramp\\IdeaProjects\\blok3\\IPASSBramPostema\\sqlite\\db\\test.db";
//        if (DatabaseCon.url == null){
//            try {
//                DatabaseCon.conn = DriverManager.getConnection(url);
//                DatabaseCon.url = url;
//            }
//            catch(SQLException ignored){
//            }
//            try {
//                DatabaseCon.conn = DriverManager.getConnection(url);
//                DatabaseCon.url = url;
//            }
//            catch(SQLException e){
//                System.out.println("nogsteeds stuk");
//                System.out.println(e);
//
//            }
//        }
//        return conn;
//    }
    public static Connection connect() {
        try {
            DatabaseCon.conn = getConnection(jdbcURL, username, password);
        }catch (SQLException e){
            try {
                DatabaseCon.conn = getConnection(jdbcURL, username, password);
            }catch (SQLException ex){
                System.out.println(ex.getMessage()+"blijft niet werken");
            }
        }
        return conn;

}

}
