package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) {
        selectAll();
    }
    
    private static Connection connect(String URL) {
        Connection connection = null;
        try {
        String url = "jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata5P1\\KATA5.db";
         connection = DriverManager.getConnection(url);
         System.out.println("Connexión a SQLite establecida");
        }
        catch (SQLException exception){
            System.out.println("Error en onnexión a SQLite" + exception.getMessage());
        }
        
        finally {
            try {
                if (connection != null){
                    connection.close();
                }
                
            }
            catch (SQLException exception){
            System.out.println("Error en onnexión a SQLite" + exception.getMessage());
            return connection;
        }
            
   }
        return connection;
}
   
   private static void selectAll(){
       Connection connection = null;
       String sql="SELECT * FROM PEOPLE";
       try {
        String url = "jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata5P1\\KATA5.db";
         connection = DriverManager.getConnection(url);
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         
         while (rs.next()) {
         System.out.println(rs.getInt("id") +  "\t" + 
         rs.getString("Nombre") + "\t" +
         rs.getString("Apellidos") + "\t" +
         rs.getString("Departamento") + "\t");
}
       }
       catch (SQLException e) {
        System.out.println(e.getMessage());
        }       
   }
    
}
