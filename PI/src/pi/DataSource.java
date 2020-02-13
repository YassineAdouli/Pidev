
package pi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author House
 */

public class DataSource {
     String url = "jdbc:mysql://localhost:3306/TAKTAK";
     String login = "root";
     String pwd = "";
    public  static DataSource db;
    public Connection con;
    private DataSource() {
         try {
             con=DriverManager.getConnection(url, login, pwd);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
    public Connection  getConnection()
    {
    return con;
    }     
    public static DataSource getInstance()
    {if(db==null)
        db=new DataSource();
    return db;
    }     
     
     
     
}
