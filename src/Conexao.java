import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection connect(){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/sales_db",
                    "admin", "admin"
            );
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return connection;
    }

    public void disconnect(Connection connection){
        try{
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

}
