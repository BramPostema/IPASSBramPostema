package nl.hu.ipass.IpassTest;

import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.*;

public final class DatabaseCon {
    private static Connection conn;
    private static String url;

    public static Connection connect(String url){
        if (DatabaseCon.url == null){
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

    public static ResultSet executeQuery(String query) throws SQLException{

            Connection con = DatabaseCon.getConn();
            Statement statement = con.createStatement();
            return statement.executeQuery(query);


    }
    public static Connection getConn() throws SQLException{
        if (DatabaseCon.conn == null){
            throw new Error("shit is null");
        }
        else if (DatabaseCon.conn.isValid(0)){
            return DatabaseCon.conn;
        }
        else{
            throw new Error("verbinding faalt");
        }

    }
}
