package DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection connect(){
        Dotenv dotenv = Dotenv.load();
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    dotenv.get("database_url"),
                    dotenv.get("database_user"), dotenv.get("database_password")
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
