import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public Connection connect(){
        Connection connection = null;
        try{
            Class.forName("");
            connection = (Connection) DriverManager.getConnection(
                    "jdbc://localhost:5432:5432/sales_db",
                    "postgres", "admin"
            );
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return connection;
    }
}
