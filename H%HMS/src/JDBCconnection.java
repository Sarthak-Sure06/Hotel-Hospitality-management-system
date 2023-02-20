import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCconnection {
    Connection c;
    Statement s;
   
    JDBCconnection(){
      
        try {

            //register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection object
            String user = "root";
            String pass = "Sarthaksaxena@#$";
            String url = "jdbc:mysql://localhost : 3306/HHmanagement";
            c = DriverManager.getConnection(url, user, pass);
            
            // create statement object;
            s = c.createStatement();

            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCconnection();
    }
    
}
