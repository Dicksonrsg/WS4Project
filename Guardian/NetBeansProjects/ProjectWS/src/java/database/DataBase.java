
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
 
    public Connection connection = null;
    
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE = "booking_db";
    private final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    private final String USER = "root";
    /*Note: change password according to local db.*/
    private final String PASSWORD = "senac";
    
    public boolean connect(){
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
        }
        return false;
    }
    
    public boolean disconnect(){
        try{
            connection.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
        return false;
    }
}
